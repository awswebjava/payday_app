package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class maximo_imponible_sueldo extends GXProcedure
{
   public maximo_imponible_sueldo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( maximo_imponible_sueldo.class ), "" );
   }

   public maximo_imponible_sueldo( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            int aP2 ,
                            int aP3 ,
                            java.util.Date aP4 ,
                            short aP5 ,
                            java.math.BigDecimal aP6 ,
                            String aP7 ,
                            boolean aP8 ,
                            byte[] aP9 ,
                            String[] aP10 ,
                            String[] aP11 ,
                            java.math.BigDecimal[] aP12 ,
                            java.math.BigDecimal[] aP13 )
   {
      maximo_imponible_sueldo.this.aP14 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14);
      return aP14[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        short aP5 ,
                        java.math.BigDecimal aP6 ,
                        String aP7 ,
                        boolean aP8 ,
                        byte[] aP9 ,
                        String[] aP10 ,
                        String[] aP11 ,
                        java.math.BigDecimal[] aP12 ,
                        java.math.BigDecimal[] aP13 ,
                        short[] aP14 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             short aP5 ,
                             java.math.BigDecimal aP6 ,
                             String aP7 ,
                             boolean aP8 ,
                             byte[] aP9 ,
                             String[] aP10 ,
                             String[] aP11 ,
                             java.math.BigDecimal[] aP12 ,
                             java.math.BigDecimal[] aP13 ,
                             short[] aP14 )
   {
      maximo_imponible_sueldo.this.AV9CliCod = aP0;
      maximo_imponible_sueldo.this.AV15EmpCod = aP1;
      maximo_imponible_sueldo.this.AV32LiqNro = aP2;
      maximo_imponible_sueldo.this.AV18LegNumero = aP3;
      maximo_imponible_sueldo.this.AV21LiqPeriodo = aP4;
      maximo_imponible_sueldo.this.AV10dias_mes = aP5;
      maximo_imponible_sueldo.this.AV26parm_Importe = aP6;
      maximo_imponible_sueldo.this.AV25ProcesoLiquidacion = aP7;
      maximo_imponible_sueldo.this.AV17insertandoConceptos = aP8;
      maximo_imponible_sueldo.this.aP9 = aP9;
      maximo_imponible_sueldo.this.aP10 = aP10;
      maximo_imponible_sueldo.this.aP11 = aP11;
      maximo_imponible_sueldo.this.aP12 = aP12;
      maximo_imponible_sueldo.this.aP13 = aP13;
      maximo_imponible_sueldo.this.aP14 = aP14;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV19LiqDCalculado = (byte)(1) ;
      AV23OpeCliId = "[base_imp_max]" ;
      GXv_char1[0] = AV24OpeCliValor ;
      GXv_char2[0] = AV34auxError ;
      new web.getopeclivalor(remoteHandle, context).execute( AV9CliCod, AV23OpeCliId, AV21LiqPeriodo, AV25ProcesoLiquidacion, GXv_char1, GXv_char2) ;
      maximo_imponible_sueldo.this.AV24OpeCliValor = GXv_char1[0] ;
      maximo_imponible_sueldo.this.AV34auxError = GXv_char2[0] ;
      if ( ! (GXutil.strcmp("", AV34auxError)==0) )
      {
         AV19LiqDCalculado = (byte)(0) ;
         AV16error = AV34auxError ;
         AV20LiqDLog = AV16error ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV8base_imp_max = CommonUtil.decimalVal( AV24OpeCliValor, ".") ;
      GXv_int3[0] = AV11dias_trabajados_mes ;
      GXv_char2[0] = AV12diasTrabMesError ;
      GXv_int4[0] = AV13diasTrabMesLiqDCalculado ;
      GXv_char1[0] = AV14diasTrabMesLiqDLog ;
      new web.diastrabmesparabaseimp(remoteHandle, context).execute( AV9CliCod, AV15EmpCod, AV32LiqNro, AV18LegNumero, AV21LiqPeriodo, AV10dias_mes, AV25ProcesoLiquidacion, AV17insertandoConceptos, GXv_int3, GXv_char2, GXv_int4, GXv_char1) ;
      maximo_imponible_sueldo.this.AV11dias_trabajados_mes = GXv_int3[0] ;
      maximo_imponible_sueldo.this.AV12diasTrabMesError = GXv_char2[0] ;
      maximo_imponible_sueldo.this.AV13diasTrabMesLiqDCalculado = GXv_int4[0] ;
      maximo_imponible_sueldo.this.AV14diasTrabMesLiqDLog = GXv_char1[0] ;
      if ( AV13diasTrabMesLiqDCalculado == 0 )
      {
         AV19LiqDCalculado = (byte)(0) ;
         AV16error = AV12diasTrabMesError ;
         AV20LiqDLog += GXutil.trim( AV16error) ;
         AV20LiqDLog += AV14diasTrabMesLiqDLog ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      if ( ! (GXutil.strcmp("", AV20LiqDLog)==0) )
      {
         AV20LiqDLog += ". " ;
      }
      AV20LiqDLog += AV14diasTrabMesLiqDLog ;
      AV22maxProporATrab = (AV8base_imp_max.divide(DecimalUtil.doubleToDec(AV10dias_mes), 18, java.math.RoundingMode.DOWN)).multiply(DecimalUtil.doubleToDec(AV11dias_trabajados_mes)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( " &parm_Importe ", "")+GXutil.trim( GXutil.str( AV26parm_Importe, 14, 2))+httpContext.getMessage( " &maxProporATrab ", "")+GXutil.trim( GXutil.str( AV22maxProporATrab, 14, 2))+httpContext.getMessage( " &base_imp_max ", "")+GXutil.trim( GXutil.str( AV8base_imp_max, 14, 2))+httpContext.getMessage( " &dias_mes ", "")+GXutil.trim( GXutil.str( AV10dias_mes, 4, 0))+httpContext.getMessage( " &dias_trabajados_mes ", "")+GXutil.trim( GXutil.str( AV11dias_trabajados_mes, 4, 0))) ;
      if ( AV26parm_Importe.doubleValue() > 0 )
      {
         AV23OpeCliId = "[base_imp_min]" ;
         GXv_char2[0] = AV24OpeCliValor ;
         GXv_char1[0] = AV34auxError ;
         new web.getopeclivalor(remoteHandle, context).execute( AV9CliCod, AV23OpeCliId, AV21LiqPeriodo, AV25ProcesoLiquidacion, GXv_char2, GXv_char1) ;
         maximo_imponible_sueldo.this.AV24OpeCliValor = GXv_char2[0] ;
         maximo_imponible_sueldo.this.AV34auxError = GXv_char1[0] ;
         if ( ! (GXutil.strcmp("", AV34auxError)==0) )
         {
            AV19LiqDCalculado = (byte)(0) ;
            AV16error = AV34auxError ;
            AV20LiqDLog = AV16error ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV27baseImponibleMinima = CommonUtil.decimalVal( AV24OpeCliValor, ".") ;
         if ( DecimalUtil.compareTo(AV26parm_Importe, AV22maxProporATrab) <= 0 )
         {
            AV28Importe = AV26parm_Importe ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "1 &Importe ", "")+GXutil.trim( GXutil.str( AV28Importe, 14, 2))) ;
            AV29baseImportes = AV29baseImportes.add(AV26parm_Importe) ;
            /* Execute user subroutine: 'SEPARAR LOG' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV20LiqDLog += httpContext.getMessage( "Inicializa valor con ", "") + GXutil.trim( GXutil.str( AV26parm_Importe, 14, 2)) + httpContext.getMessage( " al ser menor o igual que el máximo imponible ", "") ;
            if ( AV10dias_mes != AV11dias_trabajados_mes )
            {
               AV20LiqDLog += httpContext.getMessage( "proporcional a los días trabajados ", "") ;
            }
            AV20LiqDLog += GXutil.trim( GXutil.str( AV22maxProporATrab, 14, 2)) ;
            if ( AV10dias_mes != AV11dias_trabajados_mes )
            {
               AV20LiqDLog += httpContext.getMessage( ", importe que se calcula de la siguiente manera: (", "") + GXutil.trim( GXutil.str( AV8base_imp_max, 14, 2)) + " / " + GXutil.trim( GXutil.str( AV10dias_mes, 4, 0)) + ") * " + GXutil.trim( GXutil.str( AV11dias_trabajados_mes, 4, 0)) ;
            }
         }
         else
         {
            AV28Importe = AV22maxProporATrab ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, "2 "+GXutil.trim( GXutil.str( AV28Importe, 14, 2))) ;
            AV29baseImportes = AV29baseImportes.add(AV8base_imp_max) ;
            /* Execute user subroutine: 'SEPARAR LOG' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV20LiqDLog += httpContext.getMessage( "Inicializa valor con el máximo imponible ", "") ;
            if ( AV10dias_mes != AV11dias_trabajados_mes )
            {
               AV20LiqDLog += httpContext.getMessage( "proporcional a los días trabajados ", "") ;
            }
            AV20LiqDLog += GXutil.trim( GXutil.str( AV22maxProporATrab, 14, 2)) ;
            if ( AV10dias_mes != AV11dias_trabajados_mes )
            {
               AV20LiqDLog += httpContext.getMessage( ", importe que se calcula de la siguiente manera: . (", "") + GXutil.trim( GXutil.str( AV8base_imp_max, 14, 2)) + " / " + GXutil.trim( GXutil.str( AV10dias_mes, 4, 0)) + ") * " + GXutil.trim( GXutil.str( AV11dias_trabajados_mes, 4, 0)) ;
            }
            AV20LiqDLog += httpContext.getMessage( ", al ser el sueldo total del periodo ", "") + GXutil.trim( GXutil.str( AV26parm_Importe, 14, 2)) + httpContext.getMessage( " mayor a este tope", "") ;
         }
         AV33cantidadCalculada = AV11dias_trabajados_mes ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'SEPARAR LOG' Routine */
      returnInSub = false ;
      if ( ! (GXutil.strcmp("", AV20LiqDLog)==0) )
      {
         AV20LiqDLog += ". " ;
      }
   }

   protected void cleanup( )
   {
      this.aP9[0] = maximo_imponible_sueldo.this.AV19LiqDCalculado;
      this.aP10[0] = maximo_imponible_sueldo.this.AV20LiqDLog;
      this.aP11[0] = maximo_imponible_sueldo.this.AV16error;
      this.aP12[0] = maximo_imponible_sueldo.this.AV29baseImportes;
      this.aP13[0] = maximo_imponible_sueldo.this.AV28Importe;
      this.aP14[0] = maximo_imponible_sueldo.this.AV33cantidadCalculada;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV20LiqDLog = "" ;
      AV16error = "" ;
      AV29baseImportes = DecimalUtil.ZERO ;
      AV28Importe = DecimalUtil.ZERO ;
      AV23OpeCliId = "" ;
      AV24OpeCliValor = "" ;
      AV34auxError = "" ;
      AV8base_imp_max = DecimalUtil.ZERO ;
      GXv_int3 = new short[1] ;
      AV12diasTrabMesError = "" ;
      GXv_int4 = new byte[1] ;
      AV14diasTrabMesLiqDLog = "" ;
      AV22maxProporATrab = DecimalUtil.ZERO ;
      AV37Pgmname = "" ;
      GXv_char2 = new String[1] ;
      GXv_char1 = new String[1] ;
      AV27baseImponibleMinima = DecimalUtil.ZERO ;
      AV37Pgmname = "maximo_imponible_sueldo" ;
      /* GeneXus formulas. */
      AV37Pgmname = "maximo_imponible_sueldo" ;
      Gx_err = (short)(0) ;
   }

   private byte AV19LiqDCalculado ;
   private byte AV13diasTrabMesLiqDCalculado ;
   private byte GXv_int4[] ;
   private short AV15EmpCod ;
   private short AV10dias_mes ;
   private short AV33cantidadCalculada ;
   private short AV11dias_trabajados_mes ;
   private short GXv_int3[] ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV32LiqNro ;
   private int AV18LegNumero ;
   private java.math.BigDecimal AV26parm_Importe ;
   private java.math.BigDecimal AV29baseImportes ;
   private java.math.BigDecimal AV28Importe ;
   private java.math.BigDecimal AV8base_imp_max ;
   private java.math.BigDecimal AV22maxProporATrab ;
   private java.math.BigDecimal AV27baseImponibleMinima ;
   private String AV25ProcesoLiquidacion ;
   private String AV23OpeCliId ;
   private String AV37Pgmname ;
   private String GXv_char2[] ;
   private String GXv_char1[] ;
   private java.util.Date AV21LiqPeriodo ;
   private boolean AV17insertandoConceptos ;
   private boolean returnInSub ;
   private String AV20LiqDLog ;
   private String AV24OpeCliValor ;
   private String AV14diasTrabMesLiqDLog ;
   private String AV16error ;
   private String AV34auxError ;
   private String AV12diasTrabMesError ;
   private short[] aP14 ;
   private byte[] aP9 ;
   private String[] aP10 ;
   private String[] aP11 ;
   private java.math.BigDecimal[] aP12 ;
   private java.math.BigDecimal[] aP13 ;
}

