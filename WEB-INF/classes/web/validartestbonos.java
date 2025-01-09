package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class validartestbonos extends GXProcedure
{
   public validartestbonos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( validartestbonos.class ), "" );
   }

   public validartestbonos( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 )
   {
      validartestbonos.this.AV12CliCod = aP0;
      validartestbonos.this.AV10EmpCod = aP1;
      validartestbonos.this.AV11LegNumero = aP2;
      validartestbonos.this.AV18TestNro = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV13sueldoBrutoGravadoConCodigo ;
      GXt_char2 = AV13sueldoBrutoGravadoConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.concepto_sueldobrutogravado_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      validartestbonos.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV12CliCod, GXt_char2, GXv_char4) ;
      validartestbonos.this.GXt_char1 = GXv_char4[0] ;
      AV13sueldoBrutoGravadoConCodigo = GXt_char1 ;
      /* Optimized group. */
      /* Using cursor P016R2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV11LegNumero), AV13sueldoBrutoGravadoConCodigo});
      c764LiqDImpReCalcu = P016R2_A764LiqDImpReCalcu[0] ;
      pr_default.close(0);
      AV8SueldoBrutoGravadoImportes = AV8SueldoBrutoGravadoImportes.add(c764LiqDImpReCalcu) ;
      /* End optimized group. */
      GXt_char2 = AV14brutoSinSacConCodigo ;
      GXt_char1 = AV14brutoSinSacConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_sueldobrutosinsac_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      validartestbonos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV12CliCod, GXt_char1, GXv_char3) ;
      validartestbonos.this.GXt_char2 = GXv_char3[0] ;
      AV14brutoSinSacConCodigo = GXt_char2 ;
      /* Optimized group. */
      /* Using cursor P016R3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV11LegNumero), AV14brutoSinSacConCodigo});
      c764LiqDImpReCalcu = P016R3_A764LiqDImpReCalcu[0] ;
      pr_default.close(1);
      AV9brutoSinSacMasBonosGravados = AV9brutoSinSacMasBonosGravados.add(c764LiqDImpReCalcu) ;
      /* End optimized group. */
      GXt_char2 = AV16BonoexentoConCodigo ;
      GXt_char1 = AV16BonoexentoConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_bonosexentos_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      validartestbonos.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV12CliCod, GXt_char1, GXv_char3) ;
      validartestbonos.this.GXt_char2 = GXv_char3[0] ;
      AV16BonoexentoConCodigo = GXt_char2 ;
      GXv_int5[0] = AV20DAplIIGG ;
      new web.getapliigg_totalmenteexenta(remoteHandle, context).execute( AV12CliCod, GXv_int5) ;
      validartestbonos.this.AV20DAplIIGG = GXv_int5[0] ;
      /* Optimized group. */
      /* Using cursor P016R4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV11LegNumero), Short.valueOf(AV20DAplIIGG)});
      c764LiqDImpReCalcu = P016R4_A764LiqDImpReCalcu[0] ;
      pr_default.close(2);
      AV17bonosExentosImportes = AV17bonosExentosImportes.add(c764LiqDImpReCalcu) ;
      /* End optimized group. */
      AV9brutoSinSacMasBonosGravados = AV9brutoSinSacMasBonosGravados.subtract(AV17bonosExentosImportes) ;
      AV19diferencia = AV8SueldoBrutoGravadoImportes.subtract(AV9brutoSinSacMasBonosGravados) ;
      if ( AV19diferencia.doubleValue() < 0 )
      {
         AV19diferencia = AV19diferencia.multiply(DecimalUtil.doubleToDec(-1)) ;
      }
      if ( DecimalUtil.compareTo(AV19diferencia, DecimalUtil.stringToDec("0.5")) <= 0 )
      {
         new web.grabarvalidaciontest(remoteHandle, context).execute( AV18TestNro, true, httpContext.getMessage( "OK prueba ", "")+GXutil.trim( GXutil.str( AV18TestNro, 4, 0))+" "+GXutil.trim( GXutil.str( AV8SueldoBrutoGravadoImportes, 14, 2))+" = "+GXutil.trim( GXutil.str( AV9brutoSinSacMasBonosGravados, 14, 2))) ;
      }
      else
      {
         new web.grabarvalidaciontest(remoteHandle, context).execute( AV18TestNro, false, httpContext.getMessage( "ERROR prueba ", "")+GXutil.trim( GXutil.str( AV18TestNro, 4, 0))+httpContext.getMessage( " &SueldoBrutoGravadoImportes ", "")+GXutil.trim( GXutil.str( AV8SueldoBrutoGravadoImportes, 14, 2))+httpContext.getMessage( " &brutoSinSacMasBonosGravados ", "")+GXutil.trim( GXutil.str( AV9brutoSinSacMasBonosGravados, 14, 2))) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13sueldoBrutoGravadoConCodigo = "" ;
      c764LiqDImpReCalcu = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P016R2_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      AV8SueldoBrutoGravadoImportes = DecimalUtil.ZERO ;
      AV14brutoSinSacConCodigo = "" ;
      P016R3_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      AV9brutoSinSacMasBonosGravados = DecimalUtil.ZERO ;
      AV16BonoexentoConCodigo = "" ;
      GXt_char2 = "" ;
      GXt_char1 = "" ;
      GXv_char4 = new String[1] ;
      GXv_char3 = new String[1] ;
      GXv_int5 = new short[1] ;
      P016R4_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      AV17bonosExentosImportes = DecimalUtil.ZERO ;
      AV19diferencia = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.validartestbonos__default(),
         new Object[] {
             new Object[] {
            P016R2_A764LiqDImpReCalcu
            }
            , new Object[] {
            P016R3_A764LiqDImpReCalcu
            }
            , new Object[] {
            P016R4_A764LiqDImpReCalcu
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short AV18TestNro ;
   private short AV20DAplIIGG ;
   private short GXv_int5[] ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV11LegNumero ;
   private java.math.BigDecimal c764LiqDImpReCalcu ;
   private java.math.BigDecimal AV8SueldoBrutoGravadoImportes ;
   private java.math.BigDecimal AV9brutoSinSacMasBonosGravados ;
   private java.math.BigDecimal AV17bonosExentosImportes ;
   private java.math.BigDecimal AV19diferencia ;
   private String AV13sueldoBrutoGravadoConCodigo ;
   private String scmdbuf ;
   private String AV14brutoSinSacConCodigo ;
   private String AV16BonoexentoConCodigo ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] P016R2_A764LiqDImpReCalcu ;
   private java.math.BigDecimal[] P016R3_A764LiqDImpReCalcu ;
   private java.math.BigDecimal[] P016R4_A764LiqDImpReCalcu ;
}

final  class validartestbonos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P016R2", "SELECT SUM(LiqDImpReCalcu) FROM LiquidacionDetalle WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and DConCodigo = ( ?) ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P016R3", "SELECT SUM(LiqDImpReCalcu) FROM LiquidacionDetalle WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and DConCodigo = ( ?) ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P016R4", "SELECT SUM(LiqDImpReCalcu) FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LegNumero = ?) AND (DAplIIGG = ?) ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               return;
            case 1 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               return;
            case 2 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
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
               stmt.setString(4, (String)parms[3], 10);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 10);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
      }
   }

}

