package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_addimporterrormessage extends GXProcedure
{
   public wwp_addimporterrormessage( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_addimporterrormessage.class ), "" );
   }

   public wwp_addimporterrormessage( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( GXBaseCollection<com.genexus.SdtMessages_Message>[] aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( GXBaseCollection<com.genexus.SdtMessages_Message>[] aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 )
   {
      wwp_addimporterrormessage.this.AV11Messages = aP0[0];
      this.aP0 = aP0;
      wwp_addimporterrormessage.this.AV10LineId = aP1;
      wwp_addimporterrormessage.this.AV9ErrorToAddId = aP2;
      wwp_addimporterrormessage.this.AV8ErrorToAddDsc = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, "1") ;
      if ( ! (GXutil.strcmp("", AV10LineId)==0) )
      {
         GXv_objcol_SdtMessages_Message1[0] = AV11Messages ;
         new web.wwpbaseobjects.wwp_addmessage(remoteHandle, context).execute( "WWP_LineId", (byte)(2), GXutil.format( httpContext.getMessage( "File line: %1", ""), AV10LineId, "", "", "", "", "", "", "", ""), GXv_objcol_SdtMessages_Message1) ;
         AV11Messages = GXv_objcol_SdtMessages_Message1[0] ;
      }
      GXv_objcol_SdtMessages_Message1[0] = AV11Messages ;
      new web.wwpbaseobjects.wwp_addmessage(remoteHandle, context).execute( AV9ErrorToAddId, (byte)(1), AV8ErrorToAddDsc, GXv_objcol_SdtMessages_Message1) ;
      AV11Messages = GXv_objcol_SdtMessages_Message1[0] ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = wwp_addimporterrormessage.this.AV11Messages;
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
      AV14Pgmname = "WWPBaseObjects.WWP_AddImportErrorMessage" ;
      /* GeneXus formulas. */
      AV14Pgmname = "WWPBaseObjects.WWP_AddImportErrorMessage" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV14Pgmname ;
   private String AV10LineId ;
   private String AV9ErrorToAddId ;
   private String AV8ErrorToAddDsc ;
   private GXBaseCollection<com.genexus.SdtMessages_Message>[] aP0 ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV11Messages ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> GXv_objcol_SdtMessages_Message1[] ;
}

