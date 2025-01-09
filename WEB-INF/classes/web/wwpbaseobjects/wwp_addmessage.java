package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_addmessage extends GXProcedure
{
   public wwp_addmessage( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_addmessage.class ), "" );
   }

   public wwp_addmessage( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.genexus.SdtMessages_Message> executeUdp( String aP0 ,
                                                                        byte aP1 ,
                                                                        String aP2 )
   {
      wwp_addmessage.this.aP3 = new GXBaseCollection[] {new GXBaseCollection<com.genexus.SdtMessages_Message>()};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( String aP0 ,
                        byte aP1 ,
                        String aP2 ,
                        GXBaseCollection<com.genexus.SdtMessages_Message>[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( String aP0 ,
                             byte aP1 ,
                             String aP2 ,
                             GXBaseCollection<com.genexus.SdtMessages_Message>[] aP3 )
   {
      wwp_addmessage.this.AV12MsgId = aP0;
      wwp_addmessage.this.AV13MsgType = aP1;
      wwp_addmessage.this.AV14MsgDsc = aP2;
      wwp_addmessage.this.AV15Messages = aP3[0];
      this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8Message = (com.genexus.SdtMessages_Message)new com.genexus.SdtMessages_Message(remoteHandle, context);
      AV8Message.setgxTv_SdtMessages_Message_Id( AV12MsgId );
      AV8Message.setgxTv_SdtMessages_Message_Type( AV13MsgType );
      AV8Message.setgxTv_SdtMessages_Message_Description( AV14MsgDsc );
      AV15Messages.add(AV8Message, 0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = wwp_addmessage.this.AV15Messages;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8Message = new com.genexus.SdtMessages_Message(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV13MsgType ;
   private short Gx_err ;
   private String AV12MsgId ;
   private String AV14MsgDsc ;
   private GXBaseCollection<com.genexus.SdtMessages_Message>[] aP3 ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV15Messages ;
   private com.genexus.SdtMessages_Message AV8Message ;
}

