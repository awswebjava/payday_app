package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class formulaevaluarexpresion extends GXProcedure
{
   public formulaevaluarexpresion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( formulaevaluarexpresion.class ), "" );
   }

   public formulaevaluarexpresion( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              String aP1 ,
                              boolean aP2 ,
                              String[] aP3 ,
                              java.math.BigDecimal[] aP4 )
   {
      formulaevaluarexpresion.this.aP5 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        String[] aP3 ,
                        java.math.BigDecimal[] aP4 ,
                        boolean[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             String[] aP3 ,
                             java.math.BigDecimal[] aP4 ,
                             boolean[] aP5 )
   {
      formulaevaluarexpresion.this.AV8FormulaAux = aP0;
      formulaevaluarexpresion.this.AV9llamador = aP1;
      formulaevaluarexpresion.this.AV11dependenciasResueltas = aP2;
      formulaevaluarexpresion.this.Gx_msg = aP3[0];
      this.aP3 = aP3;
      formulaevaluarexpresion.this.aP4 = aP4;
      formulaevaluarexpresion.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV10variableNoIdentificada ;
      GXv_char2[0] = GXt_char1 ;
      new web.wwpbaseobjects.gettextvariablenoidentificada(remoteHandle, context).execute( "", GXv_char2) ;
      formulaevaluarexpresion.this.GXt_char1 = GXv_char2[0] ;
      AV10variableNoIdentificada = GXt_char1 ;
      if ( GXutil.strSearch( GXutil.trim( AV8FormulaAux), GXutil.trim( AV10variableNoIdentificada), 1) != 0 )
      {
         if ( GXutil.strcmp(AV9llamador, httpContext.getMessage( "EDITOR", "")) != 0 )
         {
            Gx_msg = AV10variableNoIdentificada + " .... 1" ;
            new web.msgdebug(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "encuentra", "")) ;
         }
         else
         {
            Gx_msg = AV16ERROR + " .... 2" ;
         }
         AV12Resultado = DecimalUtil.doubleToDec(0) ;
      }
      else
      {
         if ( AV11dependenciasResueltas )
         {
            AV13Expresion.setExpression( GXutil.trim( AV8FormulaAux) );
            AV12Resultado = AV13Expresion.evaluate() ;
            if ( AV13Expresion.getErrCode() != 0 )
            {
               if ( AV13Expresion.getErrCode() == 1 )
               {
                  Gx_msg = httpContext.getMessage( "Error desconocido", "") ;
               }
               else if ( AV13Expresion.getErrCode() == 2 )
               {
                  Gx_msg = httpContext.getMessage( "Error en los parametros de la formula", "") ;
               }
               else if ( AV13Expresion.getErrCode() == 3 )
               {
                  Gx_msg = httpContext.getMessage( "Error la formula no esta bien creada", "") ;
               }
               else if ( AV13Expresion.getErrCode() == 4 )
               {
                  AV15FormulaAux2 = GXutil.strReplace( AV8FormulaAux, " / 0", "  / 1") ;
                  AV17Expresion2.setExpression( AV15FormulaAux2 );
                  AV17Expresion2.evaluate();
                  if ( AV17Expresion2.getErrCode() != 0 )
                  {
                     Gx_msg = httpContext.getMessage( "Error al evaluar la expresión \"", "") + GXutil.trim( AV8FormulaAux) + "\"" ;
                  }
                  else
                  {
                     AV14FormOK = true ;
                  }
               }
               else if ( AV13Expresion.getErrCode() == 5 )
               {
                  Gx_msg = httpContext.getMessage( "Error en la ejecucion de la funcion", "") ;
               }
               else
               {
                  Gx_msg = GXutil.trim( AV13Expresion.getErrDescription()) + " ...4" ;
               }
            }
            else
            {
               AV14FormOK = true ;
            }
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = formulaevaluarexpresion.this.Gx_msg;
      this.aP4[0] = formulaevaluarexpresion.this.AV12Resultado;
      this.aP5[0] = formulaevaluarexpresion.this.AV14FormOK;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12Resultado = DecimalUtil.ZERO ;
      AV10variableNoIdentificada = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      AV22Pgmname = "" ;
      AV16ERROR = "" ;
      AV13Expresion = new com.genexus.util.ExpressionEvaluator(context, remoteHandle);
      AV15FormulaAux2 = "" ;
      AV17Expresion2 = new com.genexus.util.ExpressionEvaluator(context, remoteHandle);
      AV22Pgmname = "formulaEvaluarExpresion" ;
      /* GeneXus formulas. */
      AV22Pgmname = "formulaEvaluarExpresion" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private java.math.BigDecimal AV12Resultado ;
   private String AV9llamador ;
   private String Gx_msg ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String AV22Pgmname ;
   private boolean AV11dependenciasResueltas ;
   private boolean AV14FormOK ;
   private String AV8FormulaAux ;
   private String AV15FormulaAux2 ;
   private String AV10variableNoIdentificada ;
   private String AV16ERROR ;
   private com.genexus.util.ExpressionEvaluator AV13Expresion ;
   private com.genexus.util.ExpressionEvaluator AV17Expresion2 ;
   private boolean[] aP5 ;
   private String[] aP3 ;
   private java.math.BigDecimal[] aP4 ;
}

