package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.situacionrevistaafipww", "/web.situacionrevistaafipww"})
public final  class situacionrevistaafipww extends GXWebObjectStub
{
   public situacionrevistaafipww( )
   {
   }

   public situacionrevistaafipww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( situacionrevistaafipww.class ));
   }

   public situacionrevistaafipww( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new situacionrevistaafipww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new situacionrevistaafipww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Situacion Revista AFIP";
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

