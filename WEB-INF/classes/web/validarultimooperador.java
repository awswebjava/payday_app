package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class validarultimooperador extends GXProcedure
{
   public validarultimooperador( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( validarultimooperador.class ), "" );
   }

   public validarultimooperador( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String aP2 )
   {
      validarultimooperador.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 )
   {
      validarultimooperador.this.AV13clicod = aP0;
      validarultimooperador.this.AV12concodigo = aP1;
      validarultimooperador.this.AV14formula = aP2;
      validarultimooperador.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10FormulaAux = AV14formula ;
      AV9operador = "*" ;
      /* Execute user subroutine: 'VALIDAR' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      if ( (GXutil.strcmp("", AV11error)==0) )
      {
         AV9operador = "+" ;
         /* Execute user subroutine: 'VALIDAR' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      if ( (GXutil.strcmp("", AV11error)==0) )
      {
         AV9operador = "/" ;
         /* Execute user subroutine: 'VALIDAR' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      if ( (GXutil.strcmp("", AV11error)==0) )
      {
         AV9operador = "-" ;
         /* Execute user subroutine: 'VALIDAR' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'VALIDAR' Routine */
      returnInSub = false ;
      AV8collection = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV10FormulaAux,AV9operador)) ;
      new web.msgdebug7(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "&collection ", "")+AV8collection.toJSonString(false)+httpContext.getMessage( " OPERADOR ", "")+AV9operador+httpContext.getMessage( " formaux ", "")+AV10FormulaAux) ;
      if ( ( AV8collection.size() > 1 ) && (GXutil.strcmp("", (String)AV8collection.elementAt(-1+AV8collection.size()))==0) )
      {
         new web.msgdebug7(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "ultimo ", "")+(String)AV8collection.elementAt(-1+AV8collection.size())) ;
         AV11error = httpContext.getMessage( "Error, último operador ", "") + AV9operador ;
         new web.msgdebug7(remoteHandle, context).execute( AV17Pgmname, AV11error) ;
      }
   }

   protected void cleanup( )
   {
      this.aP3[0] = validarultimooperador.this.AV11error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11error = "" ;
      AV10FormulaAux = "" ;
      AV9operador = "" ;
      AV8collection = new GXSimpleCollection<String>(String.class, "internal", "");
      AV17Pgmname = "" ;
      AV17Pgmname = "validarUltimoOperador" ;
      /* GeneXus formulas. */
      AV17Pgmname = "validarUltimoOperador" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV13clicod ;
   private String AV12concodigo ;
   private String AV14formula ;
   private String AV10FormulaAux ;
   private String AV9operador ;
   private String AV17Pgmname ;
   private boolean returnInSub ;
   private String AV11error ;
   private String[] aP3 ;
   private GXSimpleCollection<String> AV8collection ;
}

