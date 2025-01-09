package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class maximo_imponible_adelvac extends GXProcedure
{
   public maximo_imponible_adelvac( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( maximo_imponible_adelvac.class ), "" );
   }

   public maximo_imponible_adelvac( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             short aP5 ,
                             java.math.BigDecimal aP6 ,
                             String aP7 ,
                             short aP8 ,
                             String[] aP9 ,
                             java.math.BigDecimal[] aP10 ,
                             java.math.BigDecimal[] aP11 ,
                             short[] aP12 )
   {
      maximo_imponible_adelvac.this.aP13 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
      return aP13[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        short aP5 ,
                        java.math.BigDecimal aP6 ,
                        String aP7 ,
                        short aP8 ,
                        String[] aP9 ,
                        java.math.BigDecimal[] aP10 ,
                        java.math.BigDecimal[] aP11 ,
                        short[] aP12 ,
                        String[] aP13 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             short aP5 ,
                             java.math.BigDecimal aP6 ,
                             String aP7 ,
                             short aP8 ,
                             String[] aP9 ,
                             java.math.BigDecimal[] aP10 ,
                             java.math.BigDecimal[] aP11 ,
                             short[] aP12 ,
                             String[] aP13 )
   {
      maximo_imponible_adelvac.this.AV9CliCod = aP0;
      maximo_imponible_adelvac.this.AV25EmpCod = aP1;
      maximo_imponible_adelvac.this.AV26LiqNro = aP2;
      maximo_imponible_adelvac.this.AV27LegNumero = aP3;
      maximo_imponible_adelvac.this.AV10LiqPeriodo = aP4;
      maximo_imponible_adelvac.this.AV15dias_mes = aP5;
      maximo_imponible_adelvac.this.AV14parm_Importe = aP6;
      maximo_imponible_adelvac.this.AV11ProcesoLiquidacion = aP7;
      maximo_imponible_adelvac.this.AV17dias_vacaciones = aP8;
      maximo_imponible_adelvac.this.aP9 = aP9;
      maximo_imponible_adelvac.this.aP10 = aP10;
      maximo_imponible_adelvac.this.aP11 = aP11;
      maximo_imponible_adelvac.this.aP12 = aP12;
      maximo_imponible_adelvac.this.aP13 = aP13;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8OpeCliId = "[base_imp_max]" ;
      GXv_char1[0] = AV12OpeCliValor ;
      GXv_char2[0] = AV28auxError ;
      new web.getopeclivalor(remoteHandle, context).execute( AV9CliCod, AV8OpeCliId, AV10LiqPeriodo, AV11ProcesoLiquidacion, GXv_char1, GXv_char2) ;
      maximo_imponible_adelvac.this.AV12OpeCliValor = GXv_char1[0] ;
      maximo_imponible_adelvac.this.AV28auxError = GXv_char2[0] ;
      if ( ! (GXutil.strcmp("", AV28auxError)==0) )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13base_imp_max = CommonUtil.decimalVal( AV12OpeCliValor, ".") ;
      AV8OpeCliId = "[base_imp_min]" ;
      GXv_char2[0] = AV12OpeCliValor ;
      GXv_char1[0] = AV28auxError ;
      new web.getopeclivalor(remoteHandle, context).execute( AV9CliCod, AV8OpeCliId, AV10LiqPeriodo, AV11ProcesoLiquidacion, GXv_char2, GXv_char1) ;
      maximo_imponible_adelvac.this.AV12OpeCliValor = GXv_char2[0] ;
      maximo_imponible_adelvac.this.AV28auxError = GXv_char1[0] ;
      if ( ! (GXutil.strcmp("", AV28auxError)==0) )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV31Base_imp_min = CommonUtil.decimalVal( AV12OpeCliValor, ".") ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, httpContext.getMessage( "1 &parm_Importe ", "")+GXutil.trim( GXutil.str( AV14parm_Importe, 14, 2))) ;
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV14parm_Importe)==0) )
      {
         AV16maxProporAAdelantoVac = (AV13base_imp_max.divide(DecimalUtil.doubleToDec(AV15dias_mes), 18, java.math.RoundingMode.DOWN)).multiply(DecimalUtil.doubleToDec(AV17dias_vacaciones)) ;
         if ( DecimalUtil.compareTo(AV14parm_Importe, AV16maxProporAAdelantoVac) <= 0 )
         {
            AV19Importe = AV19Importe.add(AV14parm_Importe) ;
            AV20baseImportes = AV20baseImportes.add(AV14parm_Importe) ;
            if ( AV14parm_Importe.doubleValue() > 0 )
            {
               AV18LiqDLog += httpContext.getMessage( ". Agrega valor por ", "") ;
            }
            else
            {
               /* Execute user subroutine: 'SEPARAR LOG' */
               S111 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV18LiqDLog += httpContext.getMessage( "Inicializa valor con ", "") ;
            }
            AV18LiqDLog += httpContext.getMessage( "adelanto de vacaciones mes próximo ", "") + GXutil.trim( GXutil.str( AV14parm_Importe, 14, 2)) + httpContext.getMessage( " al ser menor o igual al máximo imponible proporcional a los días de vacaciones ", "") + GXutil.trim( GXutil.str( AV16maxProporAAdelantoVac, 14, 2)) + httpContext.getMessage( " que se calcula como (", "") + GXutil.trim( GXutil.str( AV13base_imp_max, 14, 2)) + " / " + GXutil.trim( GXutil.str( AV15dias_mes, 4, 0)) + ") * " + GXutil.trim( GXutil.str( AV17dias_vacaciones, 4, 0)) ;
         }
         else
         {
            AV19Importe = AV19Importe.add(AV16maxProporAAdelantoVac) ;
            if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV20baseImportes)==0) )
            {
               AV20baseImportes = AV20baseImportes.add(AV16maxProporAAdelantoVac) ;
            }
            if ( AV14parm_Importe.doubleValue() > 0 )
            {
               AV18LiqDLog += httpContext.getMessage( ". Agrega el ", "") ;
            }
            else
            {
               /* Execute user subroutine: 'SEPARAR LOG' */
               S111 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV18LiqDLog += httpContext.getMessage( "Inicializa con ", "") ;
            }
            AV18LiqDLog += httpContext.getMessage( "valor del máximo imponible proporcionado a los días de adelanto de vacaciones mes próximo ", "") + GXutil.trim( GXutil.str( AV16maxProporAAdelantoVac, 14, 2)) + httpContext.getMessage( " que se calcula como (", "") + GXutil.trim( GXutil.str( AV13base_imp_max, 14, 2)) + " / " + GXutil.trim( GXutil.str( AV15dias_mes, 4, 0)) + ") * " + GXutil.trim( GXutil.str( AV17dias_vacaciones, 4, 0)) + httpContext.getMessage( ". al ser la remuneración por adelanto de vacaciones mes próximo ", "") + GXutil.trim( GXutil.str( AV14parm_Importe, 14, 2)) + httpContext.getMessage( " mayor a este tope", "") ;
         }
         AV21cantidadCalculada = (short)(AV21cantidadCalculada+AV17dias_vacaciones) ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'SEPARAR LOG' Routine */
      returnInSub = false ;
      if ( ! (GXutil.strcmp("", AV18LiqDLog)==0) )
      {
         AV18LiqDLog += ". " ;
      }
   }

   protected void cleanup( )
   {
      this.aP9[0] = maximo_imponible_adelvac.this.AV18LiqDLog;
      this.aP10[0] = maximo_imponible_adelvac.this.AV20baseImportes;
      this.aP11[0] = maximo_imponible_adelvac.this.AV19Importe;
      this.aP12[0] = maximo_imponible_adelvac.this.AV21cantidadCalculada;
      this.aP13[0] = maximo_imponible_adelvac.this.AV28auxError;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV18LiqDLog = "" ;
      AV20baseImportes = DecimalUtil.ZERO ;
      AV19Importe = DecimalUtil.ZERO ;
      AV28auxError = "" ;
      AV8OpeCliId = "" ;
      AV12OpeCliValor = "" ;
      AV13base_imp_max = DecimalUtil.ZERO ;
      GXv_char2 = new String[1] ;
      GXv_char1 = new String[1] ;
      AV31Base_imp_min = DecimalUtil.ZERO ;
      AV32Pgmname = "" ;
      AV16maxProporAAdelantoVac = DecimalUtil.ZERO ;
      AV32Pgmname = "maximo_imponible_AdelVac" ;
      /* GeneXus formulas. */
      AV32Pgmname = "maximo_imponible_AdelVac" ;
      Gx_err = (short)(0) ;
   }

   private short AV25EmpCod ;
   private short AV15dias_mes ;
   private short AV17dias_vacaciones ;
   private short AV21cantidadCalculada ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV26LiqNro ;
   private int AV27LegNumero ;
   private java.math.BigDecimal AV14parm_Importe ;
   private java.math.BigDecimal AV20baseImportes ;
   private java.math.BigDecimal AV19Importe ;
   private java.math.BigDecimal AV13base_imp_max ;
   private java.math.BigDecimal AV31Base_imp_min ;
   private java.math.BigDecimal AV16maxProporAAdelantoVac ;
   private String AV11ProcesoLiquidacion ;
   private String AV8OpeCliId ;
   private String GXv_char2[] ;
   private String GXv_char1[] ;
   private String AV32Pgmname ;
   private java.util.Date AV10LiqPeriodo ;
   private boolean returnInSub ;
   private String AV18LiqDLog ;
   private String AV12OpeCliValor ;
   private String AV28auxError ;
   private String[] aP13 ;
   private String[] aP9 ;
   private java.math.BigDecimal[] aP10 ;
   private java.math.BigDecimal[] aP11 ;
   private short[] aP12 ;
}

