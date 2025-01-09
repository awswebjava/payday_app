package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obtoperandosformula extends GXProcedure
{
   public obtoperandosformula( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obtoperandosformula.class ), "" );
   }

   public obtoperandosformula( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<web.SdtSDTOperandosFormula> executeUdp( int aP0 ,
                                                                   String aP1 ,
                                                                   String aP2 ,
                                                                   java.math.BigDecimal aP3 ,
                                                                   java.math.BigDecimal aP4 ,
                                                                   java.math.BigDecimal aP5 )
   {
      obtoperandosformula.this.aP6 = new GXBaseCollection[] {new GXBaseCollection<web.SdtSDTOperandosFormula>()};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        java.math.BigDecimal aP3 ,
                        java.math.BigDecimal aP4 ,
                        java.math.BigDecimal aP5 ,
                        GXBaseCollection<web.SdtSDTOperandosFormula>[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             java.math.BigDecimal aP3 ,
                             java.math.BigDecimal aP4 ,
                             java.math.BigDecimal aP5 ,
                             GXBaseCollection<web.SdtSDTOperandosFormula>[] aP6 )
   {
      obtoperandosformula.this.AV28CliCod = aP0;
      obtoperandosformula.this.AV18ConCodigo = aP1;
      obtoperandosformula.this.AV12LiqDFormula = aP2;
      obtoperandosformula.this.AV22LiqDCanti = aP3;
      obtoperandosformula.this.AV24LiqDImporte = aP4;
      obtoperandosformula.this.AV26LiqDValUni = aP5;
      obtoperandosformula.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( AV15SDTOperandos.size() == 0 )
      {
         AV9EsMatriz = false ;
         AV8Empieza = false ;
         AV10Finaliza = false ;
         AV14Pos = (short)(1) ;
         while ( AV14Pos <= GXutil.len( AV12LiqDFormula) )
         {
            if ( ( GXutil.strcmp(GXutil.substring( AV12LiqDFormula, AV14Pos, 1), "[") == 0 ) || ( GXutil.strcmp(GXutil.substring( AV12LiqDFormula, AV14Pos, 1), "{") == 0 ) )
            {
               AV8Empieza = true ;
            }
            if ( ( GXutil.strcmp(GXutil.substring( AV12LiqDFormula, AV14Pos, 1), "]") == 0 ) || ( GXutil.strcmp(GXutil.substring( AV12LiqDFormula, AV14Pos, 1), "}") == 0 ) )
            {
               AV10Finaliza = true ;
            }
            if ( ( AV8Empieza ) && ! AV10Finaliza )
            {
               AV13Operando += GXutil.substring( AV12LiqDFormula, AV14Pos, 1) ;
            }
            if ( AV10Finaliza )
            {
               AV13Operando += GXutil.substring( AV12LiqDFormula, AV14Pos, 1) ;
               /* Execute user subroutine: 'CARGAOPERANDO' */
               S111 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV8Empieza = false ;
               AV10Finaliza = false ;
               AV13Operando = "" ;
            }
            AV14Pos = (short)(AV14Pos+1) ;
         }
         AV11i = (short)(1) ;
         AV17anterior = "" ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, httpContext.getMessage( "antes &SDTOperandos.Count  ", "")+GXutil.trim( GXutil.str( AV15SDTOperandos.size(), 9, 0))) ;
         AV15SDTOperandos.sort(httpContext.getMessage( "OperandoOriginal", ""));
         while ( AV11i <= AV15SDTOperandos.size() )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, httpContext.getMessage( "original ", "")+GXutil.trim( ((web.SdtSDTOperandosFormula)AV15SDTOperandos.elementAt(-1+AV11i)).getgxTv_SdtSDTOperandosFormula_Operandooriginal())+httpContext.getMessage( " anterior ", "")+GXutil.trim( AV17anterior)) ;
            if ( GXutil.strcmp(GXutil.trim( ((web.SdtSDTOperandosFormula)AV15SDTOperandos.elementAt(-1+AV11i)).getgxTv_SdtSDTOperandosFormula_Operandooriginal()), GXutil.trim( AV17anterior)) == 0 )
            {
               AV15SDTOperandos.removeItem(AV11i);
               new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, httpContext.getMessage( "remueve ", "")+AV17anterior) ;
            }
            else
            {
               AV17anterior = ((web.SdtSDTOperandosFormula)AV15SDTOperandos.elementAt(-1+AV11i)).getgxTv_SdtSDTOperandosFormula_Operandooriginal() ;
               AV11i = (short)(AV11i+1) ;
            }
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'CARGAOPERANDO' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV18ConCodigo, httpContext.getMessage( "REM001", "")) == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, httpContext.getMessage( "&Operando ", "")+GXutil.trim( AV13Operando)) ;
      }
      if ( ( GXutil.strSearch( AV13Operando, "[", 1) != 0 ) || ( GXutil.strSearch( AV13Operando, "{", 1) != 0 ) )
      {
         AV16SDTOperandosItem = (web.SdtSDTOperandosFormula)new web.SdtSDTOperandosFormula(remoteHandle, context);
         AV16SDTOperandosItem.setgxTv_SdtSDTOperandosFormula_Operandooriginal( AV13Operando );
         AV16SDTOperandosItem.setgxTv_SdtSDTOperandosFormula_Length( (short)(GXutil.len( AV13Operando)) );
         GXv_char1[0] = AV21mismaCantidadPalabra ;
         new web.codigoopeformula(remoteHandle, context).execute( AV28CliCod, "[novedad_cantidad]", false, false, GXv_char1) ;
         obtoperandosformula.this.AV21mismaCantidadPalabra = GXv_char1[0] ;
         GXv_char1[0] = AV23mismoImportePalabra ;
         new web.codigoopeformula(remoteHandle, context).execute( AV28CliCod, "[novedad_importe]", false, false, GXv_char1) ;
         obtoperandosformula.this.AV23mismoImportePalabra = GXv_char1[0] ;
         if ( GXutil.strcmp(AV18ConCodigo, httpContext.getMessage( "REM001", "")) == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, httpContext.getMessage( "&Operando upper ", "")+GXutil.upper( GXutil.trim( AV13Operando))+httpContext.getMessage( " &mismaCantidadPalabra ", "")+GXutil.upper( GXutil.trim( AV21mismaCantidadPalabra))) ;
         }
         if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV13Operando)), GXutil.upper( GXutil.trim( AV21mismaCantidadPalabra))) == 0 )
         {
            AV16SDTOperandosItem.setgxTv_SdtSDTOperandosFormula_Operandocambiado( GXutil.trim( GXutil.str( AV22LiqDCanti, 14, 2)) );
            if ( GXutil.strcmp(AV18ConCodigo, httpContext.getMessage( "REM001", "")) == 0 )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, httpContext.getMessage( "pone ", "")+GXutil.trim( GXutil.str( AV22LiqDCanti, 14, 2))) ;
            }
            AV16SDTOperandosItem.setgxTv_SdtSDTOperandosFormula_Operandocambiado2( localUtil.format( AV22LiqDCanti, "ZZ,ZZZ,ZZZ,ZZ9.99") );
         }
         else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV13Operando)), GXutil.upper( GXutil.trim( AV23mismoImportePalabra))) == 0 )
         {
            AV16SDTOperandosItem.setgxTv_SdtSDTOperandosFormula_Operandocambiado( GXutil.trim( GXutil.str( AV24LiqDImporte, 14, 2)) );
            AV16SDTOperandosItem.setgxTv_SdtSDTOperandosFormula_Operandocambiado2( localUtil.format( AV24LiqDImporte, "ZZ,ZZZ,ZZZ,ZZ9.99") );
         }
         else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV13Operando)), GXutil.upper( GXutil.trim( AV25mismoValorUniPalabra))) == 0 )
         {
            AV16SDTOperandosItem.setgxTv_SdtSDTOperandosFormula_Operandocambiado( GXutil.trim( GXutil.str( AV26LiqDValUni, 14, 2)) );
            AV16SDTOperandosItem.setgxTv_SdtSDTOperandosFormula_Operandocambiado2( localUtil.format( AV26LiqDValUni, "ZZ,ZZZ,ZZZ,ZZ9.99") );
         }
         AV15SDTOperandos.add(AV16SDTOperandosItem, 0);
      }
   }

   protected void cleanup( )
   {
      this.aP6[0] = obtoperandosformula.this.AV15SDTOperandos;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15SDTOperandos = new GXBaseCollection<web.SdtSDTOperandosFormula>(web.SdtSDTOperandosFormula.class, "SDTOperandosFormula", "PayDay", remoteHandle);
      AV13Operando = "" ;
      AV17anterior = "" ;
      AV31Pgmname = "" ;
      AV16SDTOperandosItem = new web.SdtSDTOperandosFormula(remoteHandle, context);
      AV21mismaCantidadPalabra = "" ;
      AV23mismoImportePalabra = "" ;
      GXv_char1 = new String[1] ;
      AV25mismoValorUniPalabra = "" ;
      AV31Pgmname = "ObtOperandosFormula" ;
      /* GeneXus formulas. */
      AV31Pgmname = "ObtOperandosFormula" ;
      Gx_err = (short)(0) ;
   }

   private short AV14Pos ;
   private short AV11i ;
   private short Gx_err ;
   private int AV28CliCod ;
   private java.math.BigDecimal AV22LiqDCanti ;
   private java.math.BigDecimal AV24LiqDImporte ;
   private java.math.BigDecimal AV26LiqDValUni ;
   private String AV18ConCodigo ;
   private String AV31Pgmname ;
   private String AV21mismaCantidadPalabra ;
   private String AV23mismoImportePalabra ;
   private String GXv_char1[] ;
   private String AV25mismoValorUniPalabra ;
   private boolean AV9EsMatriz ;
   private boolean AV8Empieza ;
   private boolean AV10Finaliza ;
   private boolean returnInSub ;
   private String AV12LiqDFormula ;
   private String AV13Operando ;
   private String AV17anterior ;
   private GXBaseCollection<web.SdtSDTOperandosFormula>[] aP6 ;
   private GXBaseCollection<web.SdtSDTOperandosFormula> AV15SDTOperandos ;
   private web.SdtSDTOperandosFormula AV16SDTOperandosItem ;
}

