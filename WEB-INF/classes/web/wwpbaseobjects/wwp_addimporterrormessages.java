package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_addimporterrormessages extends GXProcedure
{
   public wwp_addimporterrormessages( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_addimporterrormessages.class ), "" );
   }

   public wwp_addimporterrormessages( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( GXBaseCollection<com.genexus.SdtMessages_Message>[] aP0 ,
                        String aP1 ,
                        GXBaseCollection<com.genexus.SdtMessages_Message> aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( GXBaseCollection<com.genexus.SdtMessages_Message>[] aP0 ,
                             String aP1 ,
                             GXBaseCollection<com.genexus.SdtMessages_Message> aP2 )
   {
      wwp_addimporterrormessages.this.AV11Messages = aP0[0];
      this.aP0 = aP0;
      wwp_addimporterrormessages.this.AV9LineId = aP1;
      wwp_addimporterrormessages.this.AV8ErrorsToAdd = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "1 &LineId ", "")+GXutil.trim( AV9LineId)) ;
      if ( ! (GXutil.strcmp("", AV9LineId)==0) )
      {
         GXv_objcol_SdtMessages_Message1[0] = AV11Messages ;
         new web.wwpbaseobjects.wwp_addmessage(remoteHandle, context).execute( "WWP_LineId", (byte)(2), GXutil.format( httpContext.getMessage( "File line: %1", ""), AV9LineId, "", "", "", "", "", "", "", ""), GXv_objcol_SdtMessages_Message1) ;
         AV11Messages = GXv_objcol_SdtMessages_Message1[0] ;
      }
      AV15GXV1 = 1 ;
      while ( AV15GXV1 <= AV8ErrorsToAdd.size() )
      {
         AV10Message = (com.genexus.SdtMessages_Message)((com.genexus.SdtMessages_Message)AV8ErrorsToAdd.elementAt(-1+AV15GXV1));
         if ( AV10Message.getgxTv_SdtMessages_Message_Type() == 1 )
         {
            AV11Messages.add(AV10Message, 0);
            new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "error ", "")+AV10Message.getgxTv_SdtMessages_Message_Description()) ;
         }
         AV15GXV1 = (int)(AV15GXV1+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = wwp_addimporterrormessages.this.AV11Messages;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14Pgmname = "" ;
      GXv_objcol_SdtMessages_Message1 = new GXBaseCollection[1] ;
      AV10Message = new com.genexus.SdtMessages_Message(remoteHandle, context);
      AV14Pgmname = "WWPBaseObjects.WWP_AddImportErrorMessages" ;
      /* GeneXus formulas. */
      AV14Pgmname = "WWPBaseObjects.WWP_AddImportErrorMessages" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV15GXV1 ;
   private String AV14Pgmname ;
   private String AV9LineId ;
   private GXBaseCollection<com.genexus.SdtMessages_Message>[] aP0 ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV11Messages ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV8ErrorsToAdd ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> GXv_objcol_SdtMessages_Message1[] ;
   private com.genexus.SdtMessages_Message AV10Message ;
}

