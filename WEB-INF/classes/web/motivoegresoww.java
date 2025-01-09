package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.motivoegresoww", "/web.motivoegresoww"})
public final  class motivoegresoww extends GXWebObjectStub
{
   public motivoegresoww( )
   {
   }

   public motivoegresoww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( motivoegresoww.class ));
   }

   public motivoegresoww( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new motivoegresoww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new motivoegresoww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Motivo Egreso";
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

