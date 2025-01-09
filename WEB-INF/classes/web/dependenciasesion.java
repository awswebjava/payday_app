package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class dependenciasesion extends GXProcedure
{
   public dependenciasesion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( dependenciasesion.class ), "" );
   }

   public dependenciasesion( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( String aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String aP0 )
   {
      dependenciasesion.this.AV10ConCodigo = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( false )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV13Pgmname, "1 "+AV10ConCodigo) ;
         if ( GXutil.strcmp(AV8websession.getValue(httpContext.getMessage( "LiqOrdenAutomatico", "")), httpContext.getMessage( "SI", "")) == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV13Pgmname, "2") ;
            AV9col_concodigo.fromJSonString(AV8websession.getValue(httpContext.getMessage( "ordenAutomatico", "")), null);
            new web.msgdebug_prod(remoteHandle, context).execute( AV13Pgmname, httpContext.getMessage( "3 count ", "")+GXutil.trim( GXutil.str( AV9col_concodigo.size(), 9, 0))) ;
            AV9col_concodigo.add(AV10ConCodigo, 0);
            AV8websession.setValue(httpContext.getMessage( "ordenAutomatico", ""), AV9col_concodigo.toJSonString(false));
         }
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
      AV13Pgmname = "" ;
      AV8websession = httpContext.getWebSession();
      AV9col_concodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      AV13Pgmname = "DependenciaSesion" ;
      /* GeneXus formulas. */
      AV13Pgmname = "DependenciaSesion" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV10ConCodigo ;
   private String AV13Pgmname ;
   private com.genexus.webpanels.WebSession AV8websession ;
   private GXSimpleCollection<String> AV9col_concodigo ;
}

