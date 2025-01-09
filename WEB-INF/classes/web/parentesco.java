package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.parentesco", "/web.parentesco"})
public final  class parentesco extends GXWebObjectStub
{
   public parentesco( )
   {
   }

   public parentesco( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( parentesco.class ));
   }

   public parentesco( int remoteHandle ,
                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new parentesco_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new parentesco_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Parentesco";
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
      return "parentesco_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

