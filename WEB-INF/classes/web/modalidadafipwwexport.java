package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class modalidadafipwwexport extends GXProcedure
{
   public modalidadafipwwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( modalidadafipwwexport.class ), "" );
   }

   public modalidadafipwwexport( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      modalidadafipwwexport.this.aP1 = new String[] {""};
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
      modalidadafipwwexport.this.aP0 = aP0;
      modalidadafipwwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWModalidad", GXv_boolean2) ;
      modalidadafipwwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV55Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "ModalidadAFIPWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV37TFMprCod_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Modalidad de Contratación", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         modalidadafipwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV46i = 1 ;
         AV56GXV1 = 1 ;
         while ( AV56GXV1 <= AV37TFMprCod_Sels.size() )
         {
            AV38TFMprCod_Sel = (String)AV37TFMprCod_Sels.elementAt(-1+AV56GXV1) ;
            if ( AV46i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFMprCod_Sel, GXv_char7) ;
            modalidadafipwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV46i = (long)(AV46i+1) ;
            AV56GXV1 = (int)(AV56GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV36TFMprCod)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Modalidad de Contratación", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            modalidadafipwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV36TFMprCod, GXv_char7) ;
            modalidadafipwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV41TFMprDescrip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Modalidad de Contratación", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         modalidadafipwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV46i = 1 ;
         AV57GXV2 = 1 ;
         while ( AV57GXV2 <= AV41TFMprDescrip_Sels.size() )
         {
            AV42TFMprDescrip_Sel = (String)AV41TFMprDescrip_Sels.elementAt(-1+AV57GXV2) ;
            if ( AV46i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFMprDescrip_Sel, GXv_char7) ;
            modalidadafipwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV46i = (long)(AV46i+1) ;
            AV57GXV2 = (int)(AV57GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV40TFMprDescrip)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Modalidad de Contratación", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            modalidadafipwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFMprDescrip, GXv_char7) ;
            modalidadafipwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV43TFMprEsParcial_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Tiempo parcial", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         modalidadafipwwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV43TFMprEsParcial_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV43TFMprEsParcial_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (0==AV44TFMprNoDetrae_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "No realiza \"detracción\" (Importe a detraer en 0)", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         modalidadafipwwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV44TFMprNoDetrae_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV44TFMprNoDetrae_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (0==AV45TFMprHorasExtras_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Puede realizar horas extras", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         modalidadafipwwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV45TFMprHorasExtras_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV45TFMprHorasExtras_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("ModalidadAFIPWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("ModalidadAFIPWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV58GXV3 = 1 ;
      while ( AV58GXV3 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV58GXV3));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV58GXV3 = (int)(AV58GXV3+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV60Modalidadafipwwds_1_tfmprcod = AV36TFMprCod ;
      AV61Modalidadafipwwds_2_tfmprcod_sels = AV37TFMprCod_Sels ;
      AV62Modalidadafipwwds_3_tfmprdescrip = AV40TFMprDescrip ;
      AV63Modalidadafipwwds_4_tfmprdescrip_sels = AV41TFMprDescrip_Sels ;
      AV64Modalidadafipwwds_5_tfmpresparcial_sel = AV43TFMprEsParcial_Sel ;
      AV65Modalidadafipwwds_6_tfmprnodetrae_sel = AV44TFMprNoDetrae_Sel ;
      AV66Modalidadafipwwds_7_tfmprhorasextras_sel = AV45TFMprHorasExtras_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A18MprCod ,
                                           AV61Modalidadafipwwds_2_tfmprcod_sels ,
                                           A303MprDescrip ,
                                           AV63Modalidadafipwwds_4_tfmprdescrip_sels ,
                                           Integer.valueOf(AV61Modalidadafipwwds_2_tfmprcod_sels.size()) ,
                                           AV60Modalidadafipwwds_1_tfmprcod ,
                                           Integer.valueOf(AV63Modalidadafipwwds_4_tfmprdescrip_sels.size()) ,
                                           AV62Modalidadafipwwds_3_tfmprdescrip ,
                                           Byte.valueOf(AV64Modalidadafipwwds_5_tfmpresparcial_sel) ,
                                           Byte.valueOf(AV65Modalidadafipwwds_6_tfmprnodetrae_sel) ,
                                           Byte.valueOf(AV66Modalidadafipwwds_7_tfmprhorasextras_sel) ,
                                           Boolean.valueOf(A1024MprEsParcial) ,
                                           Boolean.valueOf(A1071MprNoDetrae) ,
                                           Boolean.valueOf(A1353MprHorasExtras) ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BOOLEAN,
                                           TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV60Modalidadafipwwds_1_tfmprcod = GXutil.padr( GXutil.rtrim( AV60Modalidadafipwwds_1_tfmprcod), 20, "%") ;
      lV62Modalidadafipwwds_3_tfmprdescrip = GXutil.concat( GXutil.rtrim( AV62Modalidadafipwwds_3_tfmprdescrip), "%", "") ;
      /* Using cursor P01IY2 */
      pr_default.execute(0, new Object[] {lV60Modalidadafipwwds_1_tfmprcod, lV62Modalidadafipwwds_3_tfmprdescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1353MprHorasExtras = P01IY2_A1353MprHorasExtras[0] ;
         A1071MprNoDetrae = P01IY2_A1071MprNoDetrae[0] ;
         A1024MprEsParcial = P01IY2_A1024MprEsParcial[0] ;
         A303MprDescrip = P01IY2_A303MprDescrip[0] ;
         A18MprCod = P01IY2_A18MprCod[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV32VisibleColumnCount = 0 ;
         AV67GXV4 = 1 ;
         while ( AV67GXV4 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV67GXV4));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "MprCod") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A18MprCod, GXv_char7) ;
                  modalidadafipwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "MprDescrip") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A303MprDescrip, GXv_char7) ;
                  modalidadafipwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "MprEsParcial") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1024MprEsParcial) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "MprNoDetrae") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1071MprNoDetrae) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "MprHorasExtras") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1353MprHorasExtras) );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV67GXV4 = (int)(AV67GXV4+1) ;
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
      AV24ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "MprCod", "", "Modalidad de Contratación", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "MprDescrip", "", "Modalidad de Contratación", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "MprEsParcial", "", "Tiempo parcial", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "MprNoDetrae", "", "No realiza \"detracción\" (Importe a detraer en 0)", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "MprHorasExtras", "", "Puede realizar horas extras", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&VerSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      if ( ( ( AV68Nucleoes.doubleValue() == ( 1 )) ) )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&ModificarSVG", "", "", true, "") ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      if ( ( ( AV68Nucleoes.doubleValue() == ( 1 )) ) )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&EliminarSVG", "", "", true, "") ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      GXt_char6 = AV28UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "ModalidadAFIPWWColumnsSelector", GXv_char7) ;
      modalidadafipwwexport.this.GXt_char6 = GXv_char7[0] ;
      AV28UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV28UserCustomValue)==0) ) )
      {
         AV25ColumnsSelectorAux.fromxml(AV28UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, GXv_SdtWWPColumnsSelector9) ;
         AV25ColumnsSelectorAux = GXv_SdtWWPColumnsSelector8[0] ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("ModalidadAFIPWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ModalidadAFIPWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("ModalidadAFIPWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV69GXV5 = 1 ;
      while ( AV69GXV5 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV69GXV5));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMPRCOD") == 0 )
         {
            AV36TFMprCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMPRCOD_SEL") == 0 )
         {
            AV35TFMprCod_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV37TFMprCod_Sels.fromJSonString(AV35TFMprCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMPRDESCRIP") == 0 )
         {
            AV40TFMprDescrip = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMPRDESCRIP_SEL") == 0 )
         {
            AV39TFMprDescrip_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV41TFMprDescrip_Sels.fromJSonString(AV39TFMprDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMPRESPARCIAL_SEL") == 0 )
         {
            AV43TFMprEsParcial_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMPRNODETRAE_SEL") == 0 )
         {
            AV44TFMprNoDetrae_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMPRHORASEXTRAS_SEL") == 0 )
         {
            AV45TFMprHorasExtras_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV49MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV69GXV5 = (int)(AV69GXV5+1) ;
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
      this.aP0[0] = modalidadafipwwexport.this.AV12Filename;
      this.aP1[0] = modalidadafipwwexport.this.AV13ErrorMessage;
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
      AV55Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV37TFMprCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38TFMprCod_Sel = "" ;
      AV36TFMprCod = "" ;
      AV41TFMprDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42TFMprDescrip_Sel = "" ;
      AV40TFMprDescrip = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A18MprCod = "" ;
      A303MprDescrip = "" ;
      AV60Modalidadafipwwds_1_tfmprcod = "" ;
      AV61Modalidadafipwwds_2_tfmprcod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV62Modalidadafipwwds_3_tfmprdescrip = "" ;
      AV63Modalidadafipwwds_4_tfmprdescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV60Modalidadafipwwds_1_tfmprcod = "" ;
      lV62Modalidadafipwwds_3_tfmprdescrip = "" ;
      P01IY2_A1353MprHorasExtras = new boolean[] {false} ;
      P01IY2_A1071MprNoDetrae = new boolean[] {false} ;
      P01IY2_A1024MprEsParcial = new boolean[] {false} ;
      P01IY2_A303MprDescrip = new String[] {""} ;
      P01IY2_A18MprCod = new String[] {""} ;
      AV68Nucleoes = DecimalUtil.ZERO ;
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV35TFMprCod_SelsJson = "" ;
      AV39TFMprDescrip_SelsJson = "" ;
      AV49MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.modalidadafipwwexport__default(),
         new Object[] {
             new Object[] {
            P01IY2_A1353MprHorasExtras, P01IY2_A1071MprNoDetrae, P01IY2_A1024MprEsParcial, P01IY2_A303MprDescrip, P01IY2_A18MprCod
            }
         }
      );
      AV55Pgmname = "ModalidadAFIPWWExport" ;
      /* GeneXus formulas. */
      AV55Pgmname = "ModalidadAFIPWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV43TFMprEsParcial_Sel ;
   private byte AV44TFMprNoDetrae_Sel ;
   private byte AV45TFMprHorasExtras_Sel ;
   private byte AV64Modalidadafipwwds_5_tfmpresparcial_sel ;
   private byte AV65Modalidadafipwwds_6_tfmprnodetrae_sel ;
   private byte AV66Modalidadafipwwds_7_tfmprhorasextras_sel ;
   private short GXv_int5[] ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV56GXV1 ;
   private int AV57GXV2 ;
   private int AV58GXV3 ;
   private int AV61Modalidadafipwwds_2_tfmprcod_sels_size ;
   private int AV63Modalidadafipwwds_4_tfmprdescrip_sels_size ;
   private int AV67GXV4 ;
   private int AV69GXV5 ;
   private long AV46i ;
   private long AV32VisibleColumnCount ;
   private java.math.BigDecimal AV68Nucleoes ;
   private String AV55Pgmname ;
   private String AV38TFMprCod_Sel ;
   private String AV36TFMprCod ;
   private String A18MprCod ;
   private String AV60Modalidadafipwwds_1_tfmprcod ;
   private String scmdbuf ;
   private String lV60Modalidadafipwwds_1_tfmprcod ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean A1024MprEsParcial ;
   private boolean A1071MprNoDetrae ;
   private boolean A1353MprHorasExtras ;
   private boolean AV19OrderedDsc ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV35TFMprCod_SelsJson ;
   private String AV39TFMprDescrip_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV42TFMprDescrip_Sel ;
   private String AV40TFMprDescrip ;
   private String A303MprDescrip ;
   private String AV62Modalidadafipwwds_3_tfmprdescrip ;
   private String lV62Modalidadafipwwds_3_tfmprdescrip ;
   private String AV49MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV37TFMprCod_Sels ;
   private GXSimpleCollection<String> AV41TFMprDescrip_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private boolean[] P01IY2_A1353MprHorasExtras ;
   private boolean[] P01IY2_A1071MprNoDetrae ;
   private boolean[] P01IY2_A1024MprEsParcial ;
   private String[] P01IY2_A303MprDescrip ;
   private String[] P01IY2_A18MprCod ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV61Modalidadafipwwds_2_tfmprcod_sels ;
   private GXSimpleCollection<String> AV63Modalidadafipwwds_4_tfmprdescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV24ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV26ColumnsSelector_Column ;
}

final  class modalidadafipwwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01IY2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A18MprCod ,
                                          GXSimpleCollection<String> AV61Modalidadafipwwds_2_tfmprcod_sels ,
                                          String A303MprDescrip ,
                                          GXSimpleCollection<String> AV63Modalidadafipwwds_4_tfmprdescrip_sels ,
                                          int AV61Modalidadafipwwds_2_tfmprcod_sels_size ,
                                          String AV60Modalidadafipwwds_1_tfmprcod ,
                                          int AV63Modalidadafipwwds_4_tfmprdescrip_sels_size ,
                                          String AV62Modalidadafipwwds_3_tfmprdescrip ,
                                          byte AV64Modalidadafipwwds_5_tfmpresparcial_sel ,
                                          byte AV65Modalidadafipwwds_6_tfmprnodetrae_sel ,
                                          byte AV66Modalidadafipwwds_7_tfmprhorasextras_sel ,
                                          boolean A1024MprEsParcial ,
                                          boolean A1071MprNoDetrae ,
                                          boolean A1353MprHorasExtras ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[2];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT MprHorasExtras, MprNoDetrae, MprEsParcial, MprDescrip, MprCod FROM ModalidadAFIP" ;
      if ( ( AV61Modalidadafipwwds_2_tfmprcod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV60Modalidadafipwwds_1_tfmprcod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MprCod) like LOWER(?))");
      }
      else
      {
         GXv_int10[0] = (byte)(1) ;
      }
      if ( AV61Modalidadafipwwds_2_tfmprcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Modalidadafipwwds_2_tfmprcod_sels, "MprCod IN (", ")")+")");
      }
      if ( ( AV63Modalidadafipwwds_4_tfmprdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV62Modalidadafipwwds_3_tfmprdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MprDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int10[1] = (byte)(1) ;
      }
      if ( AV63Modalidadafipwwds_4_tfmprdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV63Modalidadafipwwds_4_tfmprdescrip_sels, "MprDescrip IN (", ")")+")");
      }
      if ( AV64Modalidadafipwwds_5_tfmpresparcial_sel == 1 )
      {
         addWhere(sWhereString, "(MprEsParcial = TRUE)");
      }
      if ( AV64Modalidadafipwwds_5_tfmpresparcial_sel == 2 )
      {
         addWhere(sWhereString, "(MprEsParcial = FALSE)");
      }
      if ( AV65Modalidadafipwwds_6_tfmprnodetrae_sel == 1 )
      {
         addWhere(sWhereString, "(MprNoDetrae = TRUE)");
      }
      if ( AV65Modalidadafipwwds_6_tfmprnodetrae_sel == 2 )
      {
         addWhere(sWhereString, "(MprNoDetrae = FALSE)");
      }
      if ( AV66Modalidadafipwwds_7_tfmprhorasextras_sel == 1 )
      {
         addWhere(sWhereString, "(MprHorasExtras = TRUE)");
      }
      if ( AV66Modalidadafipwwds_7_tfmprhorasextras_sel == 2 )
      {
         addWhere(sWhereString, "(MprHorasExtras = FALSE)");
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY MprCod" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY MprCod DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY MprDescrip" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY MprDescrip DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY MprEsParcial" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY MprEsParcial DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY MprNoDetrae" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY MprNoDetrae DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY MprHorasExtras" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY MprHorasExtras DESC" ;
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
                  return conditional_P01IY2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).byteValue() , ((Number) dynConstraints[9]).byteValue() , ((Number) dynConstraints[10]).byteValue() , ((Boolean) dynConstraints[11]).booleanValue() , ((Boolean) dynConstraints[12]).booleanValue() , ((Boolean) dynConstraints[13]).booleanValue() , ((Number) dynConstraints[14]).shortValue() , ((Boolean) dynConstraints[15]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01IY2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
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
                  stmt.setString(sIdx, (String)parms[2], 20);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[3], 400);
               }
               return;
      }
   }

}

