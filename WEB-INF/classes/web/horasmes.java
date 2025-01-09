package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class horasmes extends GXProcedure
{
   public horasmes( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( horasmes.class ), "" );
   }

   public horasmes( int remoteHandle ,
                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             java.math.BigDecimal[] aP4 ,
                             String[] aP5 )
   {
      horasmes.this.aP6 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        java.math.BigDecimal[] aP4 ,
                        String[] aP5 ,
                        String[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             java.math.BigDecimal[] aP4 ,
                             String[] aP5 ,
                             String[] aP6 )
   {
      horasmes.this.AV8CliCod = aP0;
      horasmes.this.AV12EmpCod = aP1;
      horasmes.this.AV13LegNumero = aP2;
      horasmes.this.AV9LiqPeriodo = aP3;
      horasmes.this.aP4 = aP4;
      horasmes.this.aP5 = aP5;
      horasmes.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV21LegConveCodigo ;
      new web.empleadogetconvenio(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV13LegNumero, GXv_char1) ;
      horasmes.this.AV21LegConveCodigo = GXv_char1[0] ;
      GXt_int2 = AV20PaiCod ;
      GXv_int3[0] = GXt_int2 ;
      new web.clientegetpais(remoteHandle, context).execute( AV8CliCod, GXv_int3) ;
      horasmes.this.GXt_int2 = GXv_int3[0] ;
      AV20PaiCod = GXt_int2 ;
      if ( ! (GXutil.strcmp("", AV21LegConveCodigo)==0) )
      {
         GXv_decimal4[0] = AV15mesCantHoras ;
         GXv_char1[0] = AV16algoritmoDiasMesHsExt ;
         new web.getconvediasmespara1hora(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV13LegNumero, AV20PaiCod, AV21LegConveCodigo, AV9LiqPeriodo, GXv_decimal4, GXv_char1) ;
         horasmes.this.AV15mesCantHoras = GXv_decimal4[0] ;
         horasmes.this.AV16algoritmoDiasMesHsExt = GXv_char1[0] ;
         AV22definidoPalabra = httpContext.getMessage( "convenio", "") ;
         /* Execute user subroutine: 'INICIALIZAR HORAS MES' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV15mesCantHoras)==0) )
      {
         GXv_decimal4[0] = AV15mesCantHoras ;
         GXv_char1[0] = AV16algoritmoDiasMesHsExt ;
         new web.getempresadiasmespara1hora(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, GXv_decimal4, GXv_char1) ;
         horasmes.this.AV15mesCantHoras = GXv_decimal4[0] ;
         horasmes.this.AV16algoritmoDiasMesHsExt = GXv_char1[0] ;
         AV22definidoPalabra = httpContext.getMessage( "empresa", "") ;
         /* Execute user subroutine: 'INICIALIZAR HORAS MES' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV15mesCantHoras)==0) )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, "!3") ;
         GXv_decimal4[0] = AV15mesCantHoras ;
         GXv_char1[0] = AV16algoritmoDiasMesHsExt ;
         new web.getpaisdiasmespara1hora(remoteHandle, context).execute( AV20PaiCod, GXv_decimal4, GXv_char1) ;
         horasmes.this.AV15mesCantHoras = GXv_decimal4[0] ;
         horasmes.this.AV16algoritmoDiasMesHsExt = GXv_char1[0] ;
         AV22definidoPalabra = httpContext.getMessage( "país", "") ;
         /* Execute user subroutine: 'INICIALIZAR HORAS MES' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV15mesCantHoras)==0) )
      {
         GXv_char1[0] = AV24error ;
         new web.getcoderrprin(remoteHandle, context).execute( GXv_char1) ;
         horasmes.this.AV24error = GXv_char1[0] ;
         AV24error += httpContext.getMessage( "No se pudo calcular horas del mes", "") ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'INICIALIZAR HORAS MES' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV22definidoPalabra, httpContext.getMessage( "país", "")) == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, httpContext.getMessage( "inisub &mesCantHoras ", "")+GXutil.trim( GXutil.str( AV15mesCantHoras, 5, 1))) ;
      }
      if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV15mesCantHoras)==0) )
      {
         if ( GXutil.strcmp(AV22definidoPalabra, httpContext.getMessage( "país", "")) == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, httpContext.getMessage( "&definidoPalabra ", "")+AV22definidoPalabra) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, httpContext.getMessage( "&algoritmoDiasMesHsExt ", "")+AV16algoritmoDiasMesHsExt+httpContext.getMessage( " &LiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV9LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &cantDiasMes ", "")+GXutil.trim( GXutil.str( AV18cantDiasMes, 5, 2))) ;
         }
         GXv_decimal4[0] = AV18cantDiasMes ;
         GXv_char1[0] = AV19auxLiqDLog ;
         new web.diasmesparahsegunalgoritmo(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV13LegNumero, AV16algoritmoDiasMesHsExt, AV9LiqPeriodo, GXv_decimal4, GXv_char1) ;
         horasmes.this.AV18cantDiasMes = GXv_decimal4[0] ;
         horasmes.this.AV19auxLiqDLog = GXv_char1[0] ;
         if ( GXutil.strcmp(AV22definidoPalabra, httpContext.getMessage( "país", "")) == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, httpContext.getMessage( "&cantDiasMes ", "")+GXutil.trim( GXutil.str( AV18cantDiasMes, 5, 2))+httpContext.getMessage( " &cantHorasDia ", "")+GXutil.trim( GXutil.str( AV17cantHorasDia, 4, 1))+httpContext.getMessage( " &auxLiqDLog ", "")+GXutil.trim( AV19auxLiqDLog)) ;
         }
         GXv_decimal4[0] = AV17cantHorasDia ;
         new web.gethorasdianormal(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV13LegNumero, GXv_decimal4) ;
         horasmes.this.AV17cantHorasDia = GXv_decimal4[0] ;
         AV15mesCantHoras = AV18cantDiasMes.multiply(AV17cantHorasDia) ;
         if ( GXutil.strcmp(AV22definidoPalabra, httpContext.getMessage( "país", "")) == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, httpContext.getMessage( "&mesCantHoras ", "")+GXutil.trim( GXutil.str( AV15mesCantHoras, 5, 1))) ;
         }
         if ( AV15mesCantHoras.doubleValue() > 0 )
         {
            if ( GXutil.strcmp(AV22definidoPalabra, httpContext.getMessage( "país", "")) == 0 )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, httpContext.getMessage( "es mayor a cero", "")) ;
            }
            AV23LiqDLog += " " + GXutil.trim( GXutil.str( AV15mesCantHoras, 5, 1)) + httpContext.getMessage( " horas calculadas por mes resultado de multiplicar días del mes (", "") + GXutil.trim( AV19auxLiqDLog) + httpContext.getMessage( " definido por ", "") + GXutil.trim( AV22definidoPalabra) + httpContext.getMessage( ") por cantidad normal de horas por día ", "") + GXutil.trim( GXutil.str( AV17cantHorasDia, 4, 1)) ;
         }
      }
      else
      {
         if ( AV15mesCantHoras.doubleValue() > 0 )
         {
            AV23LiqDLog += " " + GXutil.trim( GXutil.str( AV15mesCantHoras, 5, 1)) + httpContext.getMessage( " horas fijadas por mes (definido por ", "") + GXutil.trim( AV22definidoPalabra) + ")" ;
         }
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, httpContext.getMessage( "horasmes ", "")+GXutil.trim( AV23LiqDLog)) ;
   }

   protected void cleanup( )
   {
      this.aP4[0] = horasmes.this.AV15mesCantHoras;
      this.aP5[0] = horasmes.this.AV23LiqDLog;
      this.aP6[0] = horasmes.this.AV24error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15mesCantHoras = DecimalUtil.ZERO ;
      AV23LiqDLog = "" ;
      AV24error = "" ;
      AV21LegConveCodigo = "" ;
      GXv_int3 = new short[1] ;
      AV16algoritmoDiasMesHsExt = "" ;
      AV22definidoPalabra = "" ;
      AV27Pgmname = "" ;
      AV18cantDiasMes = DecimalUtil.ZERO ;
      AV19auxLiqDLog = "" ;
      GXv_char1 = new String[1] ;
      AV17cantHorasDia = DecimalUtil.ZERO ;
      GXv_decimal4 = new java.math.BigDecimal[1] ;
      AV27Pgmname = "HorasMes" ;
      /* GeneXus formulas. */
      AV27Pgmname = "HorasMes" ;
      Gx_err = (short)(0) ;
   }

   private short AV12EmpCod ;
   private short AV20PaiCod ;
   private short GXt_int2 ;
   private short GXv_int3[] ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV13LegNumero ;
   private java.math.BigDecimal AV15mesCantHoras ;
   private java.math.BigDecimal AV18cantDiasMes ;
   private java.math.BigDecimal AV17cantHorasDia ;
   private java.math.BigDecimal GXv_decimal4[] ;
   private String AV21LegConveCodigo ;
   private String AV16algoritmoDiasMesHsExt ;
   private String AV22definidoPalabra ;
   private String AV27Pgmname ;
   private String GXv_char1[] ;
   private java.util.Date AV9LiqPeriodo ;
   private boolean returnInSub ;
   private String AV23LiqDLog ;
   private String AV19auxLiqDLog ;
   private String AV24error ;
   private String[] aP6 ;
   private java.math.BigDecimal[] aP4 ;
   private String[] aP5 ;
}

