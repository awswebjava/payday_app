package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class estados_civileswwexport extends GXProcedure
{
   public estados_civileswwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( estados_civileswwexport.class ), "" );
   }

   public estados_civileswwexport( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      estados_civileswwexport.this.aP1 = new String[] {""};
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
      estados_civileswwexport.this.aP0 = aP0;
      estados_civileswwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEstados_civiles", GXv_boolean2) ;
      estados_civileswwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV59Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "Estados_civilesWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( (0==AV35TFEstaCivilCod) && (0==AV36TFEstaCivilCod_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Id.", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         estados_civileswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV35TFEstaCivilCod );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         estados_civileswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV36TFEstaCivilCod_To );
      }
      if ( ! ( ( AV39TFEstaCivilDescrip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Descripciòn masculina", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         estados_civileswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV41i = 1 ;
         AV60GXV1 = 1 ;
         while ( AV60GXV1 <= AV39TFEstaCivilDescrip_Sels.size() )
         {
            AV40TFEstaCivilDescrip_Sel = (String)AV39TFEstaCivilDescrip_Sels.elementAt(-1+AV60GXV1) ;
            if ( AV41i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFEstaCivilDescrip_Sel, GXv_char7) ;
            estados_civileswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV41i = (long)(AV41i+1) ;
            AV60GXV1 = (int)(AV60GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV38TFEstaCivilDescrip)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Descripciòn masculina", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            estados_civileswwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFEstaCivilDescrip, GXv_char7) ;
            estados_civileswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV46TFEstaCivilDescripFem_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Descripciòn femenina", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         estados_civileswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV41i = 1 ;
         AV61GXV2 = 1 ;
         while ( AV61GXV2 <= AV46TFEstaCivilDescripFem_Sels.size() )
         {
            AV47TFEstaCivilDescripFem_Sel = (String)AV46TFEstaCivilDescripFem_Sels.elementAt(-1+AV61GXV2) ;
            if ( AV41i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV47TFEstaCivilDescripFem_Sel, GXv_char7) ;
            estados_civileswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV41i = (long)(AV41i+1) ;
            AV61GXV2 = (int)(AV61GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV45TFEstaCivilDescripFem)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Descripciòn femenina", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            estados_civileswwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV45TFEstaCivilDescripFem, GXv_char7) ;
            estados_civileswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV54TFEstaCivilCodFor_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Código en parámetros de fórmulas", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         estados_civileswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV41i = 1 ;
         AV62GXV3 = 1 ;
         while ( AV62GXV3 <= AV54TFEstaCivilCodFor_Sels.size() )
         {
            AV55TFEstaCivilCodFor_Sel = (String)AV54TFEstaCivilCodFor_Sels.elementAt(-1+AV62GXV3) ;
            if ( AV41i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV55TFEstaCivilCodFor_Sel, GXv_char7) ;
            estados_civileswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV41i = (long)(AV41i+1) ;
            AV62GXV3 = (int)(AV62GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV53TFEstaCivilCodFor)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Código en parámetros de fórmulas", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            estados_civileswwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV53TFEstaCivilCodFor, GXv_char7) ;
            estados_civileswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV56TFEstaCivilCasadoEs_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Deduce impuesto a las ganancias", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         estados_civileswwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV56TFEstaCivilCasadoEs_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV56TFEstaCivilCasadoEs_Sel == 2 )
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
      if ( GXutil.strcmp(AV20Session.getValue("Estados_civilesWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("Estados_civilesWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Isvisible( true );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Columnname( "EstaCivilPais" );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Displayname( httpContext.getMessage( "Paìs", "") );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Order( (short)(AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size()+1) );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().add(AV26ColumnsSelector_Column, 0);
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV63GXV4 = 1 ;
      while ( AV63GXV4 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV63GXV4));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV63GXV4 = (int)(AV63GXV4+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV65Estados_civileswwds_1_tfestacivilcod = AV35TFEstaCivilCod ;
      AV66Estados_civileswwds_2_tfestacivilcod_to = AV36TFEstaCivilCod_To ;
      AV67Estados_civileswwds_3_tfestacivildescrip = AV38TFEstaCivilDescrip ;
      AV68Estados_civileswwds_4_tfestacivildescrip_sels = AV39TFEstaCivilDescrip_Sels ;
      AV69Estados_civileswwds_5_tfestacivildescripfem = AV45TFEstaCivilDescripFem ;
      AV70Estados_civileswwds_6_tfestacivildescripfem_sels = AV46TFEstaCivilDescripFem_Sels ;
      AV71Estados_civileswwds_7_tfestacivilcodfor = AV53TFEstaCivilCodFor ;
      AV72Estados_civileswwds_8_tfestacivilcodfor_sels = AV54TFEstaCivilCodFor_Sels ;
      AV73Estados_civileswwds_9_tfestacivilcasadoes_sel = AV56TFEstaCivilCasadoEs_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1749EstaCivilDescrip ,
                                           AV68Estados_civileswwds_4_tfestacivildescrip_sels ,
                                           A1751EstaCivilDescripFem ,
                                           AV70Estados_civileswwds_6_tfestacivildescripfem_sels ,
                                           A2093EstaCivilCodFor ,
                                           AV72Estados_civileswwds_8_tfestacivilcodfor_sels ,
                                           Short.valueOf(AV65Estados_civileswwds_1_tfestacivilcod) ,
                                           Short.valueOf(AV66Estados_civileswwds_2_tfestacivilcod_to) ,
                                           Integer.valueOf(AV68Estados_civileswwds_4_tfestacivildescrip_sels.size()) ,
                                           AV67Estados_civileswwds_3_tfestacivildescrip ,
                                           Integer.valueOf(AV70Estados_civileswwds_6_tfestacivildescripfem_sels.size()) ,
                                           AV69Estados_civileswwds_5_tfestacivildescripfem ,
                                           Integer.valueOf(AV72Estados_civileswwds_8_tfestacivilcodfor_sels.size()) ,
                                           AV71Estados_civileswwds_7_tfestacivilcodfor ,
                                           Byte.valueOf(AV73Estados_civileswwds_9_tfestacivilcasadoes_sel) ,
                                           Short.valueOf(A1748EstaCivilCod) ,
                                           Boolean.valueOf(A2272EstaCivilCasadoEs) ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV67Estados_civileswwds_3_tfestacivildescrip = GXutil.concat( GXutil.rtrim( AV67Estados_civileswwds_3_tfestacivildescrip), "%", "") ;
      lV69Estados_civileswwds_5_tfestacivildescripfem = GXutil.concat( GXutil.rtrim( AV69Estados_civileswwds_5_tfestacivildescripfem), "%", "") ;
      lV71Estados_civileswwds_7_tfestacivilcodfor = GXutil.padr( GXutil.rtrim( AV71Estados_civileswwds_7_tfestacivilcodfor), 20, "%") ;
      /* Using cursor P01K82 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV65Estados_civileswwds_1_tfestacivilcod), Short.valueOf(AV66Estados_civileswwds_2_tfestacivilcod_to), lV67Estados_civileswwds_3_tfestacivildescrip, lV69Estados_civileswwds_5_tfestacivildescripfem, lV71Estados_civileswwds_7_tfestacivilcodfor});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2272EstaCivilCasadoEs = P01K82_A2272EstaCivilCasadoEs[0] ;
         A2093EstaCivilCodFor = P01K82_A2093EstaCivilCodFor[0] ;
         A1751EstaCivilDescripFem = P01K82_A1751EstaCivilDescripFem[0] ;
         A1749EstaCivilDescrip = P01K82_A1749EstaCivilDescrip[0] ;
         A1748EstaCivilCod = P01K82_A1748EstaCivilCod[0] ;
         A1747EstaCivilPais = P01K82_A1747EstaCivilPais[0] ;
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
         AV74GXV5 = 1 ;
         while ( AV74GXV5 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV74GXV5));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EstaCivilCod") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1748EstaCivilCod );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EstaCivilPais") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1747EstaCivilPais );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EstaCivilDescrip") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1749EstaCivilDescrip, GXv_char7) ;
                  estados_civileswwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EstaCivilDescripFem") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1751EstaCivilDescripFem, GXv_char7) ;
                  estados_civileswwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EstaCivilCodFor") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A2093EstaCivilCodFor, GXv_char7) ;
                  estados_civileswwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EstaCivilCasadoEs") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A2272EstaCivilCasadoEs) );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV74GXV5 = (int)(AV74GXV5+1) ;
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
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EstaCivilCod", "", "Id.", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EstaCivilDescrip", "", "Descripciòn masculina", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EstaCivilDescripFem", "", "Descripciòn femenina", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EstaCivilCodFor", "", "Código en parámetros de fórmulas", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EstaCivilCasadoEs", "", "Deduce impuesto a las ganancias", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&VerSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      if ( ( ( AV75Paises.doubleValue() == ( 1 )) ) )
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
      if ( ( ( AV75Paises.doubleValue() == ( 1 )) ) )
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
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "Estados_civilesWWColumnsSelector", GXv_char7) ;
      estados_civileswwexport.this.GXt_char6 = GXv_char7[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("Estados_civilesWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "Estados_civilesWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("Estados_civilesWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV76GXV6 = 1 ;
      while ( AV76GXV6 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV76GXV6));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESTACIVILCOD") == 0 )
         {
            AV35TFEstaCivilCod = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV36TFEstaCivilCod_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESTACIVILDESCRIP") == 0 )
         {
            AV38TFEstaCivilDescrip = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESTACIVILDESCRIP_SEL") == 0 )
         {
            AV37TFEstaCivilDescrip_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV39TFEstaCivilDescrip_Sels.fromJSonString(AV37TFEstaCivilDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESTACIVILDESCRIPFEM") == 0 )
         {
            AV45TFEstaCivilDescripFem = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESTACIVILDESCRIPFEM_SEL") == 0 )
         {
            AV44TFEstaCivilDescripFem_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV46TFEstaCivilDescripFem_Sels.fromJSonString(AV44TFEstaCivilDescripFem_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESTACIVILCODFOR") == 0 )
         {
            AV53TFEstaCivilCodFor = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESTACIVILCODFOR_SEL") == 0 )
         {
            AV52TFEstaCivilCodFor_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV54TFEstaCivilCodFor_Sels.fromJSonString(AV52TFEstaCivilCodFor_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESTACIVILCASADOES_SEL") == 0 )
         {
            AV56TFEstaCivilCasadoEs_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV48MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV76GXV6 = (int)(AV76GXV6+1) ;
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
      this.aP0[0] = estados_civileswwexport.this.AV12Filename;
      this.aP1[0] = estados_civileswwexport.this.AV13ErrorMessage;
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
      AV59Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV39TFEstaCivilDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV40TFEstaCivilDescrip_Sel = "" ;
      AV38TFEstaCivilDescrip = "" ;
      AV46TFEstaCivilDescripFem_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV47TFEstaCivilDescripFem_Sel = "" ;
      AV45TFEstaCivilDescripFem = "" ;
      AV54TFEstaCivilCodFor_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV55TFEstaCivilCodFor_Sel = "" ;
      AV53TFEstaCivilCodFor = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1749EstaCivilDescrip = "" ;
      A1751EstaCivilDescripFem = "" ;
      A2093EstaCivilCodFor = "" ;
      AV67Estados_civileswwds_3_tfestacivildescrip = "" ;
      AV68Estados_civileswwds_4_tfestacivildescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV69Estados_civileswwds_5_tfestacivildescripfem = "" ;
      AV70Estados_civileswwds_6_tfestacivildescripfem_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV71Estados_civileswwds_7_tfestacivilcodfor = "" ;
      AV72Estados_civileswwds_8_tfestacivilcodfor_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV67Estados_civileswwds_3_tfestacivildescrip = "" ;
      lV69Estados_civileswwds_5_tfestacivildescripfem = "" ;
      lV71Estados_civileswwds_7_tfestacivilcodfor = "" ;
      P01K82_A2272EstaCivilCasadoEs = new boolean[] {false} ;
      P01K82_A2093EstaCivilCodFor = new String[] {""} ;
      P01K82_A1751EstaCivilDescripFem = new String[] {""} ;
      P01K82_A1749EstaCivilDescrip = new String[] {""} ;
      P01K82_A1748EstaCivilCod = new short[1] ;
      P01K82_A1747EstaCivilPais = new short[1] ;
      AV75Paises = DecimalUtil.ZERO ;
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV37TFEstaCivilDescrip_SelsJson = "" ;
      AV44TFEstaCivilDescripFem_SelsJson = "" ;
      AV52TFEstaCivilCodFor_SelsJson = "" ;
      AV48MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.estados_civileswwexport__default(),
         new Object[] {
             new Object[] {
            P01K82_A2272EstaCivilCasadoEs, P01K82_A2093EstaCivilCodFor, P01K82_A1751EstaCivilDescripFem, P01K82_A1749EstaCivilDescrip, P01K82_A1748EstaCivilCod, P01K82_A1747EstaCivilPais
            }
         }
      );
      AV59Pgmname = "Estados_civilesWWExport" ;
      /* GeneXus formulas. */
      AV59Pgmname = "Estados_civilesWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV56TFEstaCivilCasadoEs_Sel ;
   private byte AV73Estados_civileswwds_9_tfestacivilcasadoes_sel ;
   private short AV35TFEstaCivilCod ;
   private short AV36TFEstaCivilCod_To ;
   private short GXv_int5[] ;
   private short A1748EstaCivilCod ;
   private short A1747EstaCivilPais ;
   private short AV65Estados_civileswwds_1_tfestacivilcod ;
   private short AV66Estados_civileswwds_2_tfestacivilcod_to ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV60GXV1 ;
   private int AV61GXV2 ;
   private int AV62GXV3 ;
   private int AV63GXV4 ;
   private int AV68Estados_civileswwds_4_tfestacivildescrip_sels_size ;
   private int AV70Estados_civileswwds_6_tfestacivildescripfem_sels_size ;
   private int AV72Estados_civileswwds_8_tfestacivilcodfor_sels_size ;
   private int AV74GXV5 ;
   private int AV76GXV6 ;
   private long AV41i ;
   private long AV32VisibleColumnCount ;
   private java.math.BigDecimal AV75Paises ;
   private String AV59Pgmname ;
   private String AV55TFEstaCivilCodFor_Sel ;
   private String AV53TFEstaCivilCodFor ;
   private String A2093EstaCivilCodFor ;
   private String AV71Estados_civileswwds_7_tfestacivilcodfor ;
   private String scmdbuf ;
   private String lV71Estados_civileswwds_7_tfestacivilcodfor ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean A2272EstaCivilCasadoEs ;
   private boolean AV19OrderedDsc ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV37TFEstaCivilDescrip_SelsJson ;
   private String AV44TFEstaCivilDescripFem_SelsJson ;
   private String AV52TFEstaCivilCodFor_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV40TFEstaCivilDescrip_Sel ;
   private String AV38TFEstaCivilDescrip ;
   private String AV47TFEstaCivilDescripFem_Sel ;
   private String AV45TFEstaCivilDescripFem ;
   private String A1749EstaCivilDescrip ;
   private String A1751EstaCivilDescripFem ;
   private String AV67Estados_civileswwds_3_tfestacivildescrip ;
   private String AV69Estados_civileswwds_5_tfestacivildescripfem ;
   private String lV67Estados_civileswwds_3_tfestacivildescrip ;
   private String lV69Estados_civileswwds_5_tfestacivildescripfem ;
   private String AV48MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV54TFEstaCivilCodFor_Sels ;
   private GXSimpleCollection<String> AV39TFEstaCivilDescrip_Sels ;
   private GXSimpleCollection<String> AV46TFEstaCivilDescripFem_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private boolean[] P01K82_A2272EstaCivilCasadoEs ;
   private String[] P01K82_A2093EstaCivilCodFor ;
   private String[] P01K82_A1751EstaCivilDescripFem ;
   private String[] P01K82_A1749EstaCivilDescrip ;
   private short[] P01K82_A1748EstaCivilCod ;
   private short[] P01K82_A1747EstaCivilPais ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV72Estados_civileswwds_8_tfestacivilcodfor_sels ;
   private GXSimpleCollection<String> AV68Estados_civileswwds_4_tfestacivildescrip_sels ;
   private GXSimpleCollection<String> AV70Estados_civileswwds_6_tfestacivildescripfem_sels ;
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

final  class estados_civileswwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01K82( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1749EstaCivilDescrip ,
                                          GXSimpleCollection<String> AV68Estados_civileswwds_4_tfestacivildescrip_sels ,
                                          String A1751EstaCivilDescripFem ,
                                          GXSimpleCollection<String> AV70Estados_civileswwds_6_tfestacivildescripfem_sels ,
                                          String A2093EstaCivilCodFor ,
                                          GXSimpleCollection<String> AV72Estados_civileswwds_8_tfestacivilcodfor_sels ,
                                          short AV65Estados_civileswwds_1_tfestacivilcod ,
                                          short AV66Estados_civileswwds_2_tfestacivilcod_to ,
                                          int AV68Estados_civileswwds_4_tfestacivildescrip_sels_size ,
                                          String AV67Estados_civileswwds_3_tfestacivildescrip ,
                                          int AV70Estados_civileswwds_6_tfestacivildescripfem_sels_size ,
                                          String AV69Estados_civileswwds_5_tfestacivildescripfem ,
                                          int AV72Estados_civileswwds_8_tfestacivilcodfor_sels_size ,
                                          String AV71Estados_civileswwds_7_tfestacivilcodfor ,
                                          byte AV73Estados_civileswwds_9_tfestacivilcasadoes_sel ,
                                          short A1748EstaCivilCod ,
                                          boolean A2272EstaCivilCasadoEs ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[5];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT EstaCivilCasadoEs, EstaCivilCodFor, EstaCivilDescripFem, EstaCivilDescrip, EstaCivilCod, EstaCivilPais FROM Estados_civiles" ;
      if ( ! (0==AV65Estados_civileswwds_1_tfestacivilcod) )
      {
         addWhere(sWhereString, "(EstaCivilCod >= ?)");
      }
      else
      {
         GXv_int10[0] = (byte)(1) ;
      }
      if ( ! (0==AV66Estados_civileswwds_2_tfestacivilcod_to) )
      {
         addWhere(sWhereString, "(EstaCivilCod <= ?)");
      }
      else
      {
         GXv_int10[1] = (byte)(1) ;
      }
      if ( ( AV68Estados_civileswwds_4_tfestacivildescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV67Estados_civileswwds_3_tfestacivildescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(EstaCivilDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( AV68Estados_civileswwds_4_tfestacivildescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV68Estados_civileswwds_4_tfestacivildescrip_sels, "EstaCivilDescrip IN (", ")")+")");
      }
      if ( ( AV70Estados_civileswwds_6_tfestacivildescripfem_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV69Estados_civileswwds_5_tfestacivildescripfem)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(EstaCivilDescripFem) like LOWER(?))");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( AV70Estados_civileswwds_6_tfestacivildescripfem_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV70Estados_civileswwds_6_tfestacivildescripfem_sels, "EstaCivilDescripFem IN (", ")")+")");
      }
      if ( ( AV72Estados_civileswwds_8_tfestacivilcodfor_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV71Estados_civileswwds_7_tfestacivilcodfor)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(EstaCivilCodFor) like LOWER(?))");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( AV72Estados_civileswwds_8_tfestacivilcodfor_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV72Estados_civileswwds_8_tfestacivilcodfor_sels, "EstaCivilCodFor IN (", ")")+")");
      }
      if ( AV73Estados_civileswwds_9_tfestacivilcasadoes_sel == 1 )
      {
         addWhere(sWhereString, "(EstaCivilCasadoEs = TRUE)");
      }
      if ( AV73Estados_civileswwds_9_tfestacivilcasadoes_sel == 2 )
      {
         addWhere(sWhereString, "(EstaCivilCasadoEs = FALSE)");
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY EstaCivilCod" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EstaCivilCod DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY EstaCivilDescrip" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EstaCivilDescrip DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY EstaCivilDescripFem" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EstaCivilDescripFem DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY EstaCivilCodFor" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EstaCivilCodFor DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY EstaCivilCasadoEs" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EstaCivilCasadoEs DESC" ;
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
                  return conditional_P01K82(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , ((Number) dynConstraints[15]).shortValue() , ((Boolean) dynConstraints[16]).booleanValue() , ((Number) dynConstraints[17]).shortValue() , ((Boolean) dynConstraints[18]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01K82", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
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
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[6]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 30);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 30);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 20);
               }
               return;
      }
   }

}

