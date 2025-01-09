package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class setopcionmenusesion extends GXProcedure
{
   public setopcionmenusesion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( setopcionmenusesion.class ), "" );
   }

   public setopcionmenusesion( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 )
   {
      setopcionmenusesion.this.AV8MenuOpcCod = aP0;
      setopcionmenusesion.this.AV10modo = aP1;
      setopcionmenusesion.this.AV11headTitle = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ! (GXutil.strcmp("", AV8MenuOpcCod)==0) )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "setea ", "")+AV8MenuOpcCod) ;
         AV9websession.setValue(httpContext.getMessage( "&selMenuOpcCod", ""), GXutil.trim( AV8MenuOpcCod));
         AV9websession.setValue(httpContext.getMessage( "&sel_Menu_Modo", ""), "");
         AV9websession.setValue(httpContext.getMessage( "&sel_HeadTitle", ""), "");
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV10modo)==0) )
         {
            if ( GXutil.strcmp(AV10modo, httpContext.getMessage( "INS", "")) == 0 )
            {
               AV9websession.setValue(httpContext.getMessage( "&sel_Menu_Modo", ""), httpContext.getMessage( "(Alta)", ""));
            }
            else if ( GXutil.strcmp(AV10modo, httpContext.getMessage( "UPD", "")) == 0 )
            {
               AV9websession.setValue(httpContext.getMessage( "&sel_Menu_Modo", ""), httpContext.getMessage( "(Modificar)", ""));
            }
            else if ( GXutil.strcmp(AV10modo, httpContext.getMessage( "DLT", "")) == 0 )
            {
               AV9websession.setValue(httpContext.getMessage( "&sel_Menu_Modo", ""), httpContext.getMessage( "(Eliminar)", ""));
            }
            else if ( GXutil.strcmp(AV10modo, httpContext.getMessage( "DSP", "")) == 0 )
            {
               AV9websession.setValue(httpContext.getMessage( "&sel_Menu_Modo", ""), httpContext.getMessage( "(Visualizar)", ""));
            }
         }
         if ( ! (GXutil.strcmp("", AV11headTitle)==0) )
         {
            AV9websession.setValue(httpContext.getMessage( "&sel_HeadTitle", ""), GXutil.trim( AV11headTitle));
            new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "setea &headTitle ", "")+AV11headTitle) ;
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
      AV14Pgmname = "" ;
      AV9websession = httpContext.getWebSession();
      AV14Pgmname = "setOpcionMenuSesion" ;
      /* GeneXus formulas. */
      AV14Pgmname = "setOpcionMenuSesion" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV10modo ;
   private String AV14Pgmname ;
   private String AV8MenuOpcCod ;
   private String AV11headTitle ;
   private com.genexus.webpanels.WebSession AV9websession ;
}

