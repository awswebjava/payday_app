package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class leyendaaclaracionsueldo extends GXProcedure
{
   public leyendaaclaracionsueldo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( leyendaaclaracionsueldo.class ), "" );
   }

   public leyendaaclaracionsueldo( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             java.util.Date aP4 ,
                             short aP5 ,
                             java.math.BigDecimal aP6 ,
                             boolean aP7 ,
                             boolean aP8 ,
                             String aP9 ,
                             boolean aP10 ,
                             boolean aP11 ,
                             java.math.BigDecimal[] aP12 )
   {
      leyendaaclaracionsueldo.this.aP13 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
      return aP13[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        java.util.Date aP4 ,
                        short aP5 ,
                        java.math.BigDecimal aP6 ,
                        boolean aP7 ,
                        boolean aP8 ,
                        String aP9 ,
                        boolean aP10 ,
                        boolean aP11 ,
                        java.math.BigDecimal[] aP12 ,
                        String[] aP13 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             java.util.Date aP4 ,
                             short aP5 ,
                             java.math.BigDecimal aP6 ,
                             boolean aP7 ,
                             boolean aP8 ,
                             String aP9 ,
                             boolean aP10 ,
                             boolean aP11 ,
                             java.math.BigDecimal[] aP12 ,
                             String[] aP13 )
   {
      leyendaaclaracionsueldo.this.AV12CliCod = aP0;
      leyendaaclaracionsueldo.this.AV13EmpCod = aP1;
      leyendaaclaracionsueldo.this.AV14LegNumero = aP2;
      leyendaaclaracionsueldo.this.AV8LegSuelTipo = aP3;
      leyendaaclaracionsueldo.this.AV18LegSuelFecha = aP4;
      leyendaaclaracionsueldo.this.AV41LegSuelSec = aP5;
      leyendaaclaracionsueldo.this.AV29parmImportes = aP6;
      leyendaaclaracionsueldo.this.AV40parmLegLiqApo = aP7;
      leyendaaclaracionsueldo.this.AV39parmLegJubilado = aP8;
      leyendaaclaracionsueldo.this.AV38parmSinCod = aP9;
      leyendaaclaracionsueldo.this.AV48setCalcYTxt = aP10;
      leyendaaclaracionsueldo.this.AV54permitirDesactualizadas = aP11;
      leyendaaclaracionsueldo.this.aP12 = aP12;
      leyendaaclaracionsueldo.this.aP13 = aP13;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV57Pgmname, httpContext.getMessage( "1 &parmImportes ", "")+GXutil.trim( GXutil.str( AV29parmImportes, 14, 2))+httpContext.getMessage( " tipo ", "")+GXutil.trim( AV8LegSuelTipo)) ;
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV29parmImportes)==0) )
      {
         GXv_decimal1[0] = AV32base_imp_min ;
         GXv_decimal2[0] = AV31base_imp_max ;
         GXv_char3[0] = AV35auxError ;
         new web.getbaseimpmaxymin(remoteHandle, context).execute( AV12CliCod, AV18LegSuelFecha, "Calculo", AV54permitirDesactualizadas, GXv_decimal1, GXv_decimal2, GXv_char3) ;
         leyendaaclaracionsueldo.this.AV32base_imp_min = GXv_decimal1[0] ;
         leyendaaclaracionsueldo.this.AV31base_imp_max = GXv_decimal2[0] ;
         leyendaaclaracionsueldo.this.AV35auxError = GXv_char3[0] ;
         /* Execute user subroutine: 'DEVOLVER ERROR' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( GXutil.strcmp(AV8LegSuelTipo, "Bruto") == 0 )
         {
            AV42baseImportes = AV29parmImportes ;
            /* Execute user subroutine: 'CALCULAR' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV9Texto = httpContext.getMessage( "Descuentos básicos: ", "") + GXutil.trim( AV37descuentoImportesToolTip) ;
         }
         else
         {
            GXv_decimal2[0] = AV42baseImportes ;
            GXv_char3[0] = AV35auxError ;
            new web.calcularbrutodesdeneto(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, AV14LegNumero, AV29parmImportes, AV32base_imp_min, AV31base_imp_max, true, AV18LegSuelFecha, AV40parmLegLiqApo, AV39parmLegJubilado, AV38parmSinCod, GXv_decimal2, GXv_char3) ;
            leyendaaclaracionsueldo.this.AV42baseImportes = GXv_decimal2[0] ;
            leyendaaclaracionsueldo.this.AV35auxError = GXv_char3[0] ;
            /* Execute user subroutine: 'DEVOLVER ERROR' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV57Pgmname, httpContext.getMessage( "queda &baseImportes ", "")+GXutil.trim( GXutil.str( AV42baseImportes, 14, 2))+httpContext.getMessage( "impuestotopeado ", "")+GXutil.trim( GXutil.str( AV45impuestoTopeado, 14, 2))) ;
            /* Execute user subroutine: 'CALCULAR' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            if ( GXutil.strcmp(AV8LegSuelTipo, "Neto") == 0 )
            {
               AV9Texto = httpContext.getMessage( "Descuentos básicos: ", "") + GXutil.trim( AV37descuentoImportesToolTip) ;
            }
            else
            {
               AV37descuentoImportesToolTip += httpContext.getMessage( ". El importe bruto definitivo será calculado contemplando todas las retenciones que hayan al momento de la liquidación", "") ;
               AV9Texto = httpContext.getMessage( "Descuentos básicos: ", "") + GXutil.trim( AV37descuentoImportesToolTip) ;
            }
         }
      }
      if ( AV48setCalcYTxt )
      {
         new web.legajosueldosetcalcytxt(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, AV14LegNumero, AV41LegSuelSec, AV10Importes, AV9Texto) ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'DEVOLVER ERROR' Routine */
      returnInSub = false ;
      if ( ! (GXutil.strcmp("", AV35auxError)==0) )
      {
         AV9Texto = GXutil.trim( AV35auxError) ;
         returnInSub = true;
         if (true) return;
      }
   }

   public void S121( )
   {
      /* 'CALCULAR' Routine */
      returnInSub = false ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV57Pgmname, httpContext.getMessage( "&LegNumero ", "")+GXutil.trim( GXutil.str( AV14LegNumero, 8, 0))) ;
      GXv_char3[0] = AV35auxError ;
      GXv_char4[0] = AV17auxLiqDLog ;
      GXv_decimal2[0] = AV23descuentoImportes ;
      new web.precalcularsueldoconceptos(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, AV14LegNumero, AV18LegSuelFecha, AV41LegSuelSec, AV42baseImportes, AV32base_imp_min, AV31base_imp_max, AV40parmLegLiqApo, AV39parmLegJubilado, AV38parmSinCod, GXv_char3, GXv_char4, GXv_decimal2) ;
      leyendaaclaracionsueldo.this.AV35auxError = GXv_char3[0] ;
      leyendaaclaracionsueldo.this.AV17auxLiqDLog = GXv_char4[0] ;
      leyendaaclaracionsueldo.this.AV23descuentoImportes = GXv_decimal2[0] ;
      GXv_char4[0] = AV37descuentoImportesToolTip ;
      new web.armatooltip(remoteHandle, context).execute( AV12CliCod, AV23descuentoImportes, AV17auxLiqDLog, true, GXv_char4) ;
      leyendaaclaracionsueldo.this.AV37descuentoImportesToolTip = GXv_char4[0] ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV57Pgmname, httpContext.getMessage( "&LegSuelSec ", "")+GXutil.trim( GXutil.str( AV41LegSuelSec, 4, 0))+httpContext.getMessage( " auxerror ", "")+AV35auxError) ;
      /* Execute user subroutine: 'DEVOLVER ERROR' */
      S111 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV8LegSuelTipo, "Bruto") == 0 )
      {
         AV10Importes = AV42baseImportes.subtract(AV23descuentoImportes) ;
      }
      else
      {
         AV10Importes = AV29parmImportes.add(AV23descuentoImportes) ;
         AV53diferencia = AV10Importes.subtract(AV42baseImportes) ;
         if ( AV53diferencia.doubleValue() < 0 )
         {
            AV53diferencia = AV53diferencia.multiply(DecimalUtil.doubleToDec(-1)) ;
         }
         if ( AV53diferencia.doubleValue() > 2 )
         {
            AV10Importes = DecimalUtil.doubleToDec(0) ;
            AV9Texto = httpContext.getMessage( "Error en el cálculo de sueldo bruto, diferencia de ", "") + GXutil.trim( GXutil.str( AV53diferencia, 14, 2)) + httpContext.getMessage( " al comparar con bruto liquidado", "") ;
         }
         else
         {
            AV10Importes = AV42baseImportes ;
         }
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV57Pgmname, httpContext.getMessage( "&Importes ", "")+GXutil.trim( GXutil.str( AV10Importes, 14, 2))+httpContext.getMessage( " &descuentoImportes ", "")+GXutil.trim( GXutil.str( AV23descuentoImportes, 14, 2))) ;
   }

   protected void cleanup( )
   {
      this.aP12[0] = leyendaaclaracionsueldo.this.AV10Importes;
      this.aP13[0] = leyendaaclaracionsueldo.this.AV9Texto;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10Importes = DecimalUtil.ZERO ;
      AV9Texto = "" ;
      AV57Pgmname = "" ;
      AV32base_imp_min = DecimalUtil.ZERO ;
      GXv_decimal1 = new java.math.BigDecimal[1] ;
      AV31base_imp_max = DecimalUtil.ZERO ;
      AV35auxError = "" ;
      AV42baseImportes = DecimalUtil.ZERO ;
      AV37descuentoImportesToolTip = "" ;
      AV45impuestoTopeado = DecimalUtil.ZERO ;
      GXv_char3 = new String[1] ;
      AV17auxLiqDLog = "" ;
      AV23descuentoImportes = DecimalUtil.ZERO ;
      GXv_decimal2 = new java.math.BigDecimal[1] ;
      GXv_char4 = new String[1] ;
      AV53diferencia = DecimalUtil.ZERO ;
      AV57Pgmname = "leyendaAclaracionSueldo" ;
      /* GeneXus formulas. */
      AV57Pgmname = "leyendaAclaracionSueldo" ;
      Gx_err = (short)(0) ;
   }

   private short AV13EmpCod ;
   private short AV41LegSuelSec ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV14LegNumero ;
   private java.math.BigDecimal AV29parmImportes ;
   private java.math.BigDecimal AV10Importes ;
   private java.math.BigDecimal AV32base_imp_min ;
   private java.math.BigDecimal GXv_decimal1[] ;
   private java.math.BigDecimal AV31base_imp_max ;
   private java.math.BigDecimal AV42baseImportes ;
   private java.math.BigDecimal AV45impuestoTopeado ;
   private java.math.BigDecimal AV23descuentoImportes ;
   private java.math.BigDecimal GXv_decimal2[] ;
   private java.math.BigDecimal AV53diferencia ;
   private String AV8LegSuelTipo ;
   private String AV38parmSinCod ;
   private String AV57Pgmname ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private java.util.Date AV18LegSuelFecha ;
   private boolean AV40parmLegLiqApo ;
   private boolean AV39parmLegJubilado ;
   private boolean AV48setCalcYTxt ;
   private boolean AV54permitirDesactualizadas ;
   private boolean returnInSub ;
   private String AV9Texto ;
   private String AV17auxLiqDLog ;
   private String AV35auxError ;
   private String AV37descuentoImportesToolTip ;
   private String[] aP13 ;
   private java.math.BigDecimal[] aP12 ;
}

