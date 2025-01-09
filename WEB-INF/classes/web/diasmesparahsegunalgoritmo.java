package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class diasmesparahsegunalgoritmo extends GXProcedure
{
   public diasmesparahsegunalgoritmo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( diasmesparahsegunalgoritmo.class ), "" );
   }

   public diasmesparahsegunalgoritmo( int remoteHandle ,
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
                             java.math.BigDecimal[] aP5 )
   {
      diasmesparahsegunalgoritmo.this.aP6 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        java.util.Date aP4 ,
                        java.math.BigDecimal[] aP5 ,
                        String[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             java.util.Date aP4 ,
                             java.math.BigDecimal[] aP5 ,
                             String[] aP6 )
   {
      diasmesparahsegunalgoritmo.this.AV23CliCod = aP0;
      diasmesparahsegunalgoritmo.this.AV24EmpCod = aP1;
      diasmesparahsegunalgoritmo.this.AV25LegNumero = aP2;
      diasmesparahsegunalgoritmo.this.AV8algoritmoDiasMesHsExt = aP3;
      diasmesparahsegunalgoritmo.this.AV11LiqPeriodo = aP4;
      diasmesparahsegunalgoritmo.this.aP5 = aP5;
      diasmesparahsegunalgoritmo.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ! (0==AV25LegNumero) )
      {
         GXv_boolean1[0] = AV20LegTrabDo ;
         GXv_boolean2[0] = AV16LegTrabLun ;
         GXv_boolean3[0] = AV17LegTrabMar ;
         GXv_boolean4[0] = AV22LegTrabMie ;
         GXv_boolean5[0] = AV18LegTrabJue ;
         GXv_boolean6[0] = AV19LegTrabVie ;
         GXv_boolean7[0] = AV21LegTrabSa ;
         new web.legdiastrabaja(remoteHandle, context).execute( AV23CliCod, AV24EmpCod, AV25LegNumero, GXv_boolean1, GXv_boolean2, GXv_boolean3, GXv_boolean4, GXv_boolean5, GXv_boolean6, GXv_boolean7) ;
         diasmesparahsegunalgoritmo.this.AV20LegTrabDo = GXv_boolean1[0] ;
         diasmesparahsegunalgoritmo.this.AV16LegTrabLun = GXv_boolean2[0] ;
         diasmesparahsegunalgoritmo.this.AV17LegTrabMar = GXv_boolean3[0] ;
         diasmesparahsegunalgoritmo.this.AV22LegTrabMie = GXv_boolean4[0] ;
         diasmesparahsegunalgoritmo.this.AV18LegTrabJue = GXv_boolean5[0] ;
         diasmesparahsegunalgoritmo.this.AV19LegTrabVie = GXv_boolean6[0] ;
         diasmesparahsegunalgoritmo.this.AV21LegTrabSa = GXv_boolean7[0] ;
      }
      else
      {
         AV16LegTrabLun = true ;
         AV17LegTrabMar = true ;
         AV22LegTrabMie = true ;
         AV18LegTrabJue = true ;
         AV19LegTrabVie = true ;
      }
      if ( GXutil.strcmp(AV8algoritmoDiasMesHsExt, "diasSemanaMes") == 0 )
      {
         AV14fecha = localUtil.ymdtod( GXutil.year( AV11LiqPeriodo), GXutil.month( AV11LiqPeriodo), 1) ;
         AV29hasta_fecha = GXutil.eomdate( AV11LiqPeriodo) ;
         /* Execute user subroutine: 'RECORRER DIAS' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV10LiqDLog = GXutil.trim( GXutil.str( AV9cantDiasMes, 5, 2)) + httpContext.getMessage( " días de trabajo habitual en ", "") + GXutil.trim( localUtil.cmonth( AV11LiqPeriodo, httpContext.getLanguage( ))) ;
      }
      else if ( GXutil.strcmp(AV8algoritmoDiasMesHsExt, "diasSemanaX4") == 0 )
      {
         if ( AV20LegTrabDo )
         {
            AV12cantDiasHabitual = AV12cantDiasHabitual.add(DecimalUtil.doubleToDec(1)) ;
         }
         if ( AV16LegTrabLun )
         {
            AV12cantDiasHabitual = AV12cantDiasHabitual.add(DecimalUtil.doubleToDec(1)) ;
         }
         if ( AV17LegTrabMar )
         {
            AV12cantDiasHabitual = AV12cantDiasHabitual.add(DecimalUtil.doubleToDec(1)) ;
         }
         if ( AV22LegTrabMie )
         {
            AV12cantDiasHabitual = AV12cantDiasHabitual.add(DecimalUtil.doubleToDec(1)) ;
         }
         if ( AV18LegTrabJue )
         {
            AV12cantDiasHabitual = AV12cantDiasHabitual.add(DecimalUtil.doubleToDec(1)) ;
         }
         if ( AV19LegTrabVie )
         {
            AV12cantDiasHabitual = AV12cantDiasHabitual.add(DecimalUtil.doubleToDec(1)) ;
         }
         if ( AV21LegTrabSa )
         {
            AV12cantDiasHabitual = AV12cantDiasHabitual.add(DecimalUtil.doubleToDec(1)) ;
         }
         AV9cantDiasMes = AV12cantDiasHabitual.multiply(DecimalUtil.doubleToDec(4)) ;
         AV10LiqDLog = GXutil.trim( GXutil.str( AV9cantDiasMes, 5, 2)) + httpContext.getMessage( " días de trabajo habitual (", "") + GXutil.trim( GXutil.str( AV12cantDiasHabitual, 5, 2)) + httpContext.getMessage( " semanales multiplicado por 4)", "") ;
      }
      else if ( GXutil.strcmp(AV8algoritmoDiasMesHsExt, "Promedio") == 0 )
      {
         GXv_char8[0] = AV26LegPromDias ;
         new web.getlegpromdias(remoteHandle, context).execute( AV23CliCod, AV24EmpCod, AV25LegNumero, GXv_char8) ;
         diasmesparahsegunalgoritmo.this.AV26LegPromDias = GXv_char8[0] ;
         AV27promedio_dias_mes_anual.fromJSonString(AV26LegPromDias, null);
         AV32GXV1 = 1 ;
         while ( AV32GXV1 <= AV27promedio_dias_mes_anual.size() )
         {
            AV28item = (web.Sdtpromedio_dias_mes_anual_item)((web.Sdtpromedio_dias_mes_anual_item)AV27promedio_dias_mes_anual.elementAt(-1+AV32GXV1));
            if ( AV28item.getgxTv_Sdtpromedio_dias_mes_anual_item_Anio() == GXutil.year( AV11LiqPeriodo) )
            {
               AV9cantDiasMes = AV28item.getgxTv_Sdtpromedio_dias_mes_anual_item_Cantidad() ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "!obtiene &cantDiasMes ", "")+GXutil.trim( GXutil.str( AV9cantDiasMes, 5, 2))) ;
               if (true) break;
            }
            AV32GXV1 = (int)(AV32GXV1+1) ;
         }
         if ( AV9cantDiasMes.doubleValue() == 0 )
         {
            AV14fecha = localUtil.ymdtod( GXutil.year( AV11LiqPeriodo), 1, 1) ;
            AV29hasta_fecha = localUtil.ymdtod( GXutil.year( AV11LiqPeriodo), 12, 31) ;
            /* Execute user subroutine: 'RECORRER DIAS' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV9cantDiasMes = AV9cantDiasMes.divide(DecimalUtil.doubleToDec(12), 18, java.math.RoundingMode.DOWN) ;
            AV28item = (web.Sdtpromedio_dias_mes_anual_item)new web.Sdtpromedio_dias_mes_anual_item(remoteHandle, context);
            AV28item.setgxTv_Sdtpromedio_dias_mes_anual_item_Anio( (short)(GXutil.year( AV11LiqPeriodo)) );
            AV28item.setgxTv_Sdtpromedio_dias_mes_anual_item_Cantidad( AV9cantDiasMes );
            AV27promedio_dias_mes_anual.add(AV28item, 0);
            new web.setlegpromdias(remoteHandle, context).execute( AV23CliCod, AV24EmpCod, AV25LegNumero, GXutil.trim( AV27promedio_dias_mes_anual.toJSonString(false))) ;
         }
         AV10LiqDLog = GXutil.trim( GXutil.str( AV9cantDiasMes, 5, 2)) + httpContext.getMessage( " días de trabajo habitual en base a promedio anual", "") ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "!&promedio_dias_mes_anual ", "")+AV27promedio_dias_mes_anual.toJSonString(false)) ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'RECORRER DIAS' Routine */
      returnInSub = false ;
      while ( (( GXutil.resetTime(AV14fecha).before( GXutil.resetTime( AV29hasta_fecha )) ) || ( GXutil.dateCompare(GXutil.resetTime(AV14fecha), GXutil.resetTime(AV29hasta_fecha)) )) )
      {
         if ( GXutil.dow( AV14fecha) == 2 )
         {
            if ( AV16LegTrabLun )
            {
               AV9cantDiasMes = AV9cantDiasMes.add(DecimalUtil.doubleToDec(1)) ;
            }
         }
         else if ( GXutil.dow( AV14fecha) == 3 )
         {
            if ( AV17LegTrabMar )
            {
               AV9cantDiasMes = AV9cantDiasMes.add(DecimalUtil.doubleToDec(1)) ;
            }
         }
         else if ( GXutil.dow( AV14fecha) == 4 )
         {
            if ( AV22LegTrabMie )
            {
               AV9cantDiasMes = AV9cantDiasMes.add(DecimalUtil.doubleToDec(1)) ;
            }
         }
         else if ( GXutil.dow( AV14fecha) == 5 )
         {
            if ( AV18LegTrabJue )
            {
               AV9cantDiasMes = AV9cantDiasMes.add(DecimalUtil.doubleToDec(1)) ;
            }
         }
         else if ( GXutil.dow( AV14fecha) == 6 )
         {
            if ( AV19LegTrabVie )
            {
               AV9cantDiasMes = AV9cantDiasMes.add(DecimalUtil.doubleToDec(1)) ;
            }
         }
         else if ( GXutil.dow( AV14fecha) == 7 )
         {
            if ( AV21LegTrabSa )
            {
               AV9cantDiasMes = AV9cantDiasMes.add(DecimalUtil.doubleToDec(1)) ;
            }
         }
         else if ( GXutil.dow( AV14fecha) == 1 )
         {
            if ( AV20LegTrabDo )
            {
               AV9cantDiasMes = AV9cantDiasMes.add(DecimalUtil.doubleToDec(1)) ;
            }
         }
         AV14fecha = GXutil.dadd( AV14fecha, (1)) ;
      }
   }

   protected void cleanup( )
   {
      this.aP5[0] = diasmesparahsegunalgoritmo.this.AV9cantDiasMes;
      this.aP6[0] = diasmesparahsegunalgoritmo.this.AV10LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9cantDiasMes = DecimalUtil.ZERO ;
      AV10LiqDLog = "" ;
      GXv_boolean1 = new boolean[1] ;
      GXv_boolean2 = new boolean[1] ;
      GXv_boolean3 = new boolean[1] ;
      GXv_boolean4 = new boolean[1] ;
      GXv_boolean5 = new boolean[1] ;
      GXv_boolean6 = new boolean[1] ;
      GXv_boolean7 = new boolean[1] ;
      AV14fecha = GXutil.nullDate() ;
      AV29hasta_fecha = GXutil.nullDate() ;
      AV12cantDiasHabitual = DecimalUtil.ZERO ;
      AV26LegPromDias = "" ;
      GXv_char8 = new String[1] ;
      AV27promedio_dias_mes_anual = new GXBaseCollection<web.Sdtpromedio_dias_mes_anual_item>(web.Sdtpromedio_dias_mes_anual_item.class, "item", "PayDay", remoteHandle);
      AV28item = new web.Sdtpromedio_dias_mes_anual_item(remoteHandle, context);
      AV33Pgmname = "" ;
      AV33Pgmname = "DiasMesParaHSegunAlgoritmo" ;
      /* GeneXus formulas. */
      AV33Pgmname = "DiasMesParaHSegunAlgoritmo" ;
      Gx_err = (short)(0) ;
   }

   private short AV24EmpCod ;
   private short Gx_err ;
   private int AV23CliCod ;
   private int AV25LegNumero ;
   private int AV32GXV1 ;
   private java.math.BigDecimal AV9cantDiasMes ;
   private java.math.BigDecimal AV12cantDiasHabitual ;
   private String AV8algoritmoDiasMesHsExt ;
   private String GXv_char8[] ;
   private String AV33Pgmname ;
   private java.util.Date AV11LiqPeriodo ;
   private java.util.Date AV14fecha ;
   private java.util.Date AV29hasta_fecha ;
   private boolean AV20LegTrabDo ;
   private boolean GXv_boolean1[] ;
   private boolean AV16LegTrabLun ;
   private boolean GXv_boolean2[] ;
   private boolean AV17LegTrabMar ;
   private boolean GXv_boolean3[] ;
   private boolean AV22LegTrabMie ;
   private boolean GXv_boolean4[] ;
   private boolean AV18LegTrabJue ;
   private boolean GXv_boolean5[] ;
   private boolean AV19LegTrabVie ;
   private boolean GXv_boolean6[] ;
   private boolean AV21LegTrabSa ;
   private boolean GXv_boolean7[] ;
   private boolean returnInSub ;
   private String AV10LiqDLog ;
   private String AV26LegPromDias ;
   private String[] aP6 ;
   private java.math.BigDecimal[] aP5 ;
   private GXBaseCollection<web.Sdtpromedio_dias_mes_anual_item> AV27promedio_dias_mes_anual ;
   private web.Sdtpromedio_dias_mes_anual_item AV28item ;
}

