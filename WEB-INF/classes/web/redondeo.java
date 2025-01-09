package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class redondeo extends GXProcedure
{
   public redondeo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( redondeo.class ), "" );
   }

   public redondeo( int remoteHandle ,
                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           short aP1 ,
                           int aP2 ,
                           int aP3 ,
                           String aP4 ,
                           String aP5 ,
                           java.math.BigDecimal aP6 ,
                           java.math.BigDecimal[] aP7 ,
                           String[] aP8 ,
                           String[] aP9 )
   {
      redondeo.this.aP10 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        String aP5 ,
                        java.math.BigDecimal aP6 ,
                        java.math.BigDecimal[] aP7 ,
                        String[] aP8 ,
                        String[] aP9 ,
                        byte[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String aP5 ,
                             java.math.BigDecimal aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             String[] aP8 ,
                             String[] aP9 ,
                             byte[] aP10 )
   {
      redondeo.this.AV8CliCod = aP0;
      redondeo.this.AV12EmpCod = aP1;
      redondeo.this.AV9LiqNro = aP2;
      redondeo.this.AV10LegNumero = aP3;
      redondeo.this.AV11ConCodigo = aP4;
      redondeo.this.AV13ProcesoLiquidacion = aP5;
      redondeo.this.AV30parmNetoImportes = aP6;
      redondeo.this.aP7 = aP7;
      redondeo.this.aP8 = aP8;
      redondeo.this.aP9 = aP9;
      redondeo.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV14LiqDCalculado = (byte)(1) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "&&parmNetoImportes ", "")+GXutil.trim( GXutil.str( AV30parmNetoImportes, 14, 2))) ;
      if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV30parmNetoImportes)==0) )
      {
         GXv_int1[0] = AV23paicod ;
         new web.clientegetpais(remoteHandle, context).execute( AV8CliCod, GXv_int1) ;
         redondeo.this.AV23paicod = GXv_int1[0] ;
         GXv_char2[0] = AV25noRemuTipoConCod ;
         new web.gettipoconcepto(remoteHandle, context).execute( AV23paicod, "NRE", GXv_char2) ;
         redondeo.this.AV25noRemuTipoConCod = GXv_char2[0] ;
         GXv_char2[0] = AV26remuTipoConCod ;
         new web.gettipoconcepto(remoteHandle, context).execute( AV23paicod, "REM", GXv_char2) ;
         redondeo.this.AV26remuTipoConCod = GXv_char2[0] ;
         GXv_char2[0] = AV27descuentoTipoConCod ;
         new web.gettipoconcepto(remoteHandle, context).execute( AV23paicod, "DES", GXv_char2) ;
         redondeo.this.AV27descuentoTipoConCod = GXv_char2[0] ;
         AV24cant = (short)(0) ;
         AV18LiqDImpReCalcu = DecimalUtil.ZERO ;
         AV15auxLiqDCalculado = (byte)(0) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV36Pgmname, httpContext.getMessage( "&concodigo \"", "")+AV11ConCodigo+"\"") ;
         /* Optimized group. */
         /* Using cursor P026C2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV9LiqNro), Integer.valueOf(AV10LegNumero), AV11ConCodigo, AV25noRemuTipoConCod, AV26remuTipoConCod});
         cV24cant = P026C2_AV24cant[0] ;
         c764LiqDImpReCalcu = P026C2_A764LiqDImpReCalcu[0] ;
         c507LiqDCalculado = P026C2_A507LiqDCalculado[0] ;
         pr_default.close(0);
         AV24cant = (short)(AV24cant+cV24cant*1) ;
         AV18LiqDImpReCalcu = AV18LiqDImpReCalcu.add(c764LiqDImpReCalcu) ;
         AV15auxLiqDCalculado = (byte)(AV15auxLiqDCalculado+c507LiqDCalculado) ;
         /* End optimized group. */
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV36Pgmname, httpContext.getMessage( "&auxLiqDCalculado ", "")+GXutil.trim( GXutil.str( AV15auxLiqDCalculado, 1, 0))+httpContext.getMessage( " &cant ", "")+GXutil.trim( GXutil.str( AV24cant, 4, 0))) ;
         if ( AV15auxLiqDCalculado < AV24cant )
         {
            AV16error = httpContext.getMessage( "Faltan calcular conceptos remunerativos y/o no remunerativos", "") ;
            AV17LiqDLog = GXutil.trim( AV16error) ;
            AV14LiqDCalculado = (byte)(0) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV28sumanImportes = AV18LiqDImpReCalcu ;
         AV24cant = (short)(0) ;
         AV18LiqDImpReCalcu = DecimalUtil.ZERO ;
         AV15auxLiqDCalculado = (byte)(0) ;
         /* Optimized group. */
         /* Using cursor P026C3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV9LiqNro), Integer.valueOf(AV10LegNumero), AV27descuentoTipoConCod, AV11ConCodigo});
         cV24cant = P026C3_AV24cant[0] ;
         c764LiqDImpReCalcu = P026C3_A764LiqDImpReCalcu[0] ;
         c507LiqDCalculado = P026C3_A507LiqDCalculado[0] ;
         pr_default.close(1);
         AV24cant = (short)(AV24cant+cV24cant*1) ;
         AV18LiqDImpReCalcu = AV18LiqDImpReCalcu.add(c764LiqDImpReCalcu) ;
         AV15auxLiqDCalculado = (byte)(AV15auxLiqDCalculado+c507LiqDCalculado) ;
         /* End optimized group. */
         if ( AV15auxLiqDCalculado < AV24cant )
         {
            AV16error = httpContext.getMessage( "Faltan calcular conceptos de descuento", "") ;
            AV17LiqDLog = GXutil.trim( AV16error) ;
            AV14LiqDCalculado = (byte)(0) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV29restanImportes = AV18LiqDImpReCalcu ;
         AV18LiqDImpReCalcu = AV28sumanImportes.subtract(AV29restanImportes) ;
      }
      else
      {
         AV18LiqDImpReCalcu = AV30parmNetoImportes ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "!&LiqDImpReCalcu ", "")+GXutil.trim( GXutil.str( AV18LiqDImpReCalcu, 14, 2))) ;
      AV33numSinDecimales = (long)(DecimalUtil.decToDouble(GXutil.truncDecimal( AV18LiqDImpReCalcu, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "!!!!! &&&numSinDecimales ", "")+GXutil.trim( GXutil.str( AV33numSinDecimales, 11, 0))) ;
      AV19Importes = DecimalUtil.doubleToDec(AV33numSinDecimales) ;
      AV19Importes = AV19Importes.add(DecimalUtil.doubleToDec(1)) ;
      AV17LiqDLog = httpContext.getMessage( "Se inicializa el importe en el neto redondeado ", "") + GXutil.trim( GXutil.str( AV19Importes, 14, 2)) ;
      AV19Importes = AV19Importes.subtract(AV18LiqDImpReCalcu) ;
      AV17LiqDLog += httpContext.getMessage( ". Se resta el neto ", "") + GXutil.trim( GXutil.str( AV18LiqDImpReCalcu, 14, 2)) ;
      if ( ( AV19Importes.doubleValue() == 1 ) || ( AV19Importes.doubleValue() == 0 ) )
      {
         AV17LiqDLog += httpContext.getMessage( ". El neto ya está redondeado", "") ;
         AV19Importes = DecimalUtil.ZERO ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "cerea...", "")) ;
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "importe no es 1 ni cero", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = redondeo.this.AV19Importes;
      this.aP8[0] = redondeo.this.AV16error;
      this.aP9[0] = redondeo.this.AV17LiqDLog;
      this.aP10[0] = redondeo.this.AV14LiqDCalculado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV19Importes = DecimalUtil.ZERO ;
      AV16error = "" ;
      AV17LiqDLog = "" ;
      AV36Pgmname = "" ;
      GXv_int1 = new short[1] ;
      AV25noRemuTipoConCod = "" ;
      AV26remuTipoConCod = "" ;
      AV27descuentoTipoConCod = "" ;
      GXv_char2 = new String[1] ;
      AV18LiqDImpReCalcu = DecimalUtil.ZERO ;
      c764LiqDImpReCalcu = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P026C2_AV24cant = new short[1] ;
      P026C2_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P026C2_A507LiqDCalculado = new byte[1] ;
      AV28sumanImportes = DecimalUtil.ZERO ;
      P026C3_AV24cant = new short[1] ;
      P026C3_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P026C3_A507LiqDCalculado = new byte[1] ;
      AV29restanImportes = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.redondeo__default(),
         new Object[] {
             new Object[] {
            P026C2_AV24cant, P026C2_A764LiqDImpReCalcu, P026C2_A507LiqDCalculado
            }
            , new Object[] {
            P026C3_AV24cant, P026C3_A764LiqDImpReCalcu, P026C3_A507LiqDCalculado
            }
         }
      );
      AV36Pgmname = "redondeo" ;
      /* GeneXus formulas. */
      AV36Pgmname = "redondeo" ;
      Gx_err = (short)(0) ;
   }

   private byte AV14LiqDCalculado ;
   private byte AV15auxLiqDCalculado ;
   private byte c507LiqDCalculado ;
   private short AV12EmpCod ;
   private short AV23paicod ;
   private short GXv_int1[] ;
   private short AV24cant ;
   private short cV24cant ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV9LiqNro ;
   private int AV10LegNumero ;
   private long AV33numSinDecimales ;
   private java.math.BigDecimal AV30parmNetoImportes ;
   private java.math.BigDecimal AV19Importes ;
   private java.math.BigDecimal AV18LiqDImpReCalcu ;
   private java.math.BigDecimal c764LiqDImpReCalcu ;
   private java.math.BigDecimal AV28sumanImportes ;
   private java.math.BigDecimal AV29restanImportes ;
   private String AV11ConCodigo ;
   private String AV13ProcesoLiquidacion ;
   private String AV36Pgmname ;
   private String AV25noRemuTipoConCod ;
   private String AV26remuTipoConCod ;
   private String AV27descuentoTipoConCod ;
   private String GXv_char2[] ;
   private String scmdbuf ;
   private boolean returnInSub ;
   private String AV17LiqDLog ;
   private String AV16error ;
   private byte[] aP10 ;
   private java.math.BigDecimal[] aP7 ;
   private String[] aP8 ;
   private String[] aP9 ;
   private IDataStoreProvider pr_default ;
   private short[] P026C2_AV24cant ;
   private java.math.BigDecimal[] P026C2_A764LiqDImpReCalcu ;
   private byte[] P026C2_A507LiqDCalculado ;
   private short[] P026C3_AV24cant ;
   private java.math.BigDecimal[] P026C3_A764LiqDImpReCalcu ;
   private byte[] P026C3_A507LiqDCalculado ;
}

final  class redondeo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P026C2", "SELECT COUNT(*), SUM(LiqDImpReCalcu), SUM(LiqDCalculado) FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?) AND (DConCodigo <> ( ?)) AND (DTipoConCod >= ( ?)) AND (DTipoConCod <= ( ?)) ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P026C3", "SELECT COUNT(*), SUM(LiqDImpReCalcu), SUM(LiqDCalculado) FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and DTipoConCod = ( ?)) AND (DConCodigo <> ( ?)) ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 10);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 10);
               return;
      }
   }

}

