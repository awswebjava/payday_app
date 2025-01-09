package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getultifecescala extends GXProcedure
{
   public getultifecescala( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getultifecescala.class ), "" );
   }

   public getultifecescala( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( int aP0 ,
                                     short aP1 ,
                                     String aP2 ,
                                     String aP3 )
   {
      getultifecescala.this.aP4 = new java.util.Date[] {GXutil.nullDate()};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        String aP3 ,
                        java.util.Date[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String aP3 ,
                             java.util.Date[] aP4 )
   {
      getultifecescala.this.AV9CliCod = aP0;
      getultifecescala.this.AV11CliPaiConve = aP1;
      getultifecescala.this.AV10CliConvenio = aP2;
      getultifecescala.this.AV8CatCodigo = aP3;
      getultifecescala.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV15GXLvl1 = (byte)(0) ;
      /* Using cursor P020U2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV11CliPaiConve), AV10CliConvenio, AV8CatCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P020U2_A3CliCod[0] ;
         A1564CliPaiConve = P020U2_A1564CliPaiConve[0] ;
         A1565CliConvenio = P020U2_A1565CliConvenio[0] ;
         A8CatCodigo = P020U2_A8CatCodigo[0] ;
         A907CatVigencia = P020U2_A907CatVigencia[0] ;
         AV15GXLvl1 = (byte)(1) ;
         AV12ultiCatVigencia = A907CatVigencia ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV15GXLvl1 == 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV16Pgmname, httpContext.getMessage( "none", "")) ;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV16Pgmname, httpContext.getMessage( "&CliCod: ", "")+GXutil.trim( GXutil.str( AV9CliCod, 6, 0))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV16Pgmname, httpContext.getMessage( "&CliPaiConve: ", "")+GXutil.trim( GXutil.str( AV11CliPaiConve, 4, 0))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV16Pgmname, httpContext.getMessage( "&CliConvenio: ", "")+GXutil.trim( AV10CliConvenio)) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV16Pgmname, httpContext.getMessage( "&CatCodigo: ", "")+GXutil.trim( AV8CatCodigo)) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV16Pgmname, httpContext.getMessage( "&ultiCatVigencia: ", "")+GXutil.trim( localUtil.dtoc( AV12ultiCatVigencia, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getultifecescala.this.AV12ultiCatVigencia;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12ultiCatVigencia = GXutil.nullDate() ;
      scmdbuf = "" ;
      P020U2_A3CliCod = new int[1] ;
      P020U2_A1564CliPaiConve = new short[1] ;
      P020U2_A1565CliConvenio = new String[] {""} ;
      P020U2_A8CatCodigo = new String[] {""} ;
      P020U2_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      A1565CliConvenio = "" ;
      A8CatCodigo = "" ;
      A907CatVigencia = GXutil.nullDate() ;
      AV16Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getultifecescala__default(),
         new Object[] {
             new Object[] {
            P020U2_A3CliCod, P020U2_A1564CliPaiConve, P020U2_A1565CliConvenio, P020U2_A8CatCodigo, P020U2_A907CatVigencia
            }
         }
      );
      AV16Pgmname = "getUltiFecEscala" ;
      /* GeneXus formulas. */
      AV16Pgmname = "getUltiFecEscala" ;
      Gx_err = (short)(0) ;
   }

   private byte AV15GXLvl1 ;
   private short AV11CliPaiConve ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private String AV10CliConvenio ;
   private String AV8CatCodigo ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A8CatCodigo ;
   private String AV16Pgmname ;
   private java.util.Date AV12ultiCatVigencia ;
   private java.util.Date A907CatVigencia ;
   private java.util.Date[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P020U2_A3CliCod ;
   private short[] P020U2_A1564CliPaiConve ;
   private String[] P020U2_A1565CliConvenio ;
   private String[] P020U2_A8CatCodigo ;
   private java.util.Date[] P020U2_A907CatVigencia ;
}

final  class getultifecescala__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P020U2", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia FROM Categoriavalores1 WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CatCodigo = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               return;
      }
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
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               return;
      }
   }

}

