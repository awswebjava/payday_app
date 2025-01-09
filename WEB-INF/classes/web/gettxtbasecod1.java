package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gettxtbasecod1 extends GXProcedure
{
   public gettxtbasecod1( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gettxtbasecod1.class ), "" );
   }

   public gettxtbasecod1( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String aP2 )
   {
      gettxtbasecod1.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 )
   {
      gettxtbasecod1.this.AV11CliCod = aP0;
      gettxtbasecod1.this.AV8EmpBaseTipo = aP1;
      gettxtbasecod1.this.AV9EmpBaseCod1 = aP2;
      gettxtbasecod1.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "!1 &EmpBaseTipo ", "")+AV8EmpBaseTipo) ;
      if ( GXutil.strcmp(AV8EmpBaseTipo, "licencia") == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "2 &EmpBaseCod1 ", "")+AV9EmpBaseCod1) ;
         GXv_char1[0] = AV10txt ;
         new web.getsituaciondescrip(remoteHandle, context).execute( GXutil.trim( AV9EmpBaseCod1), GXv_char1) ;
         gettxtbasecod1.this.AV10txt = GXv_char1[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "3 &txt ", "")+AV10txt) ;
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, "4") ;
         AV10txt = GXutil.trim( AV9EmpBaseCod1) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, "5") ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "6 &txt ", "")+AV10txt) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = gettxtbasecod1.this.AV10txt;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10txt = "" ;
      AV14Pgmname = "" ;
      GXv_char1 = new String[1] ;
      AV14Pgmname = "GetTxtBaseCod1" ;
      /* GeneXus formulas. */
      AV14Pgmname = "GetTxtBaseCod1" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV11CliCod ;
   private String AV8EmpBaseTipo ;
   private String AV9EmpBaseCod1 ;
   private String AV14Pgmname ;
   private String GXv_char1[] ;
   private String AV10txt ;
   private String[] aP3 ;
}

