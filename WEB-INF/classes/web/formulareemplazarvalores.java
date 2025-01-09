package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class formulareemplazarvalores extends GXProcedure
{
   public formulareemplazarvalores( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( formulareemplazarvalores.class ), "" );
   }

   public formulareemplazarvalores( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String[] aP1 ,
                             String[] aP2 ,
                             String[] aP3 ,
                             GXBaseCollection<web.SdtSDTOperandosFormula>[] aP4 ,
                             boolean[] aP5 )
   {
      formulareemplazarvalores.this.aP6 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        String[] aP1 ,
                        String[] aP2 ,
                        String[] aP3 ,
                        GXBaseCollection<web.SdtSDTOperandosFormula>[] aP4 ,
                        boolean[] aP5 ,
                        String[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             String[] aP1 ,
                             String[] aP2 ,
                             String[] aP3 ,
                             GXBaseCollection<web.SdtSDTOperandosFormula>[] aP4 ,
                             boolean[] aP5 ,
                             String[] aP6 )
   {
      formulareemplazarvalores.this.AV19LiqNro = aP0;
      formulareemplazarvalores.this.AV13FormulaAux = aP1[0];
      this.aP1 = aP1;
      formulareemplazarvalores.this.AV14formulaConDescripciones = aP2[0];
      this.aP2 = aP2;
      formulareemplazarvalores.this.AV16htmlFormulaAux = aP3[0];
      this.aP3 = aP3;
      formulareemplazarvalores.this.AV8SDTOperandos = aP4[0];
      this.aP4 = aP4;
      formulareemplazarvalores.this.aP5 = aP5;
      formulareemplazarvalores.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9i = (short)(1) ;
      while ( AV9i <= AV8SDTOperandos.size() )
      {
         AV10Original = ((web.SdtSDTOperandosFormula)AV8SDTOperandos.elementAt(-1+AV9i)).getgxTv_SdtSDTOperandosFormula_Operandooriginal() ;
         AV11Resuelto = ((web.SdtSDTOperandosFormula)AV8SDTOperandos.elementAt(-1+AV9i)).getgxTv_SdtSDTOperandosFormula_Operandocambiado() ;
         AV12Resuelto2 = ((web.SdtSDTOperandosFormula)AV8SDTOperandos.elementAt(-1+AV9i)).getgxTv_SdtSDTOperandosFormula_Operandocambiado2() ;
         AV18LiqDLog += httpContext.getMessage( ". original ", "") + GXutil.trim( AV10Original) + httpContext.getMessage( " resuelto ", "") + GXutil.trim( AV11Resuelto) ;
         if ( ! (GXutil.strcmp("", AV11Resuelto)==0) )
         {
            AV13FormulaAux = GXutil.strReplace( AV13FormulaAux, AV10Original, AV11Resuelto) ;
            AV18LiqDLog += httpContext.getMessage( ". Reemplaza \"", "") + GXutil.trim( AV10Original) + httpContext.getMessage( "\" por \"", "") + AV11Resuelto + "\"" ;
            AV18LiqDLog += httpContext.getMessage( ". &FormulaAux ", "") + AV13FormulaAux ;
            AV15htmlResuelto = httpContext.getMessage( "<span title=\"", "") + GXutil.trim( AV10Original) ;
            if ( ! (GXutil.strcmp("", ((web.SdtSDTOperandosFormula)AV8SDTOperandos.elementAt(-1+AV9i)).getgxTv_SdtSDTOperandosFormula_Descripcion())==0) )
            {
               AV15htmlResuelto += " - " + ((web.SdtSDTOperandosFormula)AV8SDTOperandos.elementAt(-1+AV9i)).getgxTv_SdtSDTOperandosFormula_Descripcion() ;
            }
            AV14formulaConDescripciones = GXutil.strReplace( AV14formulaConDescripciones, AV10Original, GXutil.lower( ((web.SdtSDTOperandosFormula)AV8SDTOperandos.elementAt(-1+AV9i)).getgxTv_SdtSDTOperandosFormula_Descripcion())) ;
            AV15htmlResuelto += "\">" + GXutil.trim( AV11Resuelto) + httpContext.getMessage( "</span>", "") ;
            AV15htmlResuelto = GXutil.strReplace( AV15htmlResuelto, ".0000", "") ;
            AV15htmlResuelto = GXutil.strReplace( AV15htmlResuelto, ",0000", "") ;
            AV16htmlFormulaAux = GXutil.strReplace( AV16htmlFormulaAux, AV10Original, AV15htmlResuelto) ;
            AV8SDTOperandos.removeItem(AV9i);
         }
         else
         {
            if ( (0==AV19LiqNro) )
            {
               AV15htmlResuelto = httpContext.getMessage( "<span title=\"", "") + GXutil.trim( AV10Original) ;
               if ( ! (GXutil.strcmp("", ((web.SdtSDTOperandosFormula)AV8SDTOperandos.elementAt(-1+AV9i)).getgxTv_SdtSDTOperandosFormula_Descripcion())==0) )
               {
                  AV15htmlResuelto += " - " + ((web.SdtSDTOperandosFormula)AV8SDTOperandos.elementAt(-1+AV9i)).getgxTv_SdtSDTOperandosFormula_Descripcion() ;
               }
               AV14formulaConDescripciones = GXutil.strReplace( AV14formulaConDescripciones, AV10Original, GXutil.lower( ((web.SdtSDTOperandosFormula)AV8SDTOperandos.elementAt(-1+AV9i)).getgxTv_SdtSDTOperandosFormula_Descripcion())) ;
               AV15htmlResuelto += "\">" + GXutil.trim( AV10Original) + httpContext.getMessage( "</span>", "") ;
               AV15htmlResuelto = GXutil.strReplace( AV15htmlResuelto, ".0000", "") ;
               AV15htmlResuelto = GXutil.strReplace( AV15htmlResuelto, ",0000", "") ;
               AV16htmlFormulaAux = GXutil.strReplace( AV16htmlFormulaAux, AV10Original, AV15htmlResuelto) ;
            }
            AV17faltaResolver = true ;
            AV9i = (short)(AV9i+1) ;
         }
      }
      AV13FormulaAux = GXutil.strReplace( AV13FormulaAux, httpContext.getMessage( "SI(", ""), httpContext.getMessage( "iif(", "")) ;
      AV13FormulaAux = GXutil.strReplace( AV13FormulaAux, httpContext.getMessage( "SI (", ""), httpContext.getMessage( "iif(", "")) ;
      AV13FormulaAux = GXutil.strReplace( AV13FormulaAux, httpContext.getMessage( " Y ", ""), httpContext.getMessage( " and ", "")) ;
      AV13FormulaAux = GXutil.strReplace( AV13FormulaAux, httpContext.getMessage( " O ", ""), httpContext.getMessage( " or ", "")) ;
      AV13FormulaAux = GXutil.strReplace( AV13FormulaAux, httpContext.getMessage( "si(", ""), httpContext.getMessage( "iif(", "")) ;
      AV13FormulaAux = GXutil.strReplace( AV13FormulaAux, httpContext.getMessage( "si (", ""), httpContext.getMessage( "iif(", "")) ;
      AV13FormulaAux = GXutil.strReplace( AV13FormulaAux, httpContext.getMessage( " y ", ""), httpContext.getMessage( " and ", "")) ;
      AV13FormulaAux = GXutil.strReplace( AV13FormulaAux, httpContext.getMessage( " o ", ""), httpContext.getMessage( " or ", "")) ;
      AV13FormulaAux = GXutil.strReplace( AV13FormulaAux, httpContext.getMessage( "Si(", ""), httpContext.getMessage( "iif(", "")) ;
      AV13FormulaAux = GXutil.strReplace( AV13FormulaAux, httpContext.getMessage( "Si (", ""), httpContext.getMessage( "iif(", "")) ;
      AV13FormulaAux = GXutil.strReplace( AV13FormulaAux, httpContext.getMessage( "sI(", ""), httpContext.getMessage( "iif(", "")) ;
      AV13FormulaAux = GXutil.strReplace( AV13FormulaAux, httpContext.getMessage( "sI (", ""), httpContext.getMessage( "iif(", "")) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "liqdlog ", "")+AV18LiqDLog) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = formulareemplazarvalores.this.AV13FormulaAux;
      this.aP2[0] = formulareemplazarvalores.this.AV14formulaConDescripciones;
      this.aP3[0] = formulareemplazarvalores.this.AV16htmlFormulaAux;
      this.aP4[0] = formulareemplazarvalores.this.AV8SDTOperandos;
      this.aP5[0] = formulareemplazarvalores.this.AV17faltaResolver;
      this.aP6[0] = formulareemplazarvalores.this.AV18LiqDLog;
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
      AV10Original = "" ;
      AV11Resuelto = "" ;
      AV12Resuelto2 = "" ;
      AV15htmlResuelto = "" ;
      AV22Pgmname = "" ;
      AV22Pgmname = "formulaReemplazarValores" ;
      /* GeneXus formulas. */
      AV22Pgmname = "formulaReemplazarValores" ;
      Gx_err = (short)(0) ;
   }

   private short AV9i ;
   private short Gx_err ;
   private int AV19LiqNro ;
   private String AV22Pgmname ;
   private boolean AV17faltaResolver ;
   private String AV13FormulaAux ;
   private String AV14formulaConDescripciones ;
   private String AV16htmlFormulaAux ;
   private String AV18LiqDLog ;
   private String AV10Original ;
   private String AV11Resuelto ;
   private String AV12Resuelto2 ;
   private String AV15htmlResuelto ;
   private String[] aP6 ;
   private String[] aP1 ;
   private String[] aP2 ;
   private String[] aP3 ;
   private GXBaseCollection<web.SdtSDTOperandosFormula>[] aP4 ;
   private boolean[] aP5 ;
   private GXBaseCollection<web.SdtSDTOperandosFormula> AV8SDTOperandos ;
}

