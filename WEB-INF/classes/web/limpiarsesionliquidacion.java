package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class limpiarsesionliquidacion extends GXProcedure
{
   public limpiarsesionliquidacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( limpiarsesionliquidacion.class ), "" );
   }

   public limpiarsesionliquidacion( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( )
   {
      execute_int();
   }

   private void execute_int( )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8websession.remove(httpContext.getMessage( "&erroresLiq", ""));
      AV8websession.remove(httpContext.getMessage( "contexto_Liquidacion", ""));
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
      AV8websession = httpContext.getWebSession();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private com.genexus.webpanels.WebSession AV8websession ;
}

