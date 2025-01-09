package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class secfunctionalitywwexport extends GXProcedure
{
   public secfunctionalitywwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secfunctionalitywwexport.class ), "" );
   }

   public secfunctionalitywwexport( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      secfunctionalitywwexport.this.aP1 = new String[] {""};
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
      secfunctionalitywwexport.this.aP0 = aP0;
      secfunctionalitywwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSecFunctionality", GXv_boolean2) ;
      secfunctionalitywwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV57Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV39WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV39WWPContext = GXv_SdtWWPContext3[0] ;
         /* Execute user subroutine: 'OPENDOCUMENT' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV13CellRow = 1 ;
         AV14FirstColumn = 1 ;
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
      AV15Random = (int)(GXutil.random( )*10000) ;
      AV11Filename = "SecFunctionalityWWExport-" + GXutil.trim( GXutil.str( AV15Random, 8, 0)) + ".xlsx" ;
      AV10ExcelDocument.Open(AV11Filename);
      /* Execute user subroutine: 'CHECKSTATUS' */
      S121 ();
      if (returnInSub) return;
      AV10ExcelDocument.Clear();
   }

   public void S131( )
   {
      /* 'WRITEFILTERS' Routine */
      returnInSub = false ;
      if ( ! ( ( AV48TFSecFunctionalityKey_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), httpContext.getMessage( "Key", "")) ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         secfunctionalitywwexport.this.AV13CellRow = GXv_int5[0] ;
         AV35i = 1 ;
         AV58GXV1 = 1 ;
         while ( AV58GXV1 <= AV48TFSecFunctionalityKey_Sels.size() )
         {
            AV22TFSecFunctionalityKey_Sel = (String)AV48TFSecFunctionalityKey_Sels.elementAt(-1+AV58GXV1) ;
            if ( AV35i == 1 )
            {
               AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV22TFSecFunctionalityKey_Sel, GXv_char7) ;
            secfunctionalitywwexport.this.GXt_char6 = GXv_char7[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV35i = (long)(AV35i+1) ;
            AV58GXV1 = (int)(AV58GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV21TFSecFunctionalityKey)==0) ) )
         {
            GXv_exceldoc4[0] = AV10ExcelDocument ;
            GXv_int5[0] = (short)(AV13CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), httpContext.getMessage( "Key", "")) ;
            AV10ExcelDocument = GXv_exceldoc4[0] ;
            secfunctionalitywwexport.this.AV13CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV21TFSecFunctionalityKey, GXv_char7) ;
            secfunctionalitywwexport.this.GXt_char6 = GXv_char7[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV50TFSecFunctionalityDescription_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), httpContext.getMessage( "Description", "")) ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         secfunctionalitywwexport.this.AV13CellRow = GXv_int5[0] ;
         AV35i = 1 ;
         AV59GXV2 = 1 ;
         while ( AV59GXV2 <= AV50TFSecFunctionalityDescription_Sels.size() )
         {
            AV24TFSecFunctionalityDescription_Sel = (String)AV50TFSecFunctionalityDescription_Sels.elementAt(-1+AV59GXV2) ;
            if ( AV35i == 1 )
            {
               AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV24TFSecFunctionalityDescription_Sel, GXv_char7) ;
            secfunctionalitywwexport.this.GXt_char6 = GXv_char7[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV35i = (long)(AV35i+1) ;
            AV59GXV2 = (int)(AV59GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV23TFSecFunctionalityDescription)==0) ) )
         {
            GXv_exceldoc4[0] = AV10ExcelDocument ;
            GXv_int5[0] = (short)(AV13CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), httpContext.getMessage( "Description", "")) ;
            AV10ExcelDocument = GXv_exceldoc4[0] ;
            secfunctionalitywwexport.this.AV13CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV23TFSecFunctionalityDescription, GXv_char7) ;
            secfunctionalitywwexport.this.GXt_char6 = GXv_char7[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV44TFSecFunctionalityType_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), httpContext.getMessage( "Type", "")) ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         secfunctionalitywwexport.this.AV13CellRow = GXv_int5[0] ;
         AV35i = 1 ;
         AV60GXV3 = 1 ;
         while ( AV60GXV3 <= AV44TFSecFunctionalityType_Sels.size() )
         {
            AV25TFSecFunctionalityType_Sel = ((Number) AV44TFSecFunctionalityType_Sels.elementAt(-1+AV60GXV3)).byteValue() ;
            if ( AV35i == 1 )
            {
               AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).getText()+", " );
            }
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainwwpsecfunctionalitytypes.getDescription(httpContext,(byte)AV25TFSecFunctionalityType_Sel), "") );
            AV35i = (long)(AV35i+1) ;
            AV60GXV3 = (int)(AV60GXV3+1) ;
         }
      }
      if ( ! ( ( AV52TFSecParentFunctionalityDescription_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), httpContext.getMessage( "Parent Functionality", "")) ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         secfunctionalitywwexport.this.AV13CellRow = GXv_int5[0] ;
         AV35i = 1 ;
         AV61GXV4 = 1 ;
         while ( AV61GXV4 <= AV52TFSecParentFunctionalityDescription_Sels.size() )
         {
            AV27TFSecParentFunctionalityDescription_Sel = (String)AV52TFSecParentFunctionalityDescription_Sels.elementAt(-1+AV61GXV4) ;
            if ( AV35i == 1 )
            {
               AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV27TFSecParentFunctionalityDescription_Sel, GXv_char7) ;
            secfunctionalitywwexport.this.GXt_char6 = GXv_char7[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV35i = (long)(AV35i+1) ;
            AV61GXV4 = (int)(AV61GXV4+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV26TFSecParentFunctionalityDescription)==0) ) )
         {
            GXv_exceldoc4[0] = AV10ExcelDocument ;
            GXv_int5[0] = (short)(AV13CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), httpContext.getMessage( "Parent Functionality", "")) ;
            AV10ExcelDocument = GXv_exceldoc4[0] ;
            secfunctionalitywwexport.this.AV13CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV26TFSecParentFunctionalityDescription, GXv_char7) ;
            secfunctionalitywwexport.this.GXt_char6 = GXv_char7[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      AV13CellRow = (int)(AV13CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV36VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV30Session.getValue("WWPBaseObjects.SecFunctionalityWWColumnsSelector"), "") != 0 )
      {
         AV29ColumnsSelectorXML = AV30Session.getValue("WWPBaseObjects.SecFunctionalityWWColumnsSelector") ;
         AV28ColumnsSelector.fromxml(AV29ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV62GXV5 = 1 ;
      while ( AV62GXV5 <= AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV46ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV62GXV5));
         if ( AV46ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV36VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV46ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV46ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV46ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV36VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV36VisibleColumnCount), 1, 1).setColor( 11 );
            AV36VisibleColumnCount = (long)(AV36VisibleColumnCount+1) ;
         }
         AV62GXV5 = (int)(AV62GXV5+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV64Wwpbaseobjects_secfunctionalitywwds_1_tfsecfunctionalitykey = AV21TFSecFunctionalityKey ;
      AV65Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey_sels = AV48TFSecFunctionalityKey_Sels ;
      AV66Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitydescription = AV23TFSecFunctionalityDescription ;
      AV67Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription_sels = AV50TFSecFunctionalityDescription_Sels ;
      AV68Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitytype_sels = AV44TFSecFunctionalityType_Sels ;
      AV69Wwpbaseobjects_secfunctionalitywwds_6_tfsecparentfunctionalitydescription = AV26TFSecParentFunctionalityDescription ;
      AV70Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription_sels = AV52TFSecParentFunctionalityDescription_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A64SecFunctionalityKey ,
                                           AV65Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey_sels ,
                                           A350SecFunctionalityDescription ,
                                           AV67Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription_sels ,
                                           Byte.valueOf(A351SecFunctionalityType) ,
                                           AV68Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitytype_sels ,
                                           A353SecParentFunctionalityDescript ,
                                           AV70Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription_sels ,
                                           Integer.valueOf(AV65Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey_sels.size()) ,
                                           AV64Wwpbaseobjects_secfunctionalitywwds_1_tfsecfunctionalitykey ,
                                           Integer.valueOf(AV67Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription_sels.size()) ,
                                           AV66Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitydescription ,
                                           Integer.valueOf(AV68Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitytype_sels.size()) ,
                                           Integer.valueOf(AV70Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription_sels.size()) ,
                                           AV69Wwpbaseobjects_secfunctionalitywwds_6_tfsecparentfunctionalitydescription ,
                                           Short.valueOf(AV16OrderedBy) ,
                                           Boolean.valueOf(AV17OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV64Wwpbaseobjects_secfunctionalitywwds_1_tfsecfunctionalitykey = GXutil.concat( GXutil.rtrim( AV64Wwpbaseobjects_secfunctionalitywwds_1_tfsecfunctionalitykey), "%", "") ;
      lV66Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitydescription = GXutil.concat( GXutil.rtrim( AV66Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitydescription), "%", "") ;
      lV69Wwpbaseobjects_secfunctionalitywwds_6_tfsecparentfunctionalitydescription = GXutil.concat( GXutil.rtrim( AV69Wwpbaseobjects_secfunctionalitywwds_6_tfsecparentfunctionalitydescription), "%", "") ;
      /* Using cursor P00BS2 */
      pr_default.execute(0, new Object[] {lV64Wwpbaseobjects_secfunctionalitywwds_1_tfsecfunctionalitykey, lV66Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitydescription, lV69Wwpbaseobjects_secfunctionalitywwds_6_tfsecparentfunctionalitydescription});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A63SecParentFunctionalityId = P00BS2_A63SecParentFunctionalityId[0] ;
         n63SecParentFunctionalityId = P00BS2_n63SecParentFunctionalityId[0] ;
         A353SecParentFunctionalityDescript = P00BS2_A353SecParentFunctionalityDescript[0] ;
         A351SecFunctionalityType = P00BS2_A351SecFunctionalityType[0] ;
         A350SecFunctionalityDescription = P00BS2_A350SecFunctionalityDescription[0] ;
         A64SecFunctionalityKey = P00BS2_A64SecFunctionalityKey[0] ;
         A62SecFunctionalityId = P00BS2_A62SecFunctionalityId[0] ;
         A353SecParentFunctionalityDescript = P00BS2_A353SecParentFunctionalityDescript[0] ;
         AV13CellRow = (int)(AV13CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV36VisibleColumnCount = 0 ;
         AV71GXV6 = 1 ;
         while ( AV71GXV6 <= AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV46ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV71GXV6));
            if ( AV46ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV46ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SecFunctionalityKey") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A64SecFunctionalityKey, GXv_char7) ;
                  secfunctionalitywwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV36VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV46ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SecFunctionalityDescription") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A350SecFunctionalityDescription, GXv_char7) ;
                  secfunctionalitywwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV36VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV46ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SecFunctionalityType") == 0 )
               {
                  AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV36VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainwwpsecfunctionalitytypes.getDescription(httpContext,(byte)A351SecFunctionalityType), "") );
               }
               else if ( GXutil.strcmp(AV46ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SecParentFunctionalityDescription") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A353SecParentFunctionalityDescript, GXv_char7) ;
                  secfunctionalitywwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV36VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               AV36VisibleColumnCount = (long)(AV36VisibleColumnCount+1) ;
            }
            AV71GXV6 = (int)(AV71GXV6+1) ;
         }
         /* Execute user subroutine: 'AFTERWRITELINE' */
         S182 ();
         if ( returnInSub )
         {
            pr_default.close(0);
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
      AV10ExcelDocument.Save();
      /* Execute user subroutine: 'CHECKSTATUS' */
      S121 ();
      if (returnInSub) return;
      AV10ExcelDocument.Close();
   }

   public void S121( )
   {
      /* 'CHECKSTATUS' Routine */
      returnInSub = false ;
      if ( AV10ExcelDocument.getErrCode() != 0 )
      {
         AV11Filename = "" ;
         AV12ErrorMessage = AV10ExcelDocument.getErrDescription() ;
         AV10ExcelDocument.Close();
         returnInSub = true;
         if (true) return;
      }
   }

   public void S151( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV28ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SecFunctionalityKey", "", "Key", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SecFunctionalityDescription", "", "Description", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SecFunctionalityType", "", "Type", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SecParentFunctionalityDescription", "", "Parent Functionality", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV31UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "WWPBaseObjects.SecFunctionalityWWColumnsSelector", GXv_char7) ;
      secfunctionalitywwexport.this.GXt_char6 = GXv_char7[0] ;
      AV31UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV31UserCustomValue)==0) ) )
      {
         AV45ColumnsSelectorAux.fromxml(AV31UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector8[0] = AV45ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV28ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, GXv_SdtWWPColumnsSelector9) ;
         AV45ColumnsSelectorAux = GXv_SdtWWPColumnsSelector8[0] ;
         AV28ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV30Session.getValue("WWPBaseObjects.SecFunctionalityWWGridState"), "") == 0 )
      {
         AV41GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "WWPBaseObjects.SecFunctionalityWWGridState"), null, null);
      }
      else
      {
         AV41GridState.fromxml(AV30Session.getValue("WWPBaseObjects.SecFunctionalityWWGridState"), null, null);
      }
      AV16OrderedBy = AV41GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV17OrderedDsc = AV41GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV72GXV7 = 1 ;
      while ( AV72GXV7 <= AV41GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV42GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV41GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV72GXV7));
         if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYKEY") == 0 )
         {
            AV21TFSecFunctionalityKey = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYKEY_SEL") == 0 )
         {
            AV47TFSecFunctionalityKey_SelsJson = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV48TFSecFunctionalityKey_Sels.fromJSonString(AV47TFSecFunctionalityKey_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYDESCRIPTION") == 0 )
         {
            AV23TFSecFunctionalityDescription = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYDESCRIPTION_SEL") == 0 )
         {
            AV49TFSecFunctionalityDescription_SelsJson = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV50TFSecFunctionalityDescription_Sels.fromJSonString(AV49TFSecFunctionalityDescription_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYTYPE_SEL") == 0 )
         {
            AV43TFSecFunctionalityType_SelsJson = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV44TFSecFunctionalityType_Sels.fromJSonString(AV43TFSecFunctionalityType_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECPARENTFUNCTIONALITYDESCRIPTION") == 0 )
         {
            AV26TFSecParentFunctionalityDescription = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECPARENTFUNCTIONALITYDESCRIPTION_SEL") == 0 )
         {
            AV51TFSecParentFunctionalityDescription_SelsJson = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV52TFSecParentFunctionalityDescription_Sels.fromJSonString(AV51TFSecParentFunctionalityDescription_SelsJson, null);
         }
         AV72GXV7 = (int)(AV72GXV7+1) ;
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
      this.aP0[0] = secfunctionalitywwexport.this.AV11Filename;
      this.aP1[0] = secfunctionalitywwexport.this.AV12ErrorMessage;
      CloseOpenCursors();
      AV10ExcelDocument.cleanup();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11Filename = "" ;
      AV12ErrorMessage = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV57Pgmname = "" ;
      AV39WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV10ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV48TFSecFunctionalityKey_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV22TFSecFunctionalityKey_Sel = "" ;
      AV21TFSecFunctionalityKey = "" ;
      AV50TFSecFunctionalityDescription_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV24TFSecFunctionalityDescription_Sel = "" ;
      AV23TFSecFunctionalityDescription = "" ;
      AV44TFSecFunctionalityType_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV52TFSecParentFunctionalityDescription_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV27TFSecParentFunctionalityDescription_Sel = "" ;
      AV26TFSecParentFunctionalityDescription = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV30Session = httpContext.getWebSession();
      AV29ColumnsSelectorXML = "" ;
      AV28ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV46ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A64SecFunctionalityKey = "" ;
      A350SecFunctionalityDescription = "" ;
      A353SecParentFunctionalityDescript = "" ;
      AV64Wwpbaseobjects_secfunctionalitywwds_1_tfsecfunctionalitykey = "" ;
      AV65Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV66Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitydescription = "" ;
      AV67Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV68Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitytype_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV69Wwpbaseobjects_secfunctionalitywwds_6_tfsecparentfunctionalitydescription = "" ;
      AV70Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV64Wwpbaseobjects_secfunctionalitywwds_1_tfsecfunctionalitykey = "" ;
      lV66Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitydescription = "" ;
      lV69Wwpbaseobjects_secfunctionalitywwds_6_tfsecparentfunctionalitydescription = "" ;
      P00BS2_A63SecParentFunctionalityId = new long[1] ;
      P00BS2_n63SecParentFunctionalityId = new boolean[] {false} ;
      P00BS2_A353SecParentFunctionalityDescript = new String[] {""} ;
      P00BS2_A351SecFunctionalityType = new byte[1] ;
      P00BS2_A350SecFunctionalityDescription = new String[] {""} ;
      P00BS2_A64SecFunctionalityKey = new String[] {""} ;
      P00BS2_A62SecFunctionalityId = new long[1] ;
      AV31UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV45ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV41GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV42GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV47TFSecFunctionalityKey_SelsJson = "" ;
      AV49TFSecFunctionalityDescription_SelsJson = "" ;
      AV43TFSecFunctionalityType_SelsJson = "" ;
      AV51TFSecParentFunctionalityDescription_SelsJson = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.wwpbaseobjects.secfunctionalitywwexport__default(),
         new Object[] {
             new Object[] {
            P00BS2_A63SecParentFunctionalityId, P00BS2_n63SecParentFunctionalityId, P00BS2_A353SecParentFunctionalityDescript, P00BS2_A351SecFunctionalityType, P00BS2_A350SecFunctionalityDescription, P00BS2_A64SecFunctionalityKey, P00BS2_A62SecFunctionalityId
            }
         }
      );
      AV57Pgmname = "WWPBaseObjects.SecFunctionalityWWExport" ;
      /* GeneXus formulas. */
      AV57Pgmname = "WWPBaseObjects.SecFunctionalityWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV25TFSecFunctionalityType_Sel ;
   private byte A351SecFunctionalityType ;
   private short GXv_int5[] ;
   private short AV16OrderedBy ;
   private short Gx_err ;
   private int AV13CellRow ;
   private int AV14FirstColumn ;
   private int AV15Random ;
   private int AV58GXV1 ;
   private int AV59GXV2 ;
   private int AV60GXV3 ;
   private int AV61GXV4 ;
   private int AV62GXV5 ;
   private int AV65Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey_sels_size ;
   private int AV67Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription_sels_size ;
   private int AV68Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitytype_sels_size ;
   private int AV70Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription_sels_size ;
   private int AV71GXV6 ;
   private int AV72GXV7 ;
   private long AV35i ;
   private long AV36VisibleColumnCount ;
   private long A63SecParentFunctionalityId ;
   private long A62SecFunctionalityId ;
   private String AV57Pgmname ;
   private String scmdbuf ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV17OrderedDsc ;
   private boolean n63SecParentFunctionalityId ;
   private String AV29ColumnsSelectorXML ;
   private String AV31UserCustomValue ;
   private String AV47TFSecFunctionalityKey_SelsJson ;
   private String AV49TFSecFunctionalityDescription_SelsJson ;
   private String AV43TFSecFunctionalityType_SelsJson ;
   private String AV51TFSecParentFunctionalityDescription_SelsJson ;
   private String AV11Filename ;
   private String AV12ErrorMessage ;
   private String AV22TFSecFunctionalityKey_Sel ;
   private String AV21TFSecFunctionalityKey ;
   private String AV24TFSecFunctionalityDescription_Sel ;
   private String AV23TFSecFunctionalityDescription ;
   private String AV27TFSecParentFunctionalityDescription_Sel ;
   private String AV26TFSecParentFunctionalityDescription ;
   private String A64SecFunctionalityKey ;
   private String A350SecFunctionalityDescription ;
   private String A353SecParentFunctionalityDescript ;
   private String AV64Wwpbaseobjects_secfunctionalitywwds_1_tfsecfunctionalitykey ;
   private String AV66Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitydescription ;
   private String AV69Wwpbaseobjects_secfunctionalitywwds_6_tfsecparentfunctionalitydescription ;
   private String lV64Wwpbaseobjects_secfunctionalitywwds_1_tfsecfunctionalitykey ;
   private String lV66Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitydescription ;
   private String lV69Wwpbaseobjects_secfunctionalitywwds_6_tfsecparentfunctionalitydescription ;
   private GXSimpleCollection<Byte> AV44TFSecFunctionalityType_Sels ;
   private GXSimpleCollection<Byte> AV68Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitytype_sels ;
   private com.genexus.webpanels.WebSession AV30Session ;
   private GXSimpleCollection<String> AV48TFSecFunctionalityKey_Sels ;
   private GXSimpleCollection<String> AV50TFSecFunctionalityDescription_Sels ;
   private GXSimpleCollection<String> AV52TFSecParentFunctionalityDescription_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private long[] P00BS2_A63SecParentFunctionalityId ;
   private boolean[] P00BS2_n63SecParentFunctionalityId ;
   private String[] P00BS2_A353SecParentFunctionalityDescript ;
   private byte[] P00BS2_A351SecFunctionalityType ;
   private String[] P00BS2_A350SecFunctionalityDescription ;
   private String[] P00BS2_A64SecFunctionalityKey ;
   private long[] P00BS2_A62SecFunctionalityId ;
   private com.genexus.gxoffice.ExcelDoc AV10ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV65Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey_sels ;
   private GXSimpleCollection<String> AV67Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription_sels ;
   private GXSimpleCollection<String> AV70Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription_sels ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV28ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV45ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV46ColumnsSelector_Column ;
   private web.wwpbaseobjects.SdtWWPContext AV39WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV41GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV42GridStateFilterValue ;
}

final  class secfunctionalitywwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00BS2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A64SecFunctionalityKey ,
                                          GXSimpleCollection<String> AV65Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey_sels ,
                                          String A350SecFunctionalityDescription ,
                                          GXSimpleCollection<String> AV67Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription_sels ,
                                          byte A351SecFunctionalityType ,
                                          GXSimpleCollection<Byte> AV68Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitytype_sels ,
                                          String A353SecParentFunctionalityDescript ,
                                          GXSimpleCollection<String> AV70Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription_sels ,
                                          int AV65Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey_sels_size ,
                                          String AV64Wwpbaseobjects_secfunctionalitywwds_1_tfsecfunctionalitykey ,
                                          int AV67Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription_sels_size ,
                                          String AV66Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitydescription ,
                                          int AV68Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitytype_sels_size ,
                                          int AV70Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription_sels_size ,
                                          String AV69Wwpbaseobjects_secfunctionalitywwds_6_tfsecparentfunctionalitydescription ,
                                          short AV16OrderedBy ,
                                          boolean AV17OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[3];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT T1.SecParentFunctionalityId AS SecParentFunctionalityId, T2.SecFunctionalityDescription AS SecParentFunctionalityDescript, T1.SecFunctionalityType, T1.SecFunctionalityDescription," ;
      scmdbuf += " T1.SecFunctionalityKey, T1.SecFunctionalityId FROM (SecFunctionality T1 LEFT JOIN SecFunctionality T2 ON T2.SecFunctionalityId = T1.SecParentFunctionalityId)" ;
      if ( ( AV65Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV64Wwpbaseobjects_secfunctionalitywwds_1_tfsecfunctionalitykey)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.SecFunctionalityKey) like LOWER(?))");
      }
      else
      {
         GXv_int10[0] = (byte)(1) ;
      }
      if ( AV65Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey_sels, "T1.SecFunctionalityKey IN (", ")")+")");
      }
      if ( ( AV67Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV66Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitydescription)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.SecFunctionalityDescription) like LOWER(?))");
      }
      else
      {
         GXv_int10[1] = (byte)(1) ;
      }
      if ( AV67Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV67Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription_sels, "T1.SecFunctionalityDescription IN (", ")")+")");
      }
      if ( AV68Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitytype_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV68Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitytype_sels, "T1.SecFunctionalityType IN (", ")")+")");
      }
      if ( ( AV70Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV69Wwpbaseobjects_secfunctionalitywwds_6_tfsecparentfunctionalitydescription)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.SecFunctionalityDescription) like LOWER(?))");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( AV70Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV70Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription_sels, "T2.SecFunctionalityDescription IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV16OrderedBy == 1 ) && ! AV17OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.SecFunctionalityKey" ;
      }
      else if ( ( AV16OrderedBy == 1 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.SecFunctionalityKey DESC" ;
      }
      else if ( ( AV16OrderedBy == 2 ) && ! AV17OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.SecFunctionalityDescription" ;
      }
      else if ( ( AV16OrderedBy == 2 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.SecFunctionalityDescription DESC" ;
      }
      else if ( ( AV16OrderedBy == 3 ) && ! AV17OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.SecFunctionalityType" ;
      }
      else if ( ( AV16OrderedBy == 3 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.SecFunctionalityType DESC" ;
      }
      else if ( ( AV16OrderedBy == 4 ) && ! AV17OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.SecFunctionalityDescription" ;
      }
      else if ( ( AV16OrderedBy == 4 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.SecFunctionalityDescription DESC" ;
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
                  return conditional_P00BS2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , ((Boolean) dynConstraints[16]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00BS2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               ((byte[]) buf[3])[0] = rslt.getByte(3);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((long[]) buf[6])[0] = rslt.getLong(6);
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
                  stmt.setVarchar(sIdx, (String)parms[3], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[4], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 100);
               }
               return;
      }
   }

}

