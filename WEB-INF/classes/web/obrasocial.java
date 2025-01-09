package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.obrasocial", "/web.obrasocial"})
public final  class obrasocial extends GXWebObjectStub
{
   public obrasocial( )
   {
   }

   public obrasocial( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( obrasocial.class ));
   }

   public obrasocial( int remoteHandle ,
                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new obrasocial_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new obrasocial_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Obra Social";
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
      return "obrasocial_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

