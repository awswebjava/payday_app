package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.f1357legdedgen", "/web.f1357legdedgen"})
public final  class f1357legdedgen extends GXWebObjectStub
{
   public f1357legdedgen( )
   {
   }

   public f1357legdedgen( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( f1357legdedgen.class ));
   }

   public f1357legdedgen( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new f1357legdedgen_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new f1357legdedgen_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "F1357 Leg Ded Gen";
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

