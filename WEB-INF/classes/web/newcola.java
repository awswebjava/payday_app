package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newcola extends GXProcedure
{
   public newcola( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newcola.class ), "" );
   }

   public newcola( int remoteHandle ,
                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        byte aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             byte aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 )
   {
      newcola.this.AV13CliCod = aP0;
      newcola.this.AV12EmpCod = aP1;
      newcola.this.AV14ColaLiqNro = aP2;
      newcola.this.AV11ColaEstado = aP3;
      newcola.this.AV10ColaMicroservicio = aP4;
      newcola.this.AV9colaJsonReq = aP5;
      newcola.this.AV15daemonUUID = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_dtime1 = AV8ahora ;
      GXv_dtime2[0] = GXt_dtime1 ;
      new web.getahora(remoteHandle, context).execute( AV13CliCod, GXv_dtime2) ;
      newcola.this.GXt_dtime1 = GXv_dtime2[0] ;
      AV8ahora = GXt_dtime1 ;
      /*
         INSERT RECORD ON TABLE Cola

      */
      A3CliCod = AV13CliCod ;
      A1EmpCod = AV12EmpCod ;
      A2380ColaUUID = java.util.UUID.randomUUID( ) ;
      A2382ColaEstado = AV11ColaEstado ;
      A2381ColaMicroservicio = AV10ColaMicroservicio ;
      A2395colaJsonReq = AV9colaJsonReq ;
      A2396ColaJsonRes = "" ;
      A2397ColaCre = AV8ahora ;
      A2383ColaLiqNro = AV14ColaLiqNro ;
      A2384daemonUUID = AV15daemonUUID ;
      /* Using cursor P02JO2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A2380ColaUUID, Byte.valueOf(A2382ColaEstado), A2381ColaMicroservicio, A2395colaJsonReq, A2396ColaJsonRes, A2397ColaCre, Integer.valueOf(A2383ColaLiqNro), A2384daemonUUID});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Cola");
      if ( (pr_default.getStatus(0) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV18Pgmname, httpContext.getMessage( "ColaUUID ", "")+A2380ColaUUID.toString()+httpContext.getMessage( " &daemonUUID ", "")+GXutil.trim( AV15daemonUUID)) ;
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "newcola");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8ahora = GXutil.resetTime( GXutil.nullDate() );
      GXt_dtime1 = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime2 = new java.util.Date[1] ;
      A2380ColaUUID = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      A2381ColaMicroservicio = "" ;
      A2395colaJsonReq = "" ;
      A2396ColaJsonRes = "" ;
      A2397ColaCre = GXutil.resetTime( GXutil.nullDate() );
      A2384daemonUUID = "" ;
      Gx_emsg = "" ;
      AV18Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newcola__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      AV18Pgmname = "newCola" ;
      /* GeneXus formulas. */
      AV18Pgmname = "newCola" ;
      Gx_err = (short)(0) ;
   }

   private byte AV11ColaEstado ;
   private byte A2382ColaEstado ;
   private short AV12EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV14ColaLiqNro ;
   private int GX_INS298 ;
   private int A3CliCod ;
   private int A2383ColaLiqNro ;
   private String AV10ColaMicroservicio ;
   private String AV15daemonUUID ;
   private String A2381ColaMicroservicio ;
   private String A2384daemonUUID ;
   private String Gx_emsg ;
   private String AV18Pgmname ;
   private java.util.Date AV8ahora ;
   private java.util.Date GXt_dtime1 ;
   private java.util.Date GXv_dtime2[] ;
   private java.util.Date A2397ColaCre ;
   private String AV9colaJsonReq ;
   private String A2395colaJsonReq ;
   private String A2396ColaJsonRes ;
   private java.util.UUID A2380ColaUUID ;
   private IDataStoreProvider pr_default ;
}

final  class newcola__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P02JO2", "SAVEPOINT gxupdate;INSERT INTO Cola(CliCod, EmpCod, ColaUUID, ColaEstado, ColaMicroservicio, colaJsonReq, ColaJsonRes, ColaCre, ColaLiqNro, daemonUUID) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setGUID(3, (java.util.UUID)parms[2]);
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setVarchar(6, (String)parms[5], 30000, false);
               stmt.setVarchar(7, (String)parms[6], 30000, false);
               stmt.setDateTime(8, (java.util.Date)parms[7], false, true);
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setString(10, (String)parms[9], 36);
               return;
      }
   }

}

