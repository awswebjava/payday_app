package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getusuloggedid extends GXProcedure
{
   public getusuloggedid( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getusuloggedid.class ), "" );
   }

   public getusuloggedid( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( )
   {
      getusuloggedid.this.aP0 = new short[] {0};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( short[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( short[] aP0 )
   {
      getusuloggedid.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV8SecUserName ;
      new web.getusulogged(remoteHandle, context).execute( GXv_char1) ;
      getusuloggedid.this.AV8SecUserName = GXv_char1[0] ;
      GXv_int2[0] = AV9SecUserId ;
      new web.getuserid(remoteHandle, context).execute( AV8SecUserName, GXv_int2) ;
      getusuloggedid.this.AV9SecUserId = GXv_int2[0] ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = getusuloggedid.this.AV9SecUserId;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8SecUserName = "" ;
      GXv_char1 = new String[1] ;
      GXv_int2 = new short[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9SecUserId ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private String GXv_char1[] ;
   private String AV8SecUserName ;
   private short[] aP0 ;
}

