package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class sexoswwexport extends GXProcedure
{
   public sexoswwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( sexoswwexport.class ), "" );
   }

   public sexoswwexport( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      sexoswwexport.this.aP1 = new String[] {""};
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
      sexoswwexport.this.aP0 = aP0;
      sexoswwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSexos", GXv_boolean2) ;
      sexoswwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV60Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "SexosWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( (0==AV35TFSexoId) && (0==AV36TFSexoId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Id", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         sexoswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV35TFSexoId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         sexoswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV36TFSexoId_To );
      }
      if ( ! ( ( AV39TFSexoNombre_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Nombre", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         sexoswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV47i = 1 ;
         AV61GXV1 = 1 ;
         while ( AV61GXV1 <= AV39TFSexoNombre_Sels.size() )
         {
            AV40TFSexoNombre_Sel = (String)AV39TFSexoNombre_Sels.elementAt(-1+AV61GXV1) ;
            if ( AV47i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFSexoNombre_Sel, GXv_char7) ;
            sexoswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV47i = (long)(AV47i+1) ;
            AV61GXV1 = (int)(AV61GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV38TFSexoNombre)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Nombre", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            sexoswwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFSexoNombre, GXv_char7) ;
            sexoswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV42TFSexoBiologico_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Biologico", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         sexoswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV47i = 1 ;
         AV62GXV2 = 1 ;
         while ( AV62GXV2 <= AV42TFSexoBiologico_Sels.size() )
         {
            AV43TFSexoBiologico_Sel = (String)AV42TFSexoBiologico_Sels.elementAt(-1+AV62GXV2) ;
            if ( AV47i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainsexo_biologico.getDescription(httpContext,(String)AV43TFSexoBiologico_Sel), "") );
            AV47i = (long)(AV47i+1) ;
            AV62GXV2 = (int)(AV62GXV2+1) ;
         }
      }
      if ( ! ( ( AV45TFSexoIdentidad_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Identidad", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         sexoswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV47i = 1 ;
         AV63GXV3 = 1 ;
         while ( AV63GXV3 <= AV45TFSexoIdentidad_Sels.size() )
         {
            AV46TFSexoIdentidad_Sel = (String)AV45TFSexoIdentidad_Sels.elementAt(-1+AV63GXV3) ;
            if ( AV47i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainsexo_biologico.getDescription(httpContext,(String)AV46TFSexoIdentidad_Sel), "") );
            AV47i = (long)(AV47i+1) ;
            AV63GXV3 = (int)(AV63GXV3+1) ;
         }
      }
      if ( ! ( ( AV56TFSexoCodFor_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Código como parámetro de cálculos en fórmulas", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         sexoswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV47i = 1 ;
         AV64GXV4 = 1 ;
         while ( AV64GXV4 <= AV56TFSexoCodFor_Sels.size() )
         {
            AV57TFSexoCodFor_Sel = (String)AV56TFSexoCodFor_Sels.elementAt(-1+AV64GXV4) ;
            if ( AV47i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV57TFSexoCodFor_Sel, GXv_char7) ;
            sexoswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV47i = (long)(AV47i+1) ;
            AV64GXV4 = (int)(AV64GXV4+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV55TFSexoCodFor)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Código como parámetro de cálculos en fórmulas", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            sexoswwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV55TFSexoCodFor, GXv_char7) ;
            sexoswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("SexosWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("SexosWWColumnsSelector") ;
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
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Columnname( "SexoPaiCod" );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Displayname( httpContext.getMessage( "Pai Cod", "") );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Order( (short)(AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size()+1) );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().add(AV26ColumnsSelector_Column, 0);
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV65GXV5 = 1 ;
      while ( AV65GXV5 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV65GXV5));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV65GXV5 = (int)(AV65GXV5+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV67Sexoswwds_1_tfsexoid = AV35TFSexoId ;
      AV68Sexoswwds_2_tfsexoid_to = AV36TFSexoId_To ;
      AV69Sexoswwds_3_tfsexonombre = AV38TFSexoNombre ;
      AV70Sexoswwds_4_tfsexonombre_sels = AV39TFSexoNombre_Sels ;
      AV71Sexoswwds_5_tfsexobiologico_sels = AV42TFSexoBiologico_Sels ;
      AV72Sexoswwds_6_tfsexoidentidad_sels = AV45TFSexoIdentidad_Sels ;
      AV73Sexoswwds_7_tfsexocodfor = AV55TFSexoCodFor ;
      AV74Sexoswwds_8_tfsexocodfor_sels = AV56TFSexoCodFor_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1744SexoNombre ,
                                           AV70Sexoswwds_4_tfsexonombre_sels ,
                                           A1745SexoBiologico ,
                                           AV71Sexoswwds_5_tfsexobiologico_sels ,
                                           A1746SexoIdentidad ,
                                           AV72Sexoswwds_6_tfsexoidentidad_sels ,
                                           A2092SexoCodFor ,
                                           AV74Sexoswwds_8_tfsexocodfor_sels ,
                                           Byte.valueOf(AV67Sexoswwds_1_tfsexoid) ,
                                           Byte.valueOf(AV68Sexoswwds_2_tfsexoid_to) ,
                                           Integer.valueOf(AV70Sexoswwds_4_tfsexonombre_sels.size()) ,
                                           AV69Sexoswwds_3_tfsexonombre ,
                                           Integer.valueOf(AV71Sexoswwds_5_tfsexobiologico_sels.size()) ,
                                           Integer.valueOf(AV72Sexoswwds_6_tfsexoidentidad_sels.size()) ,
                                           Integer.valueOf(AV74Sexoswwds_8_tfsexocodfor_sels.size()) ,
                                           AV73Sexoswwds_7_tfsexocodfor ,
                                           Byte.valueOf(A1743SexoId) ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV69Sexoswwds_3_tfsexonombre = GXutil.concat( GXutil.rtrim( AV69Sexoswwds_3_tfsexonombre), "%", "") ;
      lV73Sexoswwds_7_tfsexocodfor = GXutil.padr( GXutil.rtrim( AV73Sexoswwds_7_tfsexocodfor), 20, "%") ;
      /* Using cursor P01K52 */
      pr_default.execute(0, new Object[] {Byte.valueOf(AV67Sexoswwds_1_tfsexoid), Byte.valueOf(AV68Sexoswwds_2_tfsexoid_to), lV69Sexoswwds_3_tfsexonombre, lV73Sexoswwds_7_tfsexocodfor});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2092SexoCodFor = P01K52_A2092SexoCodFor[0] ;
         A1746SexoIdentidad = P01K52_A1746SexoIdentidad[0] ;
         A1745SexoBiologico = P01K52_A1745SexoBiologico[0] ;
         n1745SexoBiologico = P01K52_n1745SexoBiologico[0] ;
         A1744SexoNombre = P01K52_A1744SexoNombre[0] ;
         A1743SexoId = P01K52_A1743SexoId[0] ;
         A1742SexoPaiCod = P01K52_A1742SexoPaiCod[0] ;
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
         AV75GXV6 = 1 ;
         while ( AV75GXV6 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV75GXV6));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SexoId") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1743SexoId );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SexoPaiCod") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1742SexoPaiCod );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SexoNombre") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1744SexoNombre, GXv_char7) ;
                  sexoswwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SexoBiologico") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainsexo_biologico.getDescription(httpContext,(String)A1745SexoBiologico), "") );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SexoIdentidad") == 0 )
               {
                  if ( ! (GXutil.strcmp("", A1746SexoIdentidad)==0) )
                  {
                     AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainsexo_biologico.getDescription(httpContext,(String)A1746SexoIdentidad), "") );
                  }
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SexoCodFor") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A2092SexoCodFor, GXv_char7) ;
                  sexoswwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV75GXV6 = (int)(AV75GXV6+1) ;
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
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SexoId", "", "Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SexoNombre", "", "Nombre", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SexoBiologico", "", "Biologico", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SexoIdentidad", "", "Identidad", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SexoCodFor", "", "Código como parámetro de cálculos en fórmulas", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&VerSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      if ( ( ( AV76Paises.doubleValue() == ( 1 )) ) )
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
      if ( ( ( AV76Paises.doubleValue() == ( 1 )) ) )
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
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "SexosWWColumnsSelector", GXv_char7) ;
      sexoswwexport.this.GXt_char6 = GXv_char7[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("SexosWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "SexosWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("SexosWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV77GXV7 = 1 ;
      while ( AV77GXV7 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV77GXV7));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEXOID") == 0 )
         {
            AV35TFSexoId = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV36TFSexoId_To = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEXONOMBRE") == 0 )
         {
            AV38TFSexoNombre = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEXONOMBRE_SEL") == 0 )
         {
            AV37TFSexoNombre_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV39TFSexoNombre_Sels.fromJSonString(AV37TFSexoNombre_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEXOBIOLOGICO_SEL") == 0 )
         {
            AV41TFSexoBiologico_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV42TFSexoBiologico_Sels.fromJSonString(AV41TFSexoBiologico_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEXOIDENTIDAD_SEL") == 0 )
         {
            AV44TFSexoIdentidad_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV45TFSexoIdentidad_Sels.fromJSonString(AV44TFSexoIdentidad_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEXOCODFOR") == 0 )
         {
            AV55TFSexoCodFor = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEXOCODFOR_SEL") == 0 )
         {
            AV54TFSexoCodFor_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV56TFSexoCodFor_Sels.fromJSonString(AV54TFSexoCodFor_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV50MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV77GXV7 = (int)(AV77GXV7+1) ;
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
      this.aP0[0] = sexoswwexport.this.AV12Filename;
      this.aP1[0] = sexoswwexport.this.AV13ErrorMessage;
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
      AV60Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV39TFSexoNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV40TFSexoNombre_Sel = "" ;
      AV38TFSexoNombre = "" ;
      AV42TFSexoBiologico_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV43TFSexoBiologico_Sel = "" ;
      AV45TFSexoIdentidad_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV46TFSexoIdentidad_Sel = "" ;
      AV56TFSexoCodFor_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV57TFSexoCodFor_Sel = "" ;
      AV55TFSexoCodFor = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1744SexoNombre = "" ;
      A1745SexoBiologico = "" ;
      A1746SexoIdentidad = "" ;
      A2092SexoCodFor = "" ;
      AV69Sexoswwds_3_tfsexonombre = "" ;
      AV70Sexoswwds_4_tfsexonombre_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV71Sexoswwds_5_tfsexobiologico_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV72Sexoswwds_6_tfsexoidentidad_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV73Sexoswwds_7_tfsexocodfor = "" ;
      AV74Sexoswwds_8_tfsexocodfor_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV69Sexoswwds_3_tfsexonombre = "" ;
      lV73Sexoswwds_7_tfsexocodfor = "" ;
      P01K52_A2092SexoCodFor = new String[] {""} ;
      P01K52_A1746SexoIdentidad = new String[] {""} ;
      P01K52_A1745SexoBiologico = new String[] {""} ;
      P01K52_n1745SexoBiologico = new boolean[] {false} ;
      P01K52_A1744SexoNombre = new String[] {""} ;
      P01K52_A1743SexoId = new byte[1] ;
      P01K52_A1742SexoPaiCod = new short[1] ;
      AV76Paises = DecimalUtil.ZERO ;
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV37TFSexoNombre_SelsJson = "" ;
      AV41TFSexoBiologico_SelsJson = "" ;
      AV44TFSexoIdentidad_SelsJson = "" ;
      AV54TFSexoCodFor_SelsJson = "" ;
      AV50MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.sexoswwexport__default(),
         new Object[] {
             new Object[] {
            P01K52_A2092SexoCodFor, P01K52_A1746SexoIdentidad, P01K52_A1745SexoBiologico, P01K52_n1745SexoBiologico, P01K52_A1744SexoNombre, P01K52_A1743SexoId, P01K52_A1742SexoPaiCod
            }
         }
      );
      AV60Pgmname = "SexosWWExport" ;
      /* GeneXus formulas. */
      AV60Pgmname = "SexosWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV35TFSexoId ;
   private byte AV36TFSexoId_To ;
   private byte A1743SexoId ;
   private byte AV67Sexoswwds_1_tfsexoid ;
   private byte AV68Sexoswwds_2_tfsexoid_to ;
   private short GXv_int5[] ;
   private short A1742SexoPaiCod ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV61GXV1 ;
   private int AV62GXV2 ;
   private int AV63GXV3 ;
   private int AV64GXV4 ;
   private int AV65GXV5 ;
   private int AV70Sexoswwds_4_tfsexonombre_sels_size ;
   private int AV71Sexoswwds_5_tfsexobiologico_sels_size ;
   private int AV72Sexoswwds_6_tfsexoidentidad_sels_size ;
   private int AV74Sexoswwds_8_tfsexocodfor_sels_size ;
   private int AV75GXV6 ;
   private int AV77GXV7 ;
   private long AV47i ;
   private long AV32VisibleColumnCount ;
   private java.math.BigDecimal AV76Paises ;
   private String AV60Pgmname ;
   private String AV43TFSexoBiologico_Sel ;
   private String AV46TFSexoIdentidad_Sel ;
   private String AV57TFSexoCodFor_Sel ;
   private String AV55TFSexoCodFor ;
   private String A1745SexoBiologico ;
   private String A1746SexoIdentidad ;
   private String A2092SexoCodFor ;
   private String AV73Sexoswwds_7_tfsexocodfor ;
   private String scmdbuf ;
   private String lV73Sexoswwds_7_tfsexocodfor ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV19OrderedDsc ;
   private boolean n1745SexoBiologico ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV37TFSexoNombre_SelsJson ;
   private String AV41TFSexoBiologico_SelsJson ;
   private String AV44TFSexoIdentidad_SelsJson ;
   private String AV54TFSexoCodFor_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV40TFSexoNombre_Sel ;
   private String AV38TFSexoNombre ;
   private String A1744SexoNombre ;
   private String AV69Sexoswwds_3_tfsexonombre ;
   private String lV69Sexoswwds_3_tfsexonombre ;
   private String AV50MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV42TFSexoBiologico_Sels ;
   private GXSimpleCollection<String> AV45TFSexoIdentidad_Sels ;
   private GXSimpleCollection<String> AV56TFSexoCodFor_Sels ;
   private GXSimpleCollection<String> AV39TFSexoNombre_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P01K52_A2092SexoCodFor ;
   private String[] P01K52_A1746SexoIdentidad ;
   private String[] P01K52_A1745SexoBiologico ;
   private boolean[] P01K52_n1745SexoBiologico ;
   private String[] P01K52_A1744SexoNombre ;
   private byte[] P01K52_A1743SexoId ;
   private short[] P01K52_A1742SexoPaiCod ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV71Sexoswwds_5_tfsexobiologico_sels ;
   private GXSimpleCollection<String> AV72Sexoswwds_6_tfsexoidentidad_sels ;
   private GXSimpleCollection<String> AV74Sexoswwds_8_tfsexocodfor_sels ;
   private GXSimpleCollection<String> AV70Sexoswwds_4_tfsexonombre_sels ;
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

final  class sexoswwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01K52( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1744SexoNombre ,
                                          GXSimpleCollection<String> AV70Sexoswwds_4_tfsexonombre_sels ,
                                          String A1745SexoBiologico ,
                                          GXSimpleCollection<String> AV71Sexoswwds_5_tfsexobiologico_sels ,
                                          String A1746SexoIdentidad ,
                                          GXSimpleCollection<String> AV72Sexoswwds_6_tfsexoidentidad_sels ,
                                          String A2092SexoCodFor ,
                                          GXSimpleCollection<String> AV74Sexoswwds_8_tfsexocodfor_sels ,
                                          byte AV67Sexoswwds_1_tfsexoid ,
                                          byte AV68Sexoswwds_2_tfsexoid_to ,
                                          int AV70Sexoswwds_4_tfsexonombre_sels_size ,
                                          String AV69Sexoswwds_3_tfsexonombre ,
                                          int AV71Sexoswwds_5_tfsexobiologico_sels_size ,
                                          int AV72Sexoswwds_6_tfsexoidentidad_sels_size ,
                                          int AV74Sexoswwds_8_tfsexocodfor_sels_size ,
                                          String AV73Sexoswwds_7_tfsexocodfor ,
                                          byte A1743SexoId ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[4];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT SexoCodFor, SexoIdentidad, SexoBiologico, SexoNombre, SexoId, SexoPaiCod FROM Sexos" ;
      if ( ! (0==AV67Sexoswwds_1_tfsexoid) )
      {
         addWhere(sWhereString, "(SexoId >= ?)");
      }
      else
      {
         GXv_int10[0] = (byte)(1) ;
      }
      if ( ! (0==AV68Sexoswwds_2_tfsexoid_to) )
      {
         addWhere(sWhereString, "(SexoId <= ?)");
      }
      else
      {
         GXv_int10[1] = (byte)(1) ;
      }
      if ( ( AV70Sexoswwds_4_tfsexonombre_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV69Sexoswwds_3_tfsexonombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SexoNombre) like LOWER(?))");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( AV70Sexoswwds_4_tfsexonombre_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV70Sexoswwds_4_tfsexonombre_sels, "SexoNombre IN (", ")")+")");
      }
      if ( AV71Sexoswwds_5_tfsexobiologico_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV71Sexoswwds_5_tfsexobiologico_sels, "SexoBiologico IN (", ")")+")");
      }
      if ( AV72Sexoswwds_6_tfsexoidentidad_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV72Sexoswwds_6_tfsexoidentidad_sels, "SexoIdentidad IN (", ")")+")");
      }
      if ( ( AV74Sexoswwds_8_tfsexocodfor_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV73Sexoswwds_7_tfsexocodfor)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SexoCodFor) like LOWER(?))");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( AV74Sexoswwds_8_tfsexocodfor_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV74Sexoswwds_8_tfsexocodfor_sels, "SexoCodFor IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY SexoId" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SexoId DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY SexoNombre" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SexoNombre DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY SexoBiologico" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SexoBiologico DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY SexoIdentidad" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SexoIdentidad DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY SexoCodFor" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SexoCodFor DESC" ;
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
                  return conditional_P01K52(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).byteValue() , ((Number) dynConstraints[9]).byteValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).byteValue() , ((Number) dynConstraints[17]).shortValue() , ((Boolean) dynConstraints[18]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01K52", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               ((byte[]) buf[5])[0] = rslt.getByte(5);
               ((short[]) buf[6])[0] = rslt.getShort(6);
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
                  stmt.setByte(sIdx, ((Number) parms[4]).byteValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[5]).byteValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 30);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[7], 20);
               }
               return;
      }
   }

}

