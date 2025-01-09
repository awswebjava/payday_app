package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class validargrossingup extends GXProcedure
{
   public validargrossingup( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( validargrossingup.class ), "" );
   }

   public validargrossingup( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.math.BigDecimal aP4 ,
                             boolean[] aP5 )
   {
      validargrossingup.this.aP6 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.math.BigDecimal aP4 ,
                        boolean[] aP5 ,
                        String[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.math.BigDecimal aP4 ,
                             boolean[] aP5 ,
                             String[] aP6 )
   {
      validargrossingup.this.AV13CliCod = aP0;
      validargrossingup.this.AV14EmpCod = aP1;
      validargrossingup.this.AV15LiqNro = aP2;
      validargrossingup.this.AV16LegNumero = aP3;
      validargrossingup.this.AV19LegSuelImporte = aP4;
      validargrossingup.this.aP5 = aP5;
      validargrossingup.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV29Pgmname, httpContext.getMessage( "ini", "")) ;
      GXv_decimal1[0] = DecimalUtil.doubleToDec(0) ;
      GXv_decimal2[0] = AV12descuentosNegativos ;
      GXv_decimal3[0] = DecimalUtil.doubleToDec(0) ;
      GXv_decimal4[0] = DecimalUtil.doubleToDec(0) ;
      GXv_decimal5[0] = DecimalUtil.doubleToDec(0) ;
      GXv_decimal6[0] = DecimalUtil.doubleToDec(0) ;
      GXv_decimal7[0] = DecimalUtil.doubleToDec(0) ;
      GXv_decimal8[0] = DecimalUtil.doubleToDec(0) ;
      GXv_decimal9[0] = AV9remuImportes ;
      GXv_decimal10[0] = AV10noRemuImportes ;
      GXv_decimal11[0] = AV11descuentosImportes ;
      GXv_int12[0] = (short)(0) ;
      new web.calculaimportesliqleg(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV15LiqNro, AV16LegNumero, "", "", "", GXv_decimal1, GXv_decimal2, GXv_decimal3, GXv_decimal4, GXv_decimal5, GXv_decimal6, GXv_decimal7, GXv_decimal8, GXv_decimal9, GXv_decimal10, GXv_decimal11, GXv_int12) ;
      validargrossingup.this.AV12descuentosNegativos = GXv_decimal2[0] ;
      validargrossingup.this.AV9remuImportes = GXv_decimal9[0] ;
      validargrossingup.this.AV10noRemuImportes = GXv_decimal10[0] ;
      validargrossingup.this.AV11descuentosImportes = GXv_decimal11[0] ;
      AV8NetoImportes = AV9remuImportes.add(AV10noRemuImportes).subtract(AV11descuentosImportes).add(AV12descuentosNegativos) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV29Pgmname, httpContext.getMessage( "&NetoImportes ", "")+GXutil.trim( GXutil.str( AV8NetoImportes, 14, 2))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV29Pgmname, httpContext.getMessage( "&&remuImportes ", "")+GXutil.trim( GXutil.str( AV9remuImportes, 14, 2))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV29Pgmname, httpContext.getMessage( "&&&noRemuImportes ", "")+GXutil.trim( GXutil.str( AV10noRemuImportes, 14, 2))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV29Pgmname, httpContext.getMessage( "&&&&descuentosImportes ", "")+GXutil.trim( GXutil.str( AV11descuentosImportes, 14, 2))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV29Pgmname, httpContext.getMessage( "&&&&&descuentosNegativos ", "")+GXutil.trim( GXutil.str( AV12descuentosNegativos, 14, 2))) ;
      AV24keyPalabra = httpContext.getMessage( "grossingup_calculo_", "") + GXutil.trim( GXutil.str( AV13CliCod, 6, 0)) + "_" + GXutil.trim( GXutil.str( AV14EmpCod, 4, 0)) + "_" + GXutil.trim( GXutil.str( AV16LegNumero, 8, 0)) ;
      AV17grossingup_calculo.fromJSonString(AV18websession.getValue(AV24keyPalabra), null);
      AV23ok = true ;
      if ( AV17grossingup_calculo.size() == 0 )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         AV20Error = httpContext.getMessage( "Error al calcular grossing up. No existe cálculo en sesión", "") ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV25auxLegSuelImporte = AV19LegSuelImporte.subtract(((web.Sdtgrossingup_calculo_grossingup_calculoItem)AV17grossingup_calculo.elementAt(-1+AV17grossingup_calculo.size())).getgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Descuentosexcluidos()) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV29Pgmname, httpContext.getMessage( "&NetoImportes ", "")+GXutil.trim( GXutil.str( AV8NetoImportes, 14, 2))+httpContext.getMessage( " &auxLegSuelImporte ", "")+GXutil.trim( GXutil.str( AV25auxLegSuelImporte, 14, 2))) ;
      if ( DecimalUtil.compareTo(AV8NetoImportes, AV25auxLegSuelImporte) < 0 )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV29Pgmname, httpContext.getMessage( "pone menor", "")) ;
         ((web.Sdtgrossingup_calculo_grossingup_calculoItem)AV17grossingup_calculo.elementAt(-1+AV17grossingup_calculo.size())).setgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Resultado( httpContext.getMessage( "Menor", "") );
         /* Execute user subroutine: 'FALTANTE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV23ok = false ;
      }
      else
      {
         GXv_char13[0] = AV22ParmValue ;
         new web.getparametro(remoteHandle, context).execute( AV13CliCod, new web.margennetogrossing_codigoparam(remoteHandle, context).executeUdp( ), GXv_char13) ;
         validargrossingup.this.AV22ParmValue = GXv_char13[0] ;
         AV21sueldoConMargen = AV25auxLegSuelImporte.multiply(CommonUtil.decimalVal( AV22ParmValue, ".")) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV29Pgmname, "1") ;
         if ( DecimalUtil.compareTo(AV8NetoImportes, AV21sueldoConMargen) > 0 )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV29Pgmname, "2") ;
            if ( ((web.Sdtgrossingup_calculo_grossingup_calculoItem)AV17grossingup_calculo.elementAt(-1+AV17grossingup_calculo.size())).getgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Calculo().doubleValue() > 0 )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            if ( Cond_result )
            {
               ((web.Sdtgrossingup_calculo_grossingup_calculoItem)AV17grossingup_calculo.elementAt(-1+AV17grossingup_calculo.size())).setgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Resultado( httpContext.getMessage( "Mayor", "") );
               /* Execute user subroutine: 'FALTANTE' */
               S111 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV23ok = false ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV29Pgmname, "3") ;
            }
            else
            {
               ((web.Sdtgrossingup_calculo_grossingup_calculoItem)AV17grossingup_calculo.elementAt(-1+AV17grossingup_calculo.size())).setgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Resultado( httpContext.getMessage( "OK", "") );
            }
         }
         else
         {
            ((web.Sdtgrossingup_calculo_grossingup_calculoItem)AV17grossingup_calculo.elementAt(-1+AV17grossingup_calculo.size())).setgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Resultado( httpContext.getMessage( "OK", "") );
         }
      }
      if ( AV8NetoImportes.doubleValue() < 0 )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         AV8NetoImportes = DecimalUtil.doubleToDec(0) ;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV29Pgmname, httpContext.getMessage( "!pone neto ", "")+GXutil.trim( GXutil.str( AV8NetoImportes, 14, 2))) ;
      ((web.Sdtgrossingup_calculo_grossingup_calculoItem)AV17grossingup_calculo.elementAt(-1+AV17grossingup_calculo.size())).setgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Neto( AV8NetoImportes );
      new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV29Pgmname, httpContext.getMessage( "setea sesion ", "")+AV17grossingup_calculo.toJSonString(false)) ;
      AV18websession.setValue(AV24keyPalabra, AV17grossingup_calculo.toJSonString(false));
      new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV29Pgmname, httpContext.getMessage( "&ok ", "")+GXutil.trim( GXutil.booltostr( AV23ok))+httpContext.getMessage( " &keyPalabra ", "")+AV24keyPalabra) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'FALTANTE' Routine */
      returnInSub = false ;
      if ( AV8NetoImportes.doubleValue() > 0 )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         ((web.Sdtgrossingup_calculo_grossingup_calculoItem)AV17grossingup_calculo.elementAt(-1+AV17grossingup_calculo.size())).setgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Falta( AV25auxLegSuelImporte.divide(AV8NetoImportes, 18, java.math.RoundingMode.DOWN) );
         new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV29Pgmname, httpContext.getMessage( "positivo setea falta &auxLegSuelImporte ", "")+GXutil.trim( GXutil.str( AV25auxLegSuelImporte, 14, 2))+" / "+GXutil.trim( GXutil.str( AV8NetoImportes, 14, 2))) ;
      }
      else
      {
         if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV8NetoImportes)==0) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            ((web.Sdtgrossingup_calculo_grossingup_calculoItem)AV17grossingup_calculo.elementAt(-1+AV17grossingup_calculo.size())).setgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Falta( DecimalUtil.doubleToDec(2) );
         }
         else
         {
            AV26auxNetoImportes = AV8NetoImportes.multiply(DecimalUtil.doubleToDec(-1)) ;
            ((web.Sdtgrossingup_calculo_grossingup_calculoItem)AV17grossingup_calculo.elementAt(-1+AV17grossingup_calculo.size())).setgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Falta( (AV25auxLegSuelImporte.divide(AV26auxNetoImportes, 18, java.math.RoundingMode.DOWN)) );
            new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV29Pgmname, httpContext.getMessage( "negativo... setea falta &auxLegSuelImporte ", "")+GXutil.trim( GXutil.str( AV25auxLegSuelImporte, 14, 2))+httpContext.getMessage( " &auxNetoImportes ", "")+GXutil.trim( GXutil.str( AV26auxNetoImportes, 14, 2))) ;
         }
      }
   }

   protected void cleanup( )
   {
      this.aP5[0] = validargrossingup.this.AV23ok;
      this.aP6[0] = validargrossingup.this.AV20Error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV20Error = "" ;
      AV29Pgmname = "" ;
      GXv_decimal1 = new java.math.BigDecimal[1] ;
      AV12descuentosNegativos = DecimalUtil.ZERO ;
      GXv_decimal2 = new java.math.BigDecimal[1] ;
      GXv_decimal3 = new java.math.BigDecimal[1] ;
      GXv_decimal4 = new java.math.BigDecimal[1] ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      GXv_decimal6 = new java.math.BigDecimal[1] ;
      GXv_decimal7 = new java.math.BigDecimal[1] ;
      GXv_decimal8 = new java.math.BigDecimal[1] ;
      AV9remuImportes = DecimalUtil.ZERO ;
      GXv_decimal9 = new java.math.BigDecimal[1] ;
      AV10noRemuImportes = DecimalUtil.ZERO ;
      GXv_decimal10 = new java.math.BigDecimal[1] ;
      AV11descuentosImportes = DecimalUtil.ZERO ;
      GXv_decimal11 = new java.math.BigDecimal[1] ;
      GXv_int12 = new short[1] ;
      AV8NetoImportes = DecimalUtil.ZERO ;
      AV24keyPalabra = "" ;
      AV17grossingup_calculo = new GXBaseCollection<web.Sdtgrossingup_calculo_grossingup_calculoItem>(web.Sdtgrossingup_calculo_grossingup_calculoItem.class, "grossingup_calculoItem", "PayDay", remoteHandle);
      AV18websession = httpContext.getWebSession();
      AV25auxLegSuelImporte = DecimalUtil.ZERO ;
      AV22ParmValue = "" ;
      GXv_char13 = new String[1] ;
      AV21sueldoConMargen = DecimalUtil.ZERO ;
      AV26auxNetoImportes = DecimalUtil.ZERO ;
      AV29Pgmname = "validarGrossingUP" ;
      /* GeneXus formulas. */
      AV29Pgmname = "validarGrossingUP" ;
      Gx_err = (short)(0) ;
   }

   private short AV14EmpCod ;
   private short GXv_int12[] ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV15LiqNro ;
   private int AV16LegNumero ;
   private java.math.BigDecimal AV19LegSuelImporte ;
   private java.math.BigDecimal GXv_decimal1[] ;
   private java.math.BigDecimal AV12descuentosNegativos ;
   private java.math.BigDecimal GXv_decimal2[] ;
   private java.math.BigDecimal GXv_decimal3[] ;
   private java.math.BigDecimal GXv_decimal4[] ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private java.math.BigDecimal GXv_decimal6[] ;
   private java.math.BigDecimal GXv_decimal7[] ;
   private java.math.BigDecimal GXv_decimal8[] ;
   private java.math.BigDecimal AV9remuImportes ;
   private java.math.BigDecimal GXv_decimal9[] ;
   private java.math.BigDecimal AV10noRemuImportes ;
   private java.math.BigDecimal GXv_decimal10[] ;
   private java.math.BigDecimal AV11descuentosImportes ;
   private java.math.BigDecimal GXv_decimal11[] ;
   private java.math.BigDecimal AV8NetoImportes ;
   private java.math.BigDecimal AV25auxLegSuelImporte ;
   private java.math.BigDecimal AV21sueldoConMargen ;
   private java.math.BigDecimal AV26auxNetoImportes ;
   private String AV29Pgmname ;
   private String AV24keyPalabra ;
   private String GXv_char13[] ;
   private boolean AV23ok ;
   private boolean Cond_result ;
   private boolean returnInSub ;
   private String AV22ParmValue ;
   private String AV20Error ;
   private com.genexus.webpanels.WebSession AV18websession ;
   private String[] aP6 ;
   private boolean[] aP5 ;
   private GXBaseCollection<web.Sdtgrossingup_calculo_grossingup_calculoItem> AV17grossingup_calculo ;
}

