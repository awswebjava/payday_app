package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.legajo_deduccionesww", "/web.legajo_deduccionesww"})
public final  class legajo_deduccionesww extends GXWebObjectStub
{
   public legajo_deduccionesww( )
   {
   }

   public legajo_deduccionesww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( legajo_deduccionesww.class ));
   }

   public legajo_deduccionesww( int remoteHandle ,
                                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new legajo_deduccionesww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new legajo_deduccionesww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Siradig";
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

