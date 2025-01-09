package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_importdata extends GXProcedure
{
   public wwp_importdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_importdata.class ), "" );
   }

   public wwp_importdata( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              String aP1 ,
                              String aP2 ,
                              String aP3 ,
                              GXBaseCollection<com.genexus.SdtMessages_Message>[] aP4 )
   {
      wwp_importdata.this.aP5 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        GXBaseCollection<com.genexus.SdtMessages_Message>[] aP4 ,
                        boolean[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             GXBaseCollection<com.genexus.SdtMessages_Message>[] aP4 ,
                             boolean[] aP5 )
   {
      wwp_importdata.this.AV12SelctionName = aP0;
      wwp_importdata.this.AV9ImportType = aP1;
      wwp_importdata.this.AV8FilePath = aP2;
      wwp_importdata.this.AV14ExtraParmsJson = aP3;
      wwp_importdata.this.aP4 = aP4;
      wwp_importdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "&SelctionName ", "")+AV12SelctionName) ;
      if ( GXutil.strcmp(AV12SelctionName, "importacion_legajoWW") == 0 )
      {
         if ( GXutil.strcmp(AV9ImportType, "Excel") == 0 )
         {
            GXv_objcol_SdtMessages_Message1[0] = AV11Messages ;
            GXv_boolean2[0] = AV10IsOk ;
            new web.importacion_legajowwimportexcel(remoteHandle, context).execute( AV8FilePath, AV14ExtraParmsJson, GXv_objcol_SdtMessages_Message1, GXv_boolean2) ;
            AV11Messages = GXv_objcol_SdtMessages_Message1[0] ;
            wwp_importdata.this.AV10IsOk = GXv_boolean2[0] ;
         }
      }
      else if ( GXutil.strcmp(AV12SelctionName, "ImportLSD") == 0 )
      {
         if ( GXutil.strcmp(AV9ImportType, "Excel") == 0 )
         {
            GXv_objcol_SdtMessages_Message1[0] = AV11Messages ;
            GXv_boolean2[0] = AV10IsOk ;
            new web.importlsdimportexcel(remoteHandle, context).execute( AV8FilePath, AV14ExtraParmsJson, GXv_objcol_SdtMessages_Message1, GXv_boolean2) ;
            AV11Messages = GXv_objcol_SdtMessages_Message1[0] ;
            wwp_importdata.this.AV10IsOk = GXv_boolean2[0] ;
         }
      }
      else if ( GXutil.strcmp(AV12SelctionName, "ImportLSD2") == 0 )
      {
         if ( GXutil.strcmp(AV9ImportType, "Excel") == 0 )
         {
            GXv_objcol_SdtMessages_Message1[0] = AV11Messages ;
            GXv_boolean2[0] = AV10IsOk ;
            new web.importlsd2importexcel(remoteHandle, context).execute( AV8FilePath, AV14ExtraParmsJson, GXv_objcol_SdtMessages_Message1, GXv_boolean2) ;
            AV11Messages = GXv_objcol_SdtMessages_Message1[0] ;
            wwp_importdata.this.AV10IsOk = GXv_boolean2[0] ;
         }
      }
      else if ( GXutil.strcmp(AV12SelctionName, "AgendaNovedadesWW") == 0 )
      {
         if ( GXutil.strcmp(AV9ImportType, "Excel") == 0 )
         {
            GXv_objcol_SdtMessages_Message1[0] = AV11Messages ;
            GXv_boolean2[0] = AV10IsOk ;
            new web.agendanovedadeswwimportexcel(remoteHandle, context).execute( AV8FilePath, AV14ExtraParmsJson, GXv_objcol_SdtMessages_Message1, GXv_boolean2) ;
            AV11Messages = GXv_objcol_SdtMessages_Message1[0] ;
            wwp_importdata.this.AV10IsOk = GXv_boolean2[0] ;
         }
      }
      else if ( GXutil.strcmp(AV12SelctionName, "NovedadesWW") == 0 )
      {
         if ( GXutil.strcmp(AV9ImportType, "Excel") == 0 )
         {
            GXv_objcol_SdtMessages_Message1[0] = AV11Messages ;
            GXv_boolean2[0] = AV10IsOk ;
            new web.novedadeswwimportexcel(remoteHandle, context).execute( AV8FilePath, AV14ExtraParmsJson, GXv_objcol_SdtMessages_Message1, GXv_boolean2) ;
            AV11Messages = GXv_objcol_SdtMessages_Message1[0] ;
            wwp_importdata.this.AV10IsOk = GXv_boolean2[0] ;
         }
      }
      else if ( GXutil.strcmp(AV12SelctionName, "ImportCC") == 0 )
      {
         if ( GXutil.strcmp(AV9ImportType, "Excel") == 0 )
         {
            GXv_objcol_SdtMessages_Message1[0] = AV11Messages ;
            GXv_boolean2[0] = AV10IsOk ;
            new web.importccimportexcel(remoteHandle, context).execute( AV8FilePath, AV14ExtraParmsJson, GXv_objcol_SdtMessages_Message1, GXv_boolean2) ;
            AV11Messages = GXv_objcol_SdtMessages_Message1[0] ;
            wwp_importdata.this.AV10IsOk = GXv_boolean2[0] ;
         }
      }
      else
      {
         GXv_objcol_SdtMessages_Message1[0] = AV11Messages ;
         new web.wwpbaseobjects.wwp_addmessage(remoteHandle, context).execute( "WWP_Import_UnkownObject", (byte)(1), GXutil.format( httpContext.getMessage( "Unknown list object: %1.", ""), AV12SelctionName, "", "", "", "", "", "", "", ""), GXv_objcol_SdtMessages_Message1) ;
         AV11Messages = GXv_objcol_SdtMessages_Message1[0] ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = wwp_importdata.this.AV11Messages;
      this.aP5[0] = wwp_importdata.this.AV10IsOk;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      AV17Pgmname = "" ;
      GXv_boolean2 = new boolean[1] ;
      GXv_objcol_SdtMessages_Message1 = new GXBaseCollection[1] ;
      AV17Pgmname = "WWPBaseObjects.WWP_ImportData" ;
      /* GeneXus formulas. */
      AV17Pgmname = "WWPBaseObjects.WWP_ImportData" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV17Pgmname ;
   private boolean AV10IsOk ;
   private boolean GXv_boolean2[] ;
   private String AV12SelctionName ;
   private String AV9ImportType ;
   private String AV8FilePath ;
   private String AV14ExtraParmsJson ;
   private boolean[] aP5 ;
   private GXBaseCollection<com.genexus.SdtMessages_Message>[] aP4 ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV11Messages ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> GXv_objcol_SdtMessages_Message1[] ;
}

