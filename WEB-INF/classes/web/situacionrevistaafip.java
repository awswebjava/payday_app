package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.situacionrevistaafip", "/web.situacionrevistaafip"})
public final  class situacionrevistaafip extends GXWebObjectStub
{
   public situacionrevistaafip( )
   {
   }

   public situacionrevistaafip( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( situacionrevistaafip.class ));
   }

   public situacionrevistaafip( int remoteHandle ,
                                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new situacionrevistaafip_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new situacionrevistaafip_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Situacion Revista AFIP";
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

