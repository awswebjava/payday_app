package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class soap_locationwwexport extends GXProcedure
{
   public soap_locationwwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( soap_locationwwexport.class ), "" );
   }

   public soap_locationwwexport( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      soap_locationwwexport.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String[] aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String[] aP0 ,
                             String[] aP1 )
   {
      soap_locationwwexport.this.aP0 = aP0;
      soap_locationwwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWsoap_location", GXv_boolean2) ;
      soap_locationwwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV67Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         /* Execute user subroutine: 'OPENDOCUMENT' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV14CellRow = 1 ;
         AV15FirstColumn = 1 ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S201 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'WRITEFILTERS' */
         S131 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'WRITECOLUMNTITLES' */
         S141 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'WRITEDATA' */
         S161 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'CLOSEDOCUMENT' */
         S191 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'OPENDOCUMENT' Routine */
      returnInSub = false ;
      AV16Random = (int)(GXutil.random( )*10000) ;
      AV12Filename = "soap_locationWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
      AV11ExcelDocument.Open(AV12Filename);
      /* Execute user subroutine: 'CHECKSTATUS' */
      S121 ();
      if (returnInSub) return;
      AV11ExcelDocument.Clear();
   }

   public void S131( )
   {
      /* 'WRITEFILTERS' Routine */
      returnInSub = false ;
      if ( ! ( (0==AV63TFCliCod) && (0==AV64TFCliCod_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Cod", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         soap_locationwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV63TFCliCod );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         soap_locationwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV64TFCliCod_To );
      }
      if ( ! ( ( AV36TFSoapLocId_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Loc Id", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         soap_locationwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV59i = 1 ;
         AV68GXV1 = 1 ;
         while ( AV68GXV1 <= AV36TFSoapLocId_Sels.size() )
         {
            AV37TFSoapLocId_Sel = (String)AV36TFSoapLocId_Sels.elementAt(-1+AV68GXV1) ;
            if ( AV59i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV37TFSoapLocId_Sel, GXv_char7) ;
            soap_locationwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV59i = (long)(AV59i+1) ;
            AV68GXV1 = (int)(AV68GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV35TFSoapLocId)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Loc Id", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            soap_locationwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV35TFSoapLocId, GXv_char7) ;
            soap_locationwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV38TFSoapLocHab_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Loc Hab", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         soap_locationwwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV38TFSoapLocHab_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV38TFSoapLocHab_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( ( AV41TFSoapLocBaseUrl_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Base Url", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         soap_locationwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV59i = 1 ;
         AV69GXV2 = 1 ;
         while ( AV69GXV2 <= AV41TFSoapLocBaseUrl_Sels.size() )
         {
            AV42TFSoapLocBaseUrl_Sel = (String)AV41TFSoapLocBaseUrl_Sels.elementAt(-1+AV69GXV2) ;
            if ( AV59i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFSoapLocBaseUrl_Sel, GXv_char7) ;
            soap_locationwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV59i = (long)(AV59i+1) ;
            AV69GXV2 = (int)(AV69GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV40TFSoapLocBaseUrl)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Base Url", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            soap_locationwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFSoapLocBaseUrl, GXv_char7) ;
            soap_locationwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV43TFSoapLocCancelOnError) && (0==AV44TFSoapLocCancelOnError_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "On Error", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         soap_locationwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV43TFSoapLocCancelOnError );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         soap_locationwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV44TFSoapLocCancelOnError_To );
      }
      if ( ! ( ( AV47TFSoapLocHost_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Loc Host", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         soap_locationwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV59i = 1 ;
         AV70GXV3 = 1 ;
         while ( AV70GXV3 <= AV47TFSoapLocHost_Sels.size() )
         {
            AV48TFSoapLocHost_Sel = (String)AV47TFSoapLocHost_Sels.elementAt(-1+AV70GXV3) ;
            if ( AV59i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV48TFSoapLocHost_Sel, GXv_char7) ;
            soap_locationwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV59i = (long)(AV59i+1) ;
            AV70GXV3 = (int)(AV70GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV46TFSoapLocHost)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Loc Host", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            soap_locationwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV46TFSoapLocHost, GXv_char7) ;
            soap_locationwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV49TFSoapLocPort) && (0==AV50TFSoapLocPort_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Loc Port", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         soap_locationwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV49TFSoapLocPort );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         soap_locationwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV50TFSoapLocPort_To );
      }
      if ( ! ( ( AV53TFSoapLocResourceName_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Resource Name", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         soap_locationwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV59i = 1 ;
         AV71GXV4 = 1 ;
         while ( AV71GXV4 <= AV53TFSoapLocResourceName_Sels.size() )
         {
            AV54TFSoapLocResourceName_Sel = (String)AV53TFSoapLocResourceName_Sels.elementAt(-1+AV71GXV4) ;
            if ( AV59i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV54TFSoapLocResourceName_Sel, GXv_char7) ;
            soap_locationwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV59i = (long)(AV59i+1) ;
            AV71GXV4 = (int)(AV71GXV4+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV52TFSoapLocResourceName)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Resource Name", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            soap_locationwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV52TFSoapLocResourceName, GXv_char7) ;
            soap_locationwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV55TFSoapLocSecure) && (0==AV56TFSoapLocSecure_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Loc Secure", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         soap_locationwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV55TFSoapLocSecure );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         soap_locationwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV56TFSoapLocSecure_To );
      }
      if ( ! ( (0==AV57TFSoapLocTimeout) && (0==AV58TFSoapLocTimeout_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Loc Timeout", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         soap_locationwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV57TFSoapLocTimeout );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         soap_locationwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV58TFSoapLocTimeout_To );
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV31VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV19Session.getValue("soap_locationWWColumnsSelector"), "") != 0 )
      {
         AV26ColumnsSelectorXML = AV19Session.getValue("soap_locationWWColumnsSelector") ;
         AV23ColumnsSelector.fromxml(AV26ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV23ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV23ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV23ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV23ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV72GXV5 = 1 ;
      while ( AV72GXV5 <= AV23ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV25ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV23ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV72GXV5));
         if ( AV25ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV31VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV25ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV25ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV25ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV31VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV31VisibleColumnCount), 1, 1).setColor( 11 );
            AV31VisibleColumnCount = (long)(AV31VisibleColumnCount+1) ;
         }
         AV72GXV5 = (int)(AV72GXV5+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV74Soap_locationwwds_1_tfclicod = AV63TFCliCod ;
      AV75Soap_locationwwds_2_tfclicod_to = AV64TFCliCod_To ;
      AV76Soap_locationwwds_3_tfsoaplocid = AV35TFSoapLocId ;
      AV77Soap_locationwwds_4_tfsoaplocid_sels = AV36TFSoapLocId_Sels ;
      AV78Soap_locationwwds_5_tfsoaplochab_sel = AV38TFSoapLocHab_Sel ;
      AV79Soap_locationwwds_6_tfsoaplocbaseurl = AV40TFSoapLocBaseUrl ;
      AV80Soap_locationwwds_7_tfsoaplocbaseurl_sels = AV41TFSoapLocBaseUrl_Sels ;
      AV81Soap_locationwwds_8_tfsoaploccancelonerror = AV43TFSoapLocCancelOnError ;
      AV82Soap_locationwwds_9_tfsoaploccancelonerror_to = AV44TFSoapLocCancelOnError_To ;
      AV83Soap_locationwwds_10_tfsoaplochost = AV46TFSoapLocHost ;
      AV84Soap_locationwwds_11_tfsoaplochost_sels = AV47TFSoapLocHost_Sels ;
      AV85Soap_locationwwds_12_tfsoaplocport = AV49TFSoapLocPort ;
      AV86Soap_locationwwds_13_tfsoaplocport_to = AV50TFSoapLocPort_To ;
      AV87Soap_locationwwds_14_tfsoaplocresourcename = AV52TFSoapLocResourceName ;
      AV88Soap_locationwwds_15_tfsoaplocresourcename_sels = AV53TFSoapLocResourceName_Sels ;
      AV89Soap_locationwwds_16_tfsoaplocsecure = AV55TFSoapLocSecure ;
      AV90Soap_locationwwds_17_tfsoaplocsecure_to = AV56TFSoapLocSecure_To ;
      AV91Soap_locationwwds_18_tfsoaploctimeout = AV57TFSoapLocTimeout ;
      AV92Soap_locationwwds_19_tfsoaploctimeout_to = AV58TFSoapLocTimeout_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A2162SoapLocId ,
                                           AV77Soap_locationwwds_4_tfsoaplocid_sels ,
                                           A2164SoapLocBaseUrl ,
                                           AV80Soap_locationwwds_7_tfsoaplocbaseurl_sels ,
                                           A2166SoapLocHost ,
                                           AV84Soap_locationwwds_11_tfsoaplochost_sels ,
                                           A2168SoapLocResourceName ,
                                           AV88Soap_locationwwds_15_tfsoaplocresourcename_sels ,
                                           Integer.valueOf(AV74Soap_locationwwds_1_tfclicod) ,
                                           Integer.valueOf(AV75Soap_locationwwds_2_tfclicod_to) ,
                                           Integer.valueOf(AV77Soap_locationwwds_4_tfsoaplocid_sels.size()) ,
                                           AV76Soap_locationwwds_3_tfsoaplocid ,
                                           Byte.valueOf(AV78Soap_locationwwds_5_tfsoaplochab_sel) ,
                                           Integer.valueOf(AV80Soap_locationwwds_7_tfsoaplocbaseurl_sels.size()) ,
                                           AV79Soap_locationwwds_6_tfsoaplocbaseurl ,
                                           Byte.valueOf(AV81Soap_locationwwds_8_tfsoaploccancelonerror) ,
                                           Byte.valueOf(AV82Soap_locationwwds_9_tfsoaploccancelonerror_to) ,
                                           Integer.valueOf(AV84Soap_locationwwds_11_tfsoaplochost_sels.size()) ,
                                           AV83Soap_locationwwds_10_tfsoaplochost ,
                                           Integer.valueOf(AV85Soap_locationwwds_12_tfsoaplocport) ,
                                           Integer.valueOf(AV86Soap_locationwwds_13_tfsoaplocport_to) ,
                                           Integer.valueOf(AV88Soap_locationwwds_15_tfsoaplocresourcename_sels.size()) ,
                                           AV87Soap_locationwwds_14_tfsoaplocresourcename ,
                                           Byte.valueOf(AV89Soap_locationwwds_16_tfsoaplocsecure) ,
                                           Byte.valueOf(AV90Soap_locationwwds_17_tfsoaplocsecure_to) ,
                                           Short.valueOf(AV91Soap_locationwwds_18_tfsoaploctimeout) ,
                                           Short.valueOf(AV92Soap_locationwwds_19_tfsoaploctimeout_to) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Boolean.valueOf(A2163SoapLocHab) ,
                                           Byte.valueOf(A2165SoapLocCancelOnError) ,
                                           Integer.valueOf(A2167SoapLocPort) ,
                                           Byte.valueOf(A2169SoapLocSecure) ,
                                           Short.valueOf(A2170SoapLocTimeout) ,
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) ,
                                           Integer.valueOf(AV60CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.BOOLEAN, TypeConstants.INT
                                           }
      });
      lV76Soap_locationwwds_3_tfsoaplocid = GXutil.padr( GXutil.rtrim( AV76Soap_locationwwds_3_tfsoaplocid), 40, "%") ;
      lV79Soap_locationwwds_6_tfsoaplocbaseurl = GXutil.concat( GXutil.rtrim( AV79Soap_locationwwds_6_tfsoaplocbaseurl), "%", "") ;
      lV83Soap_locationwwds_10_tfsoaplochost = GXutil.concat( GXutil.rtrim( AV83Soap_locationwwds_10_tfsoaplochost), "%", "") ;
      lV87Soap_locationwwds_14_tfsoaplocresourcename = GXutil.concat( GXutil.rtrim( AV87Soap_locationwwds_14_tfsoaplocresourcename), "%", "") ;
      /* Using cursor P02BD2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV60CliCod), Integer.valueOf(AV74Soap_locationwwds_1_tfclicod), Integer.valueOf(AV75Soap_locationwwds_2_tfclicod_to), lV76Soap_locationwwds_3_tfsoaplocid, lV79Soap_locationwwds_6_tfsoaplocbaseurl, Byte.valueOf(AV81Soap_locationwwds_8_tfsoaploccancelonerror), Byte.valueOf(AV82Soap_locationwwds_9_tfsoaploccancelonerror_to), lV83Soap_locationwwds_10_tfsoaplochost, Integer.valueOf(AV85Soap_locationwwds_12_tfsoaplocport), Integer.valueOf(AV86Soap_locationwwds_13_tfsoaplocport_to), lV87Soap_locationwwds_14_tfsoaplocresourcename, Byte.valueOf(AV89Soap_locationwwds_16_tfsoaplocsecure), Byte.valueOf(AV90Soap_locationwwds_17_tfsoaplocsecure_to), Short.valueOf(AV91Soap_locationwwds_18_tfsoaploctimeout), Short.valueOf(AV92Soap_locationwwds_19_tfsoaploctimeout_to)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2170SoapLocTimeout = P02BD2_A2170SoapLocTimeout[0] ;
         A2169SoapLocSecure = P02BD2_A2169SoapLocSecure[0] ;
         A2168SoapLocResourceName = P02BD2_A2168SoapLocResourceName[0] ;
         A2167SoapLocPort = P02BD2_A2167SoapLocPort[0] ;
         A2166SoapLocHost = P02BD2_A2166SoapLocHost[0] ;
         A2165SoapLocCancelOnError = P02BD2_A2165SoapLocCancelOnError[0] ;
         A2164SoapLocBaseUrl = P02BD2_A2164SoapLocBaseUrl[0] ;
         A2163SoapLocHab = P02BD2_A2163SoapLocHab[0] ;
         A2162SoapLocId = P02BD2_A2162SoapLocId[0] ;
         A3CliCod = P02BD2_A3CliCod[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV31VisibleColumnCount = 0 ;
         AV93GXV6 = 1 ;
         while ( AV93GXV6 <= AV23ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV25ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV23ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV93GXV6));
            if ( AV25ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV25ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliCod") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV31VisibleColumnCount), 1, 1).setNumber( A3CliCod );
               }
               else if ( GXutil.strcmp(AV25ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SoapLocId") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A2162SoapLocId, GXv_char7) ;
                  soap_locationwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV31VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV25ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SoapLocHab") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV31VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A2163SoapLocHab) );
               }
               else if ( GXutil.strcmp(AV25ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SoapLocBaseUrl") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A2164SoapLocBaseUrl, GXv_char7) ;
                  soap_locationwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV31VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV25ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SoapLocCancelOnError") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV31VisibleColumnCount), 1, 1).setNumber( A2165SoapLocCancelOnError );
               }
               else if ( GXutil.strcmp(AV25ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SoapLocHost") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A2166SoapLocHost, GXv_char7) ;
                  soap_locationwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV31VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV25ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SoapLocPort") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV31VisibleColumnCount), 1, 1).setNumber( A2167SoapLocPort );
               }
               else if ( GXutil.strcmp(AV25ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SoapLocResourceName") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A2168SoapLocResourceName, GXv_char7) ;
                  soap_locationwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV31VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV25ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SoapLocSecure") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV31VisibleColumnCount), 1, 1).setNumber( A2169SoapLocSecure );
               }
               else if ( GXutil.strcmp(AV25ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SoapLocTimeout") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV31VisibleColumnCount), 1, 1).setNumber( A2170SoapLocTimeout );
               }
               AV31VisibleColumnCount = (long)(AV31VisibleColumnCount+1) ;
            }
            AV93GXV6 = (int)(AV93GXV6+1) ;
         }
         /* Execute user subroutine: 'AFTERWRITELINE' */
         S182 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void S191( )
   {
      /* 'CLOSEDOCUMENT' Routine */
      returnInSub = false ;
      AV11ExcelDocument.Save();
      /* Execute user subroutine: 'CHECKSTATUS' */
      S121 ();
      if (returnInSub) return;
      AV11ExcelDocument.Close();
   }

   public void S121( )
   {
      /* 'CHECKSTATUS' Routine */
      returnInSub = false ;
      if ( AV11ExcelDocument.getErrCode() != 0 )
      {
         AV12Filename = "" ;
         AV13ErrorMessage = AV11ExcelDocument.getErrDescription() ;
         AV11ExcelDocument.Close();
         returnInSub = true;
         if (true) return;
      }
   }

   public void S151( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV23ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV23ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "CliCod", "", "Cod", true, "") ;
      AV23ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV23ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SoapLocId", "", "Loc Id", true, "") ;
      AV23ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV23ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SoapLocHab", "", "Loc Hab", true, "") ;
      AV23ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV23ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SoapLocBaseUrl", "", "Base Url", true, "") ;
      AV23ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV23ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SoapLocCancelOnError", "", "On Error", true, "") ;
      AV23ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV23ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SoapLocHost", "", "Loc Host", true, "") ;
      AV23ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV23ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SoapLocPort", "", "Loc Port", true, "") ;
      AV23ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV23ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SoapLocResourceName", "", "Resource Name", true, "") ;
      AV23ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV23ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SoapLocSecure", "", "Loc Secure", true, "") ;
      AV23ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV23ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SoapLocTimeout", "", "Loc Timeout", true, "") ;
      AV23ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV23ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&VerSVG", "", "", true, "") ;
      AV23ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV23ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&ModificarSVG", "", "", true, "") ;
      AV23ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV23ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&EliminarSVG", "", "", true, "") ;
      AV23ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV27UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "soap_locationWWColumnsSelector", GXv_char7) ;
      soap_locationwwexport.this.GXt_char6 = GXv_char7[0] ;
      AV27UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV27UserCustomValue)==0) ) )
      {
         AV24ColumnsSelectorAux.fromxml(AV27UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV23ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, GXv_SdtWWPColumnsSelector9) ;
         AV24ColumnsSelectorAux = GXv_SdtWWPColumnsSelector8[0] ;
         AV23ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV19Session.getValue("soap_locationWWGridState"), "") == 0 )
      {
         AV21GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "soap_locationWWGridState"), null, null);
      }
      else
      {
         AV21GridState.fromxml(AV19Session.getValue("soap_locationWWGridState"), null, null);
      }
      AV17OrderedBy = AV21GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV18OrderedDsc = AV21GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV94GXV7 = 1 ;
      while ( AV94GXV7 <= AV21GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV22GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV21GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV94GXV7));
         if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICOD") == 0 )
         {
            AV63TFCliCod = (int)(GXutil.lval( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV64TFCliCod_To = (int)(GXutil.lval( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCID") == 0 )
         {
            AV35TFSoapLocId = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCID_SEL") == 0 )
         {
            AV34TFSoapLocId_SelsJson = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV36TFSoapLocId_Sels.fromJSonString(AV34TFSoapLocId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCHAB_SEL") == 0 )
         {
            AV38TFSoapLocHab_Sel = (byte)(GXutil.lval( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCBASEURL") == 0 )
         {
            AV40TFSoapLocBaseUrl = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCBASEURL_SEL") == 0 )
         {
            AV39TFSoapLocBaseUrl_SelsJson = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV41TFSoapLocBaseUrl_Sels.fromJSonString(AV39TFSoapLocBaseUrl_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCCANCELONERROR") == 0 )
         {
            AV43TFSoapLocCancelOnError = (byte)(GXutil.lval( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV44TFSoapLocCancelOnError_To = (byte)(GXutil.lval( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCHOST") == 0 )
         {
            AV46TFSoapLocHost = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCHOST_SEL") == 0 )
         {
            AV45TFSoapLocHost_SelsJson = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV47TFSoapLocHost_Sels.fromJSonString(AV45TFSoapLocHost_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCPORT") == 0 )
         {
            AV49TFSoapLocPort = (int)(GXutil.lval( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV50TFSoapLocPort_To = (int)(GXutil.lval( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCRESOURCENAME") == 0 )
         {
            AV52TFSoapLocResourceName = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCRESOURCENAME_SEL") == 0 )
         {
            AV51TFSoapLocResourceName_SelsJson = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV53TFSoapLocResourceName_Sels.fromJSonString(AV51TFSoapLocResourceName_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCSECURE") == 0 )
         {
            AV55TFSoapLocSecure = (byte)(GXutil.lval( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV56TFSoapLocSecure_To = (byte)(GXutil.lval( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCTIMEOUT") == 0 )
         {
            AV57TFSoapLocTimeout = (short)(GXutil.lval( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV58TFSoapLocTimeout_To = (short)(GXutil.lval( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV62MenuOpcCod = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV94GXV7 = (int)(AV94GXV7+1) ;
      }
   }

   public void S172( )
   {
      /* 'BEFOREWRITELINE' Routine */
      returnInSub = false ;
   }

   public void S182( )
   {
      /* 'AFTERWRITELINE' Routine */
      returnInSub = false ;
   }

   protected void cleanup( )
   {
      this.aP0[0] = soap_locationwwexport.this.AV12Filename;
      this.aP1[0] = soap_locationwwexport.this.AV13ErrorMessage;
      CloseOpenCursors();
      AV11ExcelDocument.cleanup();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12Filename = "" ;
      AV13ErrorMessage = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV67Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV36TFSoapLocId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV37TFSoapLocId_Sel = "" ;
      AV35TFSoapLocId = "" ;
      AV41TFSoapLocBaseUrl_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42TFSoapLocBaseUrl_Sel = "" ;
      AV40TFSoapLocBaseUrl = "" ;
      AV47TFSoapLocHost_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV48TFSoapLocHost_Sel = "" ;
      AV46TFSoapLocHost = "" ;
      AV53TFSoapLocResourceName_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV54TFSoapLocResourceName_Sel = "" ;
      AV52TFSoapLocResourceName = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV19Session = httpContext.getWebSession();
      AV26ColumnsSelectorXML = "" ;
      AV23ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV25ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A2162SoapLocId = "" ;
      A2164SoapLocBaseUrl = "" ;
      A2166SoapLocHost = "" ;
      A2168SoapLocResourceName = "" ;
      AV76Soap_locationwwds_3_tfsoaplocid = "" ;
      AV77Soap_locationwwds_4_tfsoaplocid_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV79Soap_locationwwds_6_tfsoaplocbaseurl = "" ;
      AV80Soap_locationwwds_7_tfsoaplocbaseurl_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV83Soap_locationwwds_10_tfsoaplochost = "" ;
      AV84Soap_locationwwds_11_tfsoaplochost_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV87Soap_locationwwds_14_tfsoaplocresourcename = "" ;
      AV88Soap_locationwwds_15_tfsoaplocresourcename_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV76Soap_locationwwds_3_tfsoaplocid = "" ;
      lV79Soap_locationwwds_6_tfsoaplocbaseurl = "" ;
      lV83Soap_locationwwds_10_tfsoaplochost = "" ;
      lV87Soap_locationwwds_14_tfsoaplocresourcename = "" ;
      P02BD2_A2170SoapLocTimeout = new short[1] ;
      P02BD2_A2169SoapLocSecure = new byte[1] ;
      P02BD2_A2168SoapLocResourceName = new String[] {""} ;
      P02BD2_A2167SoapLocPort = new int[1] ;
      P02BD2_A2166SoapLocHost = new String[] {""} ;
      P02BD2_A2165SoapLocCancelOnError = new byte[1] ;
      P02BD2_A2164SoapLocBaseUrl = new String[] {""} ;
      P02BD2_A2163SoapLocHab = new boolean[] {false} ;
      P02BD2_A2162SoapLocId = new String[] {""} ;
      P02BD2_A3CliCod = new int[1] ;
      AV27UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV24ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV21GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV22GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV34TFSoapLocId_SelsJson = "" ;
      AV39TFSoapLocBaseUrl_SelsJson = "" ;
      AV45TFSoapLocHost_SelsJson = "" ;
      AV51TFSoapLocResourceName_SelsJson = "" ;
      AV62MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.soap_locationwwexport__default(),
         new Object[] {
             new Object[] {
            P02BD2_A2170SoapLocTimeout, P02BD2_A2169SoapLocSecure, P02BD2_A2168SoapLocResourceName, P02BD2_A2167SoapLocPort, P02BD2_A2166SoapLocHost, P02BD2_A2165SoapLocCancelOnError, P02BD2_A2164SoapLocBaseUrl, P02BD2_A2163SoapLocHab, P02BD2_A2162SoapLocId, P02BD2_A3CliCod
            }
         }
      );
      AV67Pgmname = "soap_locationWWExport" ;
      /* GeneXus formulas. */
      AV67Pgmname = "soap_locationWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV38TFSoapLocHab_Sel ;
   private byte AV43TFSoapLocCancelOnError ;
   private byte AV44TFSoapLocCancelOnError_To ;
   private byte AV55TFSoapLocSecure ;
   private byte AV56TFSoapLocSecure_To ;
   private byte A2165SoapLocCancelOnError ;
   private byte A2169SoapLocSecure ;
   private byte AV78Soap_locationwwds_5_tfsoaplochab_sel ;
   private byte AV81Soap_locationwwds_8_tfsoaploccancelonerror ;
   private byte AV82Soap_locationwwds_9_tfsoaploccancelonerror_to ;
   private byte AV89Soap_locationwwds_16_tfsoaplocsecure ;
   private byte AV90Soap_locationwwds_17_tfsoaplocsecure_to ;
   private short AV57TFSoapLocTimeout ;
   private short AV58TFSoapLocTimeout_To ;
   private short GXv_int5[] ;
   private short A2170SoapLocTimeout ;
   private short AV91Soap_locationwwds_18_tfsoaploctimeout ;
   private short AV92Soap_locationwwds_19_tfsoaploctimeout_to ;
   private short AV17OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV63TFCliCod ;
   private int AV64TFCliCod_To ;
   private int AV68GXV1 ;
   private int AV69GXV2 ;
   private int AV70GXV3 ;
   private int AV49TFSoapLocPort ;
   private int AV50TFSoapLocPort_To ;
   private int AV71GXV4 ;
   private int AV72GXV5 ;
   private int A3CliCod ;
   private int A2167SoapLocPort ;
   private int AV74Soap_locationwwds_1_tfclicod ;
   private int AV75Soap_locationwwds_2_tfclicod_to ;
   private int AV85Soap_locationwwds_12_tfsoaplocport ;
   private int AV86Soap_locationwwds_13_tfsoaplocport_to ;
   private int AV77Soap_locationwwds_4_tfsoaplocid_sels_size ;
   private int AV80Soap_locationwwds_7_tfsoaplocbaseurl_sels_size ;
   private int AV84Soap_locationwwds_11_tfsoaplochost_sels_size ;
   private int AV88Soap_locationwwds_15_tfsoaplocresourcename_sels_size ;
   private int AV60CliCod ;
   private int AV93GXV6 ;
   private int AV94GXV7 ;
   private long AV59i ;
   private long AV31VisibleColumnCount ;
   private String AV67Pgmname ;
   private String AV37TFSoapLocId_Sel ;
   private String AV35TFSoapLocId ;
   private String A2162SoapLocId ;
   private String AV76Soap_locationwwds_3_tfsoaplocid ;
   private String scmdbuf ;
   private String lV76Soap_locationwwds_3_tfsoaplocid ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean A2163SoapLocHab ;
   private boolean AV18OrderedDsc ;
   private String AV26ColumnsSelectorXML ;
   private String AV27UserCustomValue ;
   private String AV34TFSoapLocId_SelsJson ;
   private String AV39TFSoapLocBaseUrl_SelsJson ;
   private String AV45TFSoapLocHost_SelsJson ;
   private String AV51TFSoapLocResourceName_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV42TFSoapLocBaseUrl_Sel ;
   private String AV40TFSoapLocBaseUrl ;
   private String AV48TFSoapLocHost_Sel ;
   private String AV46TFSoapLocHost ;
   private String AV54TFSoapLocResourceName_Sel ;
   private String AV52TFSoapLocResourceName ;
   private String A2164SoapLocBaseUrl ;
   private String A2166SoapLocHost ;
   private String A2168SoapLocResourceName ;
   private String AV79Soap_locationwwds_6_tfsoaplocbaseurl ;
   private String AV83Soap_locationwwds_10_tfsoaplochost ;
   private String AV87Soap_locationwwds_14_tfsoaplocresourcename ;
   private String lV79Soap_locationwwds_6_tfsoaplocbaseurl ;
   private String lV83Soap_locationwwds_10_tfsoaplochost ;
   private String lV87Soap_locationwwds_14_tfsoaplocresourcename ;
   private String AV62MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV19Session ;
   private GXSimpleCollection<String> AV36TFSoapLocId_Sels ;
   private GXSimpleCollection<String> AV41TFSoapLocBaseUrl_Sels ;
   private GXSimpleCollection<String> AV47TFSoapLocHost_Sels ;
   private GXSimpleCollection<String> AV53TFSoapLocResourceName_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P02BD2_A2170SoapLocTimeout ;
   private byte[] P02BD2_A2169SoapLocSecure ;
   private String[] P02BD2_A2168SoapLocResourceName ;
   private int[] P02BD2_A2167SoapLocPort ;
   private String[] P02BD2_A2166SoapLocHost ;
   private byte[] P02BD2_A2165SoapLocCancelOnError ;
   private String[] P02BD2_A2164SoapLocBaseUrl ;
   private boolean[] P02BD2_A2163SoapLocHab ;
   private String[] P02BD2_A2162SoapLocId ;
   private int[] P02BD2_A3CliCod ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV77Soap_locationwwds_4_tfsoaplocid_sels ;
   private GXSimpleCollection<String> AV80Soap_locationwwds_7_tfsoaplocbaseurl_sels ;
   private GXSimpleCollection<String> AV84Soap_locationwwds_11_tfsoaplochost_sels ;
   private GXSimpleCollection<String> AV88Soap_locationwwds_15_tfsoaplocresourcename_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV21GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV22GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV23ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV24ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV25ColumnsSelector_Column ;
}

final  class soap_locationwwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02BD2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2162SoapLocId ,
                                          GXSimpleCollection<String> AV77Soap_locationwwds_4_tfsoaplocid_sels ,
                                          String A2164SoapLocBaseUrl ,
                                          GXSimpleCollection<String> AV80Soap_locationwwds_7_tfsoaplocbaseurl_sels ,
                                          String A2166SoapLocHost ,
                                          GXSimpleCollection<String> AV84Soap_locationwwds_11_tfsoaplochost_sels ,
                                          String A2168SoapLocResourceName ,
                                          GXSimpleCollection<String> AV88Soap_locationwwds_15_tfsoaplocresourcename_sels ,
                                          int AV74Soap_locationwwds_1_tfclicod ,
                                          int AV75Soap_locationwwds_2_tfclicod_to ,
                                          int AV77Soap_locationwwds_4_tfsoaplocid_sels_size ,
                                          String AV76Soap_locationwwds_3_tfsoaplocid ,
                                          byte AV78Soap_locationwwds_5_tfsoaplochab_sel ,
                                          int AV80Soap_locationwwds_7_tfsoaplocbaseurl_sels_size ,
                                          String AV79Soap_locationwwds_6_tfsoaplocbaseurl ,
                                          byte AV81Soap_locationwwds_8_tfsoaploccancelonerror ,
                                          byte AV82Soap_locationwwds_9_tfsoaploccancelonerror_to ,
                                          int AV84Soap_locationwwds_11_tfsoaplochost_sels_size ,
                                          String AV83Soap_locationwwds_10_tfsoaplochost ,
                                          int AV85Soap_locationwwds_12_tfsoaplocport ,
                                          int AV86Soap_locationwwds_13_tfsoaplocport_to ,
                                          int AV88Soap_locationwwds_15_tfsoaplocresourcename_sels_size ,
                                          String AV87Soap_locationwwds_14_tfsoaplocresourcename ,
                                          byte AV89Soap_locationwwds_16_tfsoaplocsecure ,
                                          byte AV90Soap_locationwwds_17_tfsoaplocsecure_to ,
                                          short AV91Soap_locationwwds_18_tfsoaploctimeout ,
                                          short AV92Soap_locationwwds_19_tfsoaploctimeout_to ,
                                          int A3CliCod ,
                                          boolean A2163SoapLocHab ,
                                          byte A2165SoapLocCancelOnError ,
                                          int A2167SoapLocPort ,
                                          byte A2169SoapLocSecure ,
                                          short A2170SoapLocTimeout ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc ,
                                          int AV60CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[15];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT SoapLocTimeout, SoapLocSecure, SoapLocResourceName, SoapLocPort, SoapLocHost, SoapLocCancelOnError, SoapLocBaseUrl, SoapLocHab, SoapLocId, CliCod FROM soap_location" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV74Soap_locationwwds_1_tfclicod) )
      {
         addWhere(sWhereString, "(CliCod >= ?)");
      }
      else
      {
         GXv_int10[1] = (byte)(1) ;
      }
      if ( ! (0==AV75Soap_locationwwds_2_tfclicod_to) )
      {
         addWhere(sWhereString, "(CliCod <= ?)");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( ( AV77Soap_locationwwds_4_tfsoaplocid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV76Soap_locationwwds_3_tfsoaplocid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SoapLocId) like LOWER(?))");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( AV77Soap_locationwwds_4_tfsoaplocid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV77Soap_locationwwds_4_tfsoaplocid_sels, "SoapLocId IN (", ")")+")");
      }
      if ( AV78Soap_locationwwds_5_tfsoaplochab_sel == 1 )
      {
         addWhere(sWhereString, "(SoapLocHab = TRUE)");
      }
      if ( AV78Soap_locationwwds_5_tfsoaplochab_sel == 2 )
      {
         addWhere(sWhereString, "(SoapLocHab = FALSE)");
      }
      if ( ( AV80Soap_locationwwds_7_tfsoaplocbaseurl_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV79Soap_locationwwds_6_tfsoaplocbaseurl)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SoapLocBaseUrl) like LOWER(?))");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( AV80Soap_locationwwds_7_tfsoaplocbaseurl_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV80Soap_locationwwds_7_tfsoaplocbaseurl_sels, "SoapLocBaseUrl IN (", ")")+")");
      }
      if ( ! (0==AV81Soap_locationwwds_8_tfsoaploccancelonerror) )
      {
         addWhere(sWhereString, "(SoapLocCancelOnError >= ?)");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( ! (0==AV82Soap_locationwwds_9_tfsoaploccancelonerror_to) )
      {
         addWhere(sWhereString, "(SoapLocCancelOnError <= ?)");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( ( AV84Soap_locationwwds_11_tfsoaplochost_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV83Soap_locationwwds_10_tfsoaplochost)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SoapLocHost) like LOWER(?))");
      }
      else
      {
         GXv_int10[7] = (byte)(1) ;
      }
      if ( AV84Soap_locationwwds_11_tfsoaplochost_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV84Soap_locationwwds_11_tfsoaplochost_sels, "SoapLocHost IN (", ")")+")");
      }
      if ( ! (0==AV85Soap_locationwwds_12_tfsoaplocport) )
      {
         addWhere(sWhereString, "(SoapLocPort >= ?)");
      }
      else
      {
         GXv_int10[8] = (byte)(1) ;
      }
      if ( ! (0==AV86Soap_locationwwds_13_tfsoaplocport_to) )
      {
         addWhere(sWhereString, "(SoapLocPort <= ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      if ( ( AV88Soap_locationwwds_15_tfsoaplocresourcename_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV87Soap_locationwwds_14_tfsoaplocresourcename)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SoapLocResourceName) like LOWER(?))");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( AV88Soap_locationwwds_15_tfsoaplocresourcename_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV88Soap_locationwwds_15_tfsoaplocresourcename_sels, "SoapLocResourceName IN (", ")")+")");
      }
      if ( ! (0==AV89Soap_locationwwds_16_tfsoaplocsecure) )
      {
         addWhere(sWhereString, "(SoapLocSecure >= ?)");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( ! (0==AV90Soap_locationwwds_17_tfsoaplocsecure_to) )
      {
         addWhere(sWhereString, "(SoapLocSecure <= ?)");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( ! (0==AV91Soap_locationwwds_18_tfsoaploctimeout) )
      {
         addWhere(sWhereString, "(SoapLocTimeout >= ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      if ( ! (0==AV92Soap_locationwwds_19_tfsoaploctimeout_to) )
      {
         addWhere(sWhereString, "(SoapLocTimeout <= ?)");
      }
      else
      {
         GXv_int10[14] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV17OrderedBy == 1 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY CliCod" ;
      }
      else if ( ( AV17OrderedBy == 1 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliCod DESC" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY SoapLocId" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SoapLocId DESC" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY SoapLocHab" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SoapLocHab DESC" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY SoapLocBaseUrl" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SoapLocBaseUrl DESC" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY SoapLocCancelOnError" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SoapLocCancelOnError DESC" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY SoapLocHost" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SoapLocHost DESC" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY SoapLocPort" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SoapLocPort DESC" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY SoapLocResourceName" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SoapLocResourceName DESC" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY SoapLocSecure" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SoapLocSecure DESC" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY SoapLocTimeout" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SoapLocTimeout DESC" ;
      }
      GXv_Object11[0] = scmdbuf ;
      GXv_Object11[1] = GXv_int10 ;
      return GXv_Object11 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P02BD2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).byteValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).byteValue() , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).byteValue() , ((Number) dynConstraints[24]).byteValue() , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).shortValue() , ((Number) dynConstraints[27]).intValue() , ((Boolean) dynConstraints[28]).booleanValue() , ((Number) dynConstraints[29]).byteValue() , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).byteValue() , ((Number) dynConstraints[32]).shortValue() , ((Number) dynConstraints[33]).shortValue() , ((Boolean) dynConstraints[34]).booleanValue() , ((Number) dynConstraints[35]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02BD2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 40);
               ((int[]) buf[9])[0] = rslt.getInt(10);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[16]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[17]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[18], 40);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 1000);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[20]).byteValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[21]).byteValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 40);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[23]).intValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[24]).intValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 80);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[26]).byteValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[27]).byteValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[28]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[29]).shortValue());
               }
               return;
      }
   }

}

