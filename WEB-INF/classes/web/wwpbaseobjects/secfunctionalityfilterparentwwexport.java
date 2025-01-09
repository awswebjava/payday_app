package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class secfunctionalityfilterparentwwexport extends GXProcedure
{
   public secfunctionalityfilterparentwwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secfunctionalityfilterparentwwexport.class ), "" );
   }

   public secfunctionalityfilterparentwwexport( int remoteHandle ,
                                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      secfunctionalityfilterparentwwexport.this.aP1 = new String[] {""};
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
      secfunctionalityfilterparentwwexport.this.aP0 = aP0;
      secfunctionalityfilterparentwwexport.this.aP1 = aP1;
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
      secfunctionalityfilterparentwwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV58Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV40WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV40WWPContext = GXv_SdtWWPContext3[0] ;
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
      AV11Filename = "SecFunctionalityFilterParentWWExport-" + GXutil.trim( GXutil.str( AV15Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV49TFSecFunctionalityKey_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), httpContext.getMessage( "Key", "")) ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         secfunctionalityfilterparentwwexport.this.AV13CellRow = GXv_int5[0] ;
         AV36i = 1 ;
         AV59GXV1 = 1 ;
         while ( AV59GXV1 <= AV49TFSecFunctionalityKey_Sels.size() )
         {
            AV23TFSecFunctionalityKey_Sel = (String)AV49TFSecFunctionalityKey_Sels.elementAt(-1+AV59GXV1) ;
            if ( AV36i == 1 )
            {
               AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV23TFSecFunctionalityKey_Sel, GXv_char7) ;
            secfunctionalityfilterparentwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV36i = (long)(AV36i+1) ;
            AV59GXV1 = (int)(AV59GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV22TFSecFunctionalityKey)==0) ) )
         {
            GXv_exceldoc4[0] = AV10ExcelDocument ;
            GXv_int5[0] = (short)(AV13CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), httpContext.getMessage( "Key", "")) ;
            AV10ExcelDocument = GXv_exceldoc4[0] ;
            secfunctionalityfilterparentwwexport.this.AV13CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV22TFSecFunctionalityKey, GXv_char7) ;
            secfunctionalityfilterparentwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV51TFSecFunctionalityDescription_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), httpContext.getMessage( "Description", "")) ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         secfunctionalityfilterparentwwexport.this.AV13CellRow = GXv_int5[0] ;
         AV36i = 1 ;
         AV60GXV2 = 1 ;
         while ( AV60GXV2 <= AV51TFSecFunctionalityDescription_Sels.size() )
         {
            AV25TFSecFunctionalityDescription_Sel = (String)AV51TFSecFunctionalityDescription_Sels.elementAt(-1+AV60GXV2) ;
            if ( AV36i == 1 )
            {
               AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV25TFSecFunctionalityDescription_Sel, GXv_char7) ;
            secfunctionalityfilterparentwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV36i = (long)(AV36i+1) ;
            AV60GXV2 = (int)(AV60GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV24TFSecFunctionalityDescription)==0) ) )
         {
            GXv_exceldoc4[0] = AV10ExcelDocument ;
            GXv_int5[0] = (short)(AV13CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), httpContext.getMessage( "Description", "")) ;
            AV10ExcelDocument = GXv_exceldoc4[0] ;
            secfunctionalityfilterparentwwexport.this.AV13CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV24TFSecFunctionalityDescription, GXv_char7) ;
            secfunctionalityfilterparentwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV45TFSecFunctionalityType_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), httpContext.getMessage( "Type", "")) ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         secfunctionalityfilterparentwwexport.this.AV13CellRow = GXv_int5[0] ;
         AV36i = 1 ;
         AV61GXV3 = 1 ;
         while ( AV61GXV3 <= AV45TFSecFunctionalityType_Sels.size() )
         {
            AV26TFSecFunctionalityType_Sel = ((Number) AV45TFSecFunctionalityType_Sels.elementAt(-1+AV61GXV3)).byteValue() ;
            if ( AV36i == 1 )
            {
               AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).getText()+", " );
            }
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainwwpsecfunctionalitytypes.getDescription(httpContext,(byte)AV26TFSecFunctionalityType_Sel), "") );
            AV36i = (long)(AV36i+1) ;
            AV61GXV3 = (int)(AV61GXV3+1) ;
         }
      }
      if ( ! ( ( AV53TFSecParentFunctionalityDescription_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), httpContext.getMessage( "Parent Functionality", "")) ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         secfunctionalityfilterparentwwexport.this.AV13CellRow = GXv_int5[0] ;
         AV36i = 1 ;
         AV62GXV4 = 1 ;
         while ( AV62GXV4 <= AV53TFSecParentFunctionalityDescription_Sels.size() )
         {
            AV28TFSecParentFunctionalityDescription_Sel = (String)AV53TFSecParentFunctionalityDescription_Sels.elementAt(-1+AV62GXV4) ;
            if ( AV36i == 1 )
            {
               AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV28TFSecParentFunctionalityDescription_Sel, GXv_char7) ;
            secfunctionalityfilterparentwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV36i = (long)(AV36i+1) ;
            AV62GXV4 = (int)(AV62GXV4+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV27TFSecParentFunctionalityDescription)==0) ) )
         {
            GXv_exceldoc4[0] = AV10ExcelDocument ;
            GXv_int5[0] = (short)(AV13CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), httpContext.getMessage( "Parent Functionality", "")) ;
            AV10ExcelDocument = GXv_exceldoc4[0] ;
            secfunctionalityfilterparentwwexport.this.AV13CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV27TFSecParentFunctionalityDescription, GXv_char7) ;
            secfunctionalityfilterparentwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      AV13CellRow = (int)(AV13CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV37VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV31Session.getValue("WWPBaseObjects.SecFunctionalityFilterParentWWColumnsSelector"), "") != 0 )
      {
         AV30ColumnsSelectorXML = AV31Session.getValue("WWPBaseObjects.SecFunctionalityFilterParentWWColumnsSelector") ;
         AV29ColumnsSelector.fromxml(AV30ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      AV29ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV63GXV5 = 1 ;
      while ( AV63GXV5 <= AV29ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV47ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV29ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV63GXV5));
         if ( AV47ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV37VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV47ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV47ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV47ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV37VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV37VisibleColumnCount), 1, 1).setColor( 11 );
            AV37VisibleColumnCount = (long)(AV37VisibleColumnCount+1) ;
         }
         AV63GXV5 = (int)(AV63GXV5+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV65Wwpbaseobjects_secfunctionalityfilterparentwwds_1_secparentfunctionalityid = AV16SecParentFunctionalityId ;
      AV66Wwpbaseobjects_secfunctionalityfilterparentwwds_2_tfsecfunctionalitykey = AV22TFSecFunctionalityKey ;
      AV67Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels = AV49TFSecFunctionalityKey_Sels ;
      AV68Wwpbaseobjects_secfunctionalityfilterparentwwds_4_tfsecfunctionalitydescription = AV24TFSecFunctionalityDescription ;
      AV69Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels = AV51TFSecFunctionalityDescription_Sels ;
      AV70Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitytype_sels = AV45TFSecFunctionalityType_Sels ;
      AV71Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecparentfunctionalitydescription = AV27TFSecParentFunctionalityDescription ;
      AV72Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels = AV53TFSecParentFunctionalityDescription_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A64SecFunctionalityKey ,
                                           AV67Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels ,
                                           A350SecFunctionalityDescription ,
                                           AV69Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels ,
                                           Byte.valueOf(A351SecFunctionalityType) ,
                                           AV70Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitytype_sels ,
                                           A353SecParentFunctionalityDescript ,
                                           AV72Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels ,
                                           Integer.valueOf(AV67Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels.size()) ,
                                           AV66Wwpbaseobjects_secfunctionalityfilterparentwwds_2_tfsecfunctionalitykey ,
                                           Integer.valueOf(AV69Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels.size()) ,
                                           AV68Wwpbaseobjects_secfunctionalityfilterparentwwds_4_tfsecfunctionalitydescription ,
                                           Integer.valueOf(AV70Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitytype_sels.size()) ,
                                           Integer.valueOf(AV72Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels.size()) ,
                                           AV71Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecparentfunctionalitydescription ,
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) ,
                                           Long.valueOf(AV65Wwpbaseobjects_secfunctionalityfilterparentwwds_1_secparentfunctionalityid) ,
                                           Long.valueOf(A63SecParentFunctionalityId) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.BOOLEAN
                                           }
      });
      lV66Wwpbaseobjects_secfunctionalityfilterparentwwds_2_tfsecfunctionalitykey = GXutil.concat( GXutil.rtrim( AV66Wwpbaseobjects_secfunctionalityfilterparentwwds_2_tfsecfunctionalitykey), "%", "") ;
      lV68Wwpbaseobjects_secfunctionalityfilterparentwwds_4_tfsecfunctionalitydescription = GXutil.concat( GXutil.rtrim( AV68Wwpbaseobjects_secfunctionalityfilterparentwwds_4_tfsecfunctionalitydescription), "%", "") ;
      lV71Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecparentfunctionalitydescription = GXutil.concat( GXutil.rtrim( AV71Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecparentfunctionalitydescription), "%", "") ;
      /* Using cursor P00BO2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV65Wwpbaseobjects_secfunctionalityfilterparentwwds_1_secparentfunctionalityid), lV66Wwpbaseobjects_secfunctionalityfilterparentwwds_2_tfsecfunctionalitykey, lV68Wwpbaseobjects_secfunctionalityfilterparentwwds_4_tfsecfunctionalitydescription, lV71Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecparentfunctionalitydescription});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A353SecParentFunctionalityDescript = P00BO2_A353SecParentFunctionalityDescript[0] ;
         A351SecFunctionalityType = P00BO2_A351SecFunctionalityType[0] ;
         A350SecFunctionalityDescription = P00BO2_A350SecFunctionalityDescription[0] ;
         A64SecFunctionalityKey = P00BO2_A64SecFunctionalityKey[0] ;
         A63SecParentFunctionalityId = P00BO2_A63SecParentFunctionalityId[0] ;
         n63SecParentFunctionalityId = P00BO2_n63SecParentFunctionalityId[0] ;
         A62SecFunctionalityId = P00BO2_A62SecFunctionalityId[0] ;
         A353SecParentFunctionalityDescript = P00BO2_A353SecParentFunctionalityDescript[0] ;
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
         AV37VisibleColumnCount = 0 ;
         AV73GXV6 = 1 ;
         while ( AV73GXV6 <= AV29ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV47ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV29ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV73GXV6));
            if ( AV47ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV47ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SecFunctionalityKey") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A64SecFunctionalityKey, GXv_char7) ;
                  secfunctionalityfilterparentwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV37VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV47ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SecFunctionalityDescription") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A350SecFunctionalityDescription, GXv_char7) ;
                  secfunctionalityfilterparentwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV37VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV47ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SecFunctionalityType") == 0 )
               {
                  AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV37VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainwwpsecfunctionalitytypes.getDescription(httpContext,(byte)A351SecFunctionalityType), "") );
               }
               else if ( GXutil.strcmp(AV47ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SecParentFunctionalityDescription") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A353SecParentFunctionalityDescript, GXv_char7) ;
                  secfunctionalityfilterparentwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV37VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               AV37VisibleColumnCount = (long)(AV37VisibleColumnCount+1) ;
            }
            AV73GXV6 = (int)(AV73GXV6+1) ;
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
      AV29ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV29ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SecFunctionalityKey", "", "Key", true, "") ;
      AV29ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV29ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SecFunctionalityDescription", "", "Description", true, "") ;
      AV29ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV29ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SecFunctionalityType", "", "Type", true, "") ;
      AV29ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV29ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SecParentFunctionalityDescription", "", "Parent Functionality", true, "") ;
      AV29ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV32UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "WWPBaseObjects.SecFunctionalityFilterParentWWColumnsSelector", GXv_char7) ;
      secfunctionalityfilterparentwwexport.this.GXt_char6 = GXv_char7[0] ;
      AV32UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV32UserCustomValue)==0) ) )
      {
         AV46ColumnsSelectorAux.fromxml(AV32UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector8[0] = AV46ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV29ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, GXv_SdtWWPColumnsSelector9) ;
         AV46ColumnsSelectorAux = GXv_SdtWWPColumnsSelector8[0] ;
         AV29ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV31Session.getValue("WWPBaseObjects.SecFunctionalityFilterParentWWGridState"), "") == 0 )
      {
         AV42GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "WWPBaseObjects.SecFunctionalityFilterParentWWGridState"), null, null);
      }
      else
      {
         AV42GridState.fromxml(AV31Session.getValue("WWPBaseObjects.SecFunctionalityFilterParentWWGridState"), null, null);
      }
      AV17OrderedBy = AV42GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV18OrderedDsc = AV42GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV74GXV7 = 1 ;
      while ( AV74GXV7 <= AV42GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV43GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV42GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV74GXV7));
         if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYKEY") == 0 )
         {
            AV22TFSecFunctionalityKey = AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYKEY_SEL") == 0 )
         {
            AV48TFSecFunctionalityKey_SelsJson = AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV49TFSecFunctionalityKey_Sels.fromJSonString(AV48TFSecFunctionalityKey_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYDESCRIPTION") == 0 )
         {
            AV24TFSecFunctionalityDescription = AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYDESCRIPTION_SEL") == 0 )
         {
            AV50TFSecFunctionalityDescription_SelsJson = AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV51TFSecFunctionalityDescription_Sels.fromJSonString(AV50TFSecFunctionalityDescription_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYTYPE_SEL") == 0 )
         {
            AV44TFSecFunctionalityType_SelsJson = AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV45TFSecFunctionalityType_Sels.fromJSonString(AV44TFSecFunctionalityType_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECPARENTFUNCTIONALITYDESCRIPTION") == 0 )
         {
            AV27TFSecParentFunctionalityDescription = AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECPARENTFUNCTIONALITYDESCRIPTION_SEL") == 0 )
         {
            AV52TFSecParentFunctionalityDescription_SelsJson = AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV53TFSecParentFunctionalityDescription_Sels.fromJSonString(AV52TFSecParentFunctionalityDescription_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&SECPARENTFUNCTIONALITYID") == 0 )
         {
            AV16SecParentFunctionalityId = GXutil.lval( AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
         }
         AV74GXV7 = (int)(AV74GXV7+1) ;
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
      this.aP0[0] = secfunctionalityfilterparentwwexport.this.AV11Filename;
      this.aP1[0] = secfunctionalityfilterparentwwexport.this.AV12ErrorMessage;
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
      AV58Pgmname = "" ;
      AV40WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV10ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV49TFSecFunctionalityKey_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV23TFSecFunctionalityKey_Sel = "" ;
      AV22TFSecFunctionalityKey = "" ;
      AV51TFSecFunctionalityDescription_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV25TFSecFunctionalityDescription_Sel = "" ;
      AV24TFSecFunctionalityDescription = "" ;
      AV45TFSecFunctionalityType_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV53TFSecParentFunctionalityDescription_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV28TFSecParentFunctionalityDescription_Sel = "" ;
      AV27TFSecParentFunctionalityDescription = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV31Session = httpContext.getWebSession();
      AV30ColumnsSelectorXML = "" ;
      AV29ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV47ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A64SecFunctionalityKey = "" ;
      A350SecFunctionalityDescription = "" ;
      A353SecParentFunctionalityDescript = "" ;
      AV66Wwpbaseobjects_secfunctionalityfilterparentwwds_2_tfsecfunctionalitykey = "" ;
      AV67Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV68Wwpbaseobjects_secfunctionalityfilterparentwwds_4_tfsecfunctionalitydescription = "" ;
      AV69Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV70Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitytype_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV71Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecparentfunctionalitydescription = "" ;
      AV72Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV66Wwpbaseobjects_secfunctionalityfilterparentwwds_2_tfsecfunctionalitykey = "" ;
      lV68Wwpbaseobjects_secfunctionalityfilterparentwwds_4_tfsecfunctionalitydescription = "" ;
      lV71Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecparentfunctionalitydescription = "" ;
      P00BO2_A353SecParentFunctionalityDescript = new String[] {""} ;
      P00BO2_A351SecFunctionalityType = new byte[1] ;
      P00BO2_A350SecFunctionalityDescription = new String[] {""} ;
      P00BO2_A64SecFunctionalityKey = new String[] {""} ;
      P00BO2_A63SecParentFunctionalityId = new long[1] ;
      P00BO2_n63SecParentFunctionalityId = new boolean[] {false} ;
      P00BO2_A62SecFunctionalityId = new long[1] ;
      AV32UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV46ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV42GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV43GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV48TFSecFunctionalityKey_SelsJson = "" ;
      AV50TFSecFunctionalityDescription_SelsJson = "" ;
      AV44TFSecFunctionalityType_SelsJson = "" ;
      AV52TFSecParentFunctionalityDescription_SelsJson = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.wwpbaseobjects.secfunctionalityfilterparentwwexport__default(),
         new Object[] {
             new Object[] {
            P00BO2_A353SecParentFunctionalityDescript, P00BO2_A351SecFunctionalityType, P00BO2_A350SecFunctionalityDescription, P00BO2_A64SecFunctionalityKey, P00BO2_A63SecParentFunctionalityId, P00BO2_n63SecParentFunctionalityId, P00BO2_A62SecFunctionalityId
            }
         }
      );
      AV58Pgmname = "WWPBaseObjects.SecFunctionalityFilterParentWWExport" ;
      /* GeneXus formulas. */
      AV58Pgmname = "WWPBaseObjects.SecFunctionalityFilterParentWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV26TFSecFunctionalityType_Sel ;
   private byte A351SecFunctionalityType ;
   private short GXv_int5[] ;
   private short AV17OrderedBy ;
   private short Gx_err ;
   private int AV13CellRow ;
   private int AV14FirstColumn ;
   private int AV15Random ;
   private int AV59GXV1 ;
   private int AV60GXV2 ;
   private int AV61GXV3 ;
   private int AV62GXV4 ;
   private int AV63GXV5 ;
   private int AV67Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels_size ;
   private int AV69Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels_size ;
   private int AV70Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitytype_sels_size ;
   private int AV72Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels_size ;
   private int AV73GXV6 ;
   private int AV74GXV7 ;
   private long AV36i ;
   private long AV37VisibleColumnCount ;
   private long AV65Wwpbaseobjects_secfunctionalityfilterparentwwds_1_secparentfunctionalityid ;
   private long AV16SecParentFunctionalityId ;
   private long A63SecParentFunctionalityId ;
   private long A62SecFunctionalityId ;
   private String AV58Pgmname ;
   private String scmdbuf ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV18OrderedDsc ;
   private boolean n63SecParentFunctionalityId ;
   private String AV30ColumnsSelectorXML ;
   private String AV32UserCustomValue ;
   private String AV48TFSecFunctionalityKey_SelsJson ;
   private String AV50TFSecFunctionalityDescription_SelsJson ;
   private String AV44TFSecFunctionalityType_SelsJson ;
   private String AV52TFSecParentFunctionalityDescription_SelsJson ;
   private String AV11Filename ;
   private String AV12ErrorMessage ;
   private String AV23TFSecFunctionalityKey_Sel ;
   private String AV22TFSecFunctionalityKey ;
   private String AV25TFSecFunctionalityDescription_Sel ;
   private String AV24TFSecFunctionalityDescription ;
   private String AV28TFSecParentFunctionalityDescription_Sel ;
   private String AV27TFSecParentFunctionalityDescription ;
   private String A64SecFunctionalityKey ;
   private String A350SecFunctionalityDescription ;
   private String A353SecParentFunctionalityDescript ;
   private String AV66Wwpbaseobjects_secfunctionalityfilterparentwwds_2_tfsecfunctionalitykey ;
   private String AV68Wwpbaseobjects_secfunctionalityfilterparentwwds_4_tfsecfunctionalitydescription ;
   private String AV71Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecparentfunctionalitydescription ;
   private String lV66Wwpbaseobjects_secfunctionalityfilterparentwwds_2_tfsecfunctionalitykey ;
   private String lV68Wwpbaseobjects_secfunctionalityfilterparentwwds_4_tfsecfunctionalitydescription ;
   private String lV71Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecparentfunctionalitydescription ;
   private GXSimpleCollection<Byte> AV45TFSecFunctionalityType_Sels ;
   private GXSimpleCollection<Byte> AV70Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitytype_sels ;
   private com.genexus.webpanels.WebSession AV31Session ;
   private GXSimpleCollection<String> AV49TFSecFunctionalityKey_Sels ;
   private GXSimpleCollection<String> AV51TFSecFunctionalityDescription_Sels ;
   private GXSimpleCollection<String> AV53TFSecParentFunctionalityDescription_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P00BO2_A353SecParentFunctionalityDescript ;
   private byte[] P00BO2_A351SecFunctionalityType ;
   private String[] P00BO2_A350SecFunctionalityDescription ;
   private String[] P00BO2_A64SecFunctionalityKey ;
   private long[] P00BO2_A63SecParentFunctionalityId ;
   private boolean[] P00BO2_n63SecParentFunctionalityId ;
   private long[] P00BO2_A62SecFunctionalityId ;
   private com.genexus.gxoffice.ExcelDoc AV10ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV67Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels ;
   private GXSimpleCollection<String> AV69Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels ;
   private GXSimpleCollection<String> AV72Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV29ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV46ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV47ColumnsSelector_Column ;
   private web.wwpbaseobjects.SdtWWPContext AV40WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV42GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV43GridStateFilterValue ;
}

final  class secfunctionalityfilterparentwwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00BO2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A64SecFunctionalityKey ,
                                          GXSimpleCollection<String> AV67Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels ,
                                          String A350SecFunctionalityDescription ,
                                          GXSimpleCollection<String> AV69Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels ,
                                          byte A351SecFunctionalityType ,
                                          GXSimpleCollection<Byte> AV70Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitytype_sels ,
                                          String A353SecParentFunctionalityDescript ,
                                          GXSimpleCollection<String> AV72Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels ,
                                          int AV67Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels_size ,
                                          String AV66Wwpbaseobjects_secfunctionalityfilterparentwwds_2_tfsecfunctionalitykey ,
                                          int AV69Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels_size ,
                                          String AV68Wwpbaseobjects_secfunctionalityfilterparentwwds_4_tfsecfunctionalitydescription ,
                                          int AV70Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitytype_sels_size ,
                                          int AV72Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels_size ,
                                          String AV71Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecparentfunctionalitydescription ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc ,
                                          long AV65Wwpbaseobjects_secfunctionalityfilterparentwwds_1_secparentfunctionalityid ,
                                          long A63SecParentFunctionalityId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[4];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT T2.SecFunctionalityDescription AS SecParentFunctionalityDescript, T1.SecFunctionalityType, T1.SecFunctionalityDescription, T1.SecFunctionalityKey, T1.SecParentFunctionalityId" ;
      scmdbuf += " AS SecParentFunctionalityId, T1.SecFunctionalityId FROM (SecFunctionality T1 LEFT JOIN SecFunctionality T2 ON T2.SecFunctionalityId = T1.SecParentFunctionalityId)" ;
      addWhere(sWhereString, "(T1.SecParentFunctionalityId = ?)");
      if ( ( AV67Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV66Wwpbaseobjects_secfunctionalityfilterparentwwds_2_tfsecfunctionalitykey)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.SecFunctionalityKey) like LOWER(?))");
      }
      else
      {
         GXv_int10[1] = (byte)(1) ;
      }
      if ( AV67Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV67Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels, "T1.SecFunctionalityKey IN (", ")")+")");
      }
      if ( ( AV69Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV68Wwpbaseobjects_secfunctionalityfilterparentwwds_4_tfsecfunctionalitydescription)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.SecFunctionalityDescription) like LOWER(?))");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( AV69Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels, "T1.SecFunctionalityDescription IN (", ")")+")");
      }
      if ( AV70Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitytype_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV70Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitytype_sels, "T1.SecFunctionalityType IN (", ")")+")");
      }
      if ( ( AV72Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV71Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecparentfunctionalitydescription)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.SecFunctionalityDescription) like LOWER(?))");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( AV72Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV72Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels, "T2.SecFunctionalityDescription IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV17OrderedBy == 1 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.SecParentFunctionalityId, T1.SecFunctionalityKey" ;
      }
      else if ( ( AV17OrderedBy == 1 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.SecParentFunctionalityId DESC, T1.SecFunctionalityKey DESC" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.SecParentFunctionalityId, T1.SecFunctionalityDescription" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.SecParentFunctionalityId DESC, T1.SecFunctionalityDescription DESC" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.SecParentFunctionalityId, T1.SecFunctionalityType" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.SecParentFunctionalityId DESC, T1.SecFunctionalityType DESC" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.SecParentFunctionalityId, T2.SecFunctionalityDescription" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.SecParentFunctionalityId DESC, T2.SecFunctionalityDescription DESC" ;
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
                  return conditional_P00BO2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , ((Boolean) dynConstraints[16]).booleanValue() , ((Number) dynConstraints[17]).longValue() , ((Number) dynConstraints[18]).longValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00BO2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
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
                  stmt.setLong(sIdx, ((Number) parms[4]).longValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 100);
               }
               return;
      }
   }

}

