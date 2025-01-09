package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.wwpbaseobjects.secchangepassword", "/web.wwpbaseobjects.secchangepassword"})
public final  class secchangepassword extends GXWebObjectStub
{
   public secchangepassword( )
   {
   }

   public secchangepassword( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( secchangepassword.class ));
   }

   public secchangepassword( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new secchangepassword_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new secchangepassword_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Cambiar Contraseña";
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

