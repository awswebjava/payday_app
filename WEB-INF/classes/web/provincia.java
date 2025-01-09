package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.provincia", "/web.provincia"})
public final  class provincia extends GXWebObjectStub
{
   public provincia( )
   {
   }

   public provincia( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( provincia.class ));
   }

   public provincia( int remoteHandle ,
                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new provincia_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new provincia_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Provincia";
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
      return "provincia_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

