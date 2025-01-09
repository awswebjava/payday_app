package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getcatbasico extends GXProcedure
{
   public getcatbasico( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getcatbasico.class ), "" );
   }

   public getcatbasico( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           String aP1 ,
                                           String aP2 ,
                                           java.util.Date aP3 )
   {
      getcatbasico.this.aP4 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        java.util.Date aP3 ,
                        java.math.BigDecimal[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             java.util.Date aP3 ,
                             java.math.BigDecimal[] aP4 )
   {
      getcatbasico.this.AV10CliCod = aP0;
      getcatbasico.this.AV11ConveCodigo = aP1;
      getcatbasico.this.AV9CatCodigo = aP2;
      getcatbasico.this.AV13LiqPeriodo = aP3;
      getcatbasico.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV15PaiCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.clientegetpais(remoteHandle, context).execute( AV10CliCod, GXv_int2) ;
      getcatbasico.this.GXt_int1 = GXv_int2[0] ;
      AV15PaiCod = GXt_int1 ;
      GXv_int3[0] = AV16CliConveVer ;
      new web.getversiondeconvenio(remoteHandle, context).execute( AV10CliCod, AV15PaiCod, AV11ConveCodigo, GXv_int3) ;
      getcatbasico.this.AV16CliConveVer = GXv_int3[0] ;
      GXv_int2[0] = AV17CliPaiConve ;
      new web.getpaisdeconvenio(remoteHandle, context).execute( AV11ConveCodigo, AV15PaiCod, GXv_int2) ;
      getcatbasico.this.AV17CliPaiConve = GXv_int2[0] ;
      /* Using cursor P002F2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV16CliConveVer), Short.valueOf(AV15PaiCod), AV11ConveCodigo, AV9CatCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A8CatCodigo = P002F2_A8CatCodigo[0] ;
         A1565CliConvenio = P002F2_A1565CliConvenio[0] ;
         A1564CliPaiConve = P002F2_A1564CliPaiConve[0] ;
         A3CliCod = P002F2_A3CliCod[0] ;
         GXv_boolean4[0] = false ;
         GXv_char5[0] = "" ;
         GXv_decimal6[0] = AV8CatBasico ;
         new web.getescalasalarialvigente3(remoteHandle, context).execute( A3CliCod, AV17CliPaiConve, A1565CliConvenio, A8CatCodigo, AV13LiqPeriodo, (byte)(1), httpContext.getMessage( "TOTAL", ""), GXv_boolean4, GXv_char5, GXv_decimal6) ;
         getcatbasico.this.AV8CatBasico = GXv_decimal6[0] ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getcatbasico.this.AV8CatBasico;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8CatBasico = DecimalUtil.ZERO ;
      GXv_int3 = new int[1] ;
      GXv_int2 = new short[1] ;
      scmdbuf = "" ;
      P002F2_A8CatCodigo = new String[] {""} ;
      P002F2_A1565CliConvenio = new String[] {""} ;
      P002F2_A1564CliPaiConve = new short[1] ;
      P002F2_A3CliCod = new int[1] ;
      A8CatCodigo = "" ;
      A1565CliConvenio = "" ;
      GXv_boolean4 = new boolean[1] ;
      GXv_char5 = new String[1] ;
      GXv_decimal6 = new java.math.BigDecimal[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getcatbasico__default(),
         new Object[] {
             new Object[] {
            P002F2_A8CatCodigo, P002F2_A1565CliConvenio, P002F2_A1564CliPaiConve, P002F2_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV15PaiCod ;
   private short GXt_int1 ;
   private short AV17CliPaiConve ;
   private short GXv_int2[] ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV16CliConveVer ;
   private int GXv_int3[] ;
   private int A3CliCod ;
   private java.math.BigDecimal AV8CatBasico ;
   private java.math.BigDecimal GXv_decimal6[] ;
   private String AV11ConveCodigo ;
   private String AV9CatCodigo ;
   private String scmdbuf ;
   private String A8CatCodigo ;
   private String A1565CliConvenio ;
   private String GXv_char5[] ;
   private java.util.Date AV13LiqPeriodo ;
   private boolean GXv_boolean4[] ;
   private java.math.BigDecimal[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P002F2_A8CatCodigo ;
   private String[] P002F2_A1565CliConvenio ;
   private short[] P002F2_A1564CliPaiConve ;
   private int[] P002F2_A3CliCod ;
}

final  class getcatbasico__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P002F2", "SELECT CatCodigo, CliConvenio, CliPaiConve, CliCod FROM Categoria1 WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CatCodigo = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
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

