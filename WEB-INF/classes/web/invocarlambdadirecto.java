package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class invocarlambdadirecto extends GXProcedure
{
   public invocarlambdadirecto( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( invocarlambdadirecto.class ), "" );
   }

   public invocarlambdadirecto( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 )
   {
      invocarlambdadirecto.this.AV9CliCod = aP0;
      invocarlambdadirecto.this.AV11functionNamePalabra = aP1;
      invocarlambdadirecto.this.AV8body = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8body = GXutil.strReplace( AV8body, "\"", "\\\"") ;
      AV10json = "{" ;
      AV10json += httpContext.getMessage( "\"records\": [", "") ;
      AV10json += "	{" ;
      AV10json += httpContext.getMessage( "		\"body\": \"", "") + GXutil.trim( AV8body) + "\"" ;
      AV10json += "	}" ;
      AV10json += "]" ;
      AV10json += "}" ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV14Pgmname, httpContext.getMessage( "&json ", "")+AV10json) ;
      /* User Code */
       LambdaInvoker invoker = new LambdaInvoker();
      /* User Code */
       String functionName = "mi-funcion-lambda";
      /* User Code */
       String invocationType = "asynchronous";
      /* User Code */
       String jsonPayload = "{\"key\":\"value\"}";
      /* User Code */
       try {
      /* User Code */
       	String result = invoker.handleRequest(functionName, invocationType, jsonPayload);
      /* User Code */
       	System.out.println("Resultado de la invocación: " + result);
      /* User Code */
       } catch (Exception e) {
      /* User Code */
       	e.printStackTrace();
      /* User Code */
       }
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10json = "" ;
      AV14Pgmname = "" ;
      AV14Pgmname = "invocarLambdaDirecto" ;
      /* GeneXus formulas. */
      AV14Pgmname = "invocarLambdaDirecto" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private String AV11functionNamePalabra ;
   private String AV14Pgmname ;
   private String AV8body ;
   private String AV10json ;
}

