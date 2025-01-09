package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getcategoriapordescrip extends GXProcedure
{
   public getcategoriapordescrip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getcategoriapordescrip.class ), "" );
   }

   public getcategoriapordescrip( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String aP2 ,
                              String[] aP3 )
   {
      getcategoriapordescrip.this.aP4 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String[] aP3 ,
                        boolean[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             boolean[] aP4 )
   {
      getcategoriapordescrip.this.AV10CliCod = aP0;
      getcategoriapordescrip.this.AV12ConveCodigo = aP1;
      getcategoriapordescrip.this.AV9CatDescrip = aP2;
      getcategoriapordescrip.this.aP3 = aP3;
      getcategoriapordescrip.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV13PaiCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.clientegetpais(remoteHandle, context).execute( AV10CliCod, GXv_int2) ;
      getcategoriapordescrip.this.GXt_int1 = GXv_int2[0] ;
      AV13PaiCod = GXt_int1 ;
      GXv_int3[0] = AV14CliConveVer ;
      new web.getversiondeconvenio(remoteHandle, context).execute( AV10CliCod, AV13PaiCod, AV12ConveCodigo, GXv_int3) ;
      getcategoriapordescrip.this.AV14CliConveVer = GXv_int3[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "pai ", "")+GXutil.trim( GXutil.str( AV13PaiCod, 4, 0))+httpContext.getMessage( " cliconvever ", "")+GXutil.trim( GXutil.str( AV14CliConveVer, 6, 0))+httpContext.getMessage( " clicod ", "")+GXutil.trim( GXutil.str( AV10CliCod, 6, 0))+httpContext.getMessage( " convenio ", "")+AV12ConveCodigo+httpContext.getMessage( " &CatDescrip ", "")+GXutil.trim( AV9CatDescrip)) ;
      /* Using cursor P002E2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV14CliConveVer), Short.valueOf(AV13PaiCod), AV12ConveCodigo, AV9CatDescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A676CatDescripSinAc = P002E2_A676CatDescripSinAc[0] ;
         A1565CliConvenio = P002E2_A1565CliConvenio[0] ;
         A1564CliPaiConve = P002E2_A1564CliPaiConve[0] ;
         A3CliCod = P002E2_A3CliCod[0] ;
         A8CatCodigo = P002E2_A8CatCodigo[0] ;
         AV8CatCodigo = A8CatCodigo ;
         AV11existe = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getcategoriapordescrip.this.AV8CatCodigo;
      this.aP4[0] = getcategoriapordescrip.this.AV11existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8CatCodigo = "" ;
      GXv_int2 = new short[1] ;
      GXv_int3 = new int[1] ;
      AV17Pgmname = "" ;
      scmdbuf = "" ;
      P002E2_A676CatDescripSinAc = new String[] {""} ;
      P002E2_A1565CliConvenio = new String[] {""} ;
      P002E2_A1564CliPaiConve = new short[1] ;
      P002E2_A3CliCod = new int[1] ;
      P002E2_A8CatCodigo = new String[] {""} ;
      A676CatDescripSinAc = "" ;
      A1565CliConvenio = "" ;
      A8CatCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getcategoriapordescrip__default(),
         new Object[] {
             new Object[] {
            P002E2_A676CatDescripSinAc, P002E2_A1565CliConvenio, P002E2_A1564CliPaiConve, P002E2_A3CliCod, P002E2_A8CatCodigo
            }
         }
      );
      AV17Pgmname = "getCategoriaPorDescrip" ;
      /* GeneXus formulas. */
      AV17Pgmname = "getCategoriaPorDescrip" ;
      Gx_err = (short)(0) ;
   }

   private short AV13PaiCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV14CliConveVer ;
   private int GXv_int3[] ;
   private int A3CliCod ;
   private String AV12ConveCodigo ;
   private String AV8CatCodigo ;
   private String AV17Pgmname ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A8CatCodigo ;
   private boolean AV11existe ;
   private String AV9CatDescrip ;
   private String A676CatDescripSinAc ;
   private boolean[] aP4 ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private String[] P002E2_A676CatDescripSinAc ;
   private String[] P002E2_A1565CliConvenio ;
   private short[] P002E2_A1564CliPaiConve ;
   private int[] P002E2_A3CliCod ;
   private String[] P002E2_A8CatCodigo ;
}

final  class getcategoriapordescrip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P002E2", "SELECT CatDescripSinAc, CliConvenio, CliPaiConve, CliCod, CatCodigo FROM Categoria1 WHERE (CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?)) AND (CatDescripSinAc = ( ?)) ORDER BY CliCod, CliPaiConve, CliConvenio  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 40);
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
               stmt.setVarchar(4, (String)parms[3], 400);
               return;
      }
   }

}

