package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class validasesion extends GXProcedure
{
   public validasesion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( validasesion.class ), "" );
   }

   public validasesion( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( String aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String aP0 )
   {
      validasesion.this.AV12actualURL = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV9SecUserName ;
      GXv_char2[0] = GXt_char1 ;
      new web.getusulogged(remoteHandle, context).execute( GXv_char2) ;
      validasesion.this.GXt_char1 = GXv_char2[0] ;
      AV9SecUserName = GXt_char1 ;
      if ( (GXutil.strcmp("", AV9SecUserName)==0) )
      {
         AV10websession.destroy();
         callWebObject(formatLink("web.login", new String[] {GXutil.URLEncode(GXutil.rtrim("")),GXutil.URLEncode(GXutil.rtrim(AV12actualURL))}, new String[] {"defaultSecUserName","URL"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      else
      {
         if ( GXutil.strSearch( GXutil.upper( AV12actualURL), httpContext.getMessage( "CLICOD", ""), 1) != 0 )
         {
            AV15splits = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV12actualURL,"&")) ;
            AV17i = (short)(1) ;
            while ( AV17i <= AV15splits.size() )
            {
               AV16splits2 = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split((String)AV15splits.elementAt(-1+AV17i),"=")) ;
               if ( AV16splits2.size() == 2 )
               {
                  if ( GXutil.strSearch( GXutil.upper( (String)AV16splits2.elementAt(-1+1)), httpContext.getMessage( "CLICOD", ""), 1) != 0 )
                  {
                     AV13urlCliCod = (int)(GXutil.lval( (String)AV16splits2.elementAt(-1+2))) ;
                  }
               }
               AV17i = (short)(AV17i+1) ;
            }
            if ( ! (0==AV13urlCliCod) )
            {
               GXt_int3 = AV14CliCod ;
               GXv_int4[0] = GXt_int3 ;
               new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
               validasesion.this.GXt_int3 = GXv_int4[0] ;
               AV14CliCod = GXt_int3 ;
               if ( AV13urlCliCod != AV14CliCod )
               {
                  callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"GxObject"}) );
                  httpContext.wjLocDisableFrm = (byte)(1) ;
               }
            }
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
      AV9SecUserName = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      AV10websession = httpContext.getWebSession();
      AV15splits = new GXSimpleCollection<String>(String.class, "internal", "");
      AV16splits2 = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_int4 = new int[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV17i ;
   private short Gx_err ;
   private int AV13urlCliCod ;
   private int AV14CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String AV12actualURL ;
   private String AV9SecUserName ;
   private com.genexus.webpanels.WebSession AV10websession ;
   private GXSimpleCollection<String> AV15splits ;
   private GXSimpleCollection<String> AV16splits2 ;
}

