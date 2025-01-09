package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class condiciones_conceptowwexport extends GXProcedure
{
   public condiciones_conceptowwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( condiciones_conceptowwexport.class ), "" );
   }

   public condiciones_conceptowwexport( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      condiciones_conceptowwexport.this.aP1 = new String[] {""};
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
      condiciones_conceptowwexport.this.aP0 = aP0;
      condiciones_conceptowwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV45CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      condiciones_conceptowwexport.this.GXt_int1 = GXv_int2[0] ;
      AV45CliCod = GXt_int1 ;
      GXt_boolean3 = AV8IsAuthorized ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCondiciones_concepto", GXv_boolean4) ;
      condiciones_conceptowwexport.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV8IsAuthorized = GXt_boolean3 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV56Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext5[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext5) ;
         AV9WWPContext = GXv_SdtWWPContext5[0] ;
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
      AV12Filename = "Condiciones_conceptoWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV36TFConCondicion_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Id", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         condiciones_conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV44i = 1 ;
         AV57GXV1 = 1 ;
         while ( AV57GXV1 <= AV36TFConCondicion_Sels.size() )
         {
            AV37TFConCondicion_Sel = (String)AV36TFConCondicion_Sels.elementAt(-1+AV57GXV1) ;
            if ( AV44i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV37TFConCondicion_Sel, GXv_char9) ;
            condiciones_conceptowwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV44i = (long)(AV44i+1) ;
            AV57GXV1 = (int)(AV57GXV1+1) ;
         }
      }
      if ( ! ( (0==AV38TFCondicionPais) && (0==AV39TFCondicionPais_To) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "País", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         condiciones_conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV38TFCondicionPais );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         condiciones_conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV39TFCondicionPais_To );
      }
      if ( ! ( ( AV42TFCondicionDescrip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         condiciones_conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV44i = 1 ;
         AV58GXV2 = 1 ;
         while ( AV58GXV2 <= AV42TFCondicionDescrip_Sels.size() )
         {
            AV43TFCondicionDescrip_Sel = (String)AV42TFCondicionDescrip_Sels.elementAt(-1+AV58GXV2) ;
            if ( AV44i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV43TFCondicionDescrip_Sel, GXv_char9) ;
            condiciones_conceptowwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV44i = (long)(AV44i+1) ;
            AV58GXV2 = (int)(AV58GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV41TFCondicionDescrip)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            condiciones_conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV41TFCondicionDescrip, GXv_char9) ;
            condiciones_conceptowwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( (0==AV47TFCondLiqBasica_Sel) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Condición es compatible con liquidación básica", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         condiciones_conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
         if ( AV47TFCondLiqBasica_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV47TFCondLiqBasica_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( ( AV51TFCondSegPla_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( " Si no se cumple la condición, liquidar en segundo plano", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         condiciones_conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV44i = 1 ;
         AV59GXV3 = 1 ;
         while ( AV59GXV3 <= AV51TFCondSegPla_Sels.size() )
         {
            AV52TFCondSegPla_Sel = ((Number) AV51TFCondSegPla_Sels.elementAt(-1+AV59GXV3)).byteValue() ;
            if ( AV44i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaincondicion_segplano.getDescription(httpContext,(byte)AV52TFCondSegPla_Sel), "") );
            AV44i = (long)(AV44i+1) ;
            AV59GXV3 = (int)(AV59GXV3+1) ;
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("Condiciones_conceptoWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("Condiciones_conceptoWWColumnsSelector") ;
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
      AV60GXV4 = 1 ;
      while ( AV60GXV4 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV60GXV4));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV60GXV4 = (int)(AV60GXV4+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV62Condiciones_conceptowwds_1_tfconcondicion_sels = AV36TFConCondicion_Sels ;
      AV63Condiciones_conceptowwds_2_tfcondicionpais = AV38TFCondicionPais ;
      AV64Condiciones_conceptowwds_3_tfcondicionpais_to = AV39TFCondicionPais_To ;
      AV65Condiciones_conceptowwds_4_tfcondiciondescrip = AV41TFCondicionDescrip ;
      AV66Condiciones_conceptowwds_5_tfcondiciondescrip_sels = AV42TFCondicionDescrip_Sels ;
      AV67Condiciones_conceptowwds_6_tfcondliqbasica_sel = AV47TFCondLiqBasica_Sel ;
      AV68Condiciones_conceptowwds_7_tfcondsegpla_sels = AV51TFCondSegPla_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A953ConCondicion ,
                                           AV62Condiciones_conceptowwds_1_tfconcondicion_sels ,
                                           A1758CondicionDescrip ,
                                           AV66Condiciones_conceptowwds_5_tfcondiciondescrip_sels ,
                                           Byte.valueOf(A1786CondSegPla) ,
                                           AV68Condiciones_conceptowwds_7_tfcondsegpla_sels ,
                                           Integer.valueOf(AV62Condiciones_conceptowwds_1_tfconcondicion_sels.size()) ,
                                           Short.valueOf(AV63Condiciones_conceptowwds_2_tfcondicionpais) ,
                                           Short.valueOf(AV64Condiciones_conceptowwds_3_tfcondicionpais_to) ,
                                           Integer.valueOf(AV66Condiciones_conceptowwds_5_tfcondiciondescrip_sels.size()) ,
                                           AV65Condiciones_conceptowwds_4_tfcondiciondescrip ,
                                           Byte.valueOf(AV67Condiciones_conceptowwds_6_tfcondliqbasica_sel) ,
                                           Integer.valueOf(AV68Condiciones_conceptowwds_7_tfcondsegpla_sels.size()) ,
                                           Short.valueOf(A1757CondicionPais) ,
                                           Boolean.valueOf(A1779CondLiqBasica) ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV65Condiciones_conceptowwds_4_tfcondiciondescrip = GXutil.concat( GXutil.rtrim( AV65Condiciones_conceptowwds_4_tfcondiciondescrip), "%", "") ;
      /* Using cursor P01KT2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV63Condiciones_conceptowwds_2_tfcondicionpais), Short.valueOf(AV64Condiciones_conceptowwds_3_tfcondicionpais_to), lV65Condiciones_conceptowwds_4_tfcondiciondescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1786CondSegPla = P01KT2_A1786CondSegPla[0] ;
         A1779CondLiqBasica = P01KT2_A1779CondLiqBasica[0] ;
         A1758CondicionDescrip = P01KT2_A1758CondicionDescrip[0] ;
         A1757CondicionPais = P01KT2_A1757CondicionPais[0] ;
         A953ConCondicion = P01KT2_A953ConCondicion[0] ;
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
         AV69GXV5 = 1 ;
         while ( AV69GXV5 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV69GXV5));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConCondicion") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A953ConCondicion, GXv_char9) ;
                  condiciones_conceptowwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CondicionPais") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1757CondicionPais );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CondicionDescrip") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1758CondicionDescrip, GXv_char9) ;
                  condiciones_conceptowwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CondLiqBasica") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1779CondLiqBasica) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CondSegPla") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaincondicion_segplano.getDescription(httpContext,(byte)A1786CondSegPla), "") );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV69GXV5 = (int)(AV69GXV5+1) ;
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
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConCondicion", "", "Id", false, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "CondicionPais", "", "País", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "CondicionDescrip", "", "Descripción", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "CondLiqBasica", "", "Condición es compatible con liquidación básica", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "CondSegPla", "", " Si no se cumple la condición, liquidar en segundo plano", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&VerSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&ModificarSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&EliminarSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXt_char8 = AV28UserCustomValue ;
      GXv_char9[0] = GXt_char8 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "Condiciones_conceptoWWColumnsSelector", GXv_char9) ;
      condiciones_conceptowwexport.this.GXt_char8 = GXv_char9[0] ;
      AV28UserCustomValue = GXt_char8 ;
      if ( ! ( (GXutil.strcmp("", AV28UserCustomValue)==0) ) )
      {
         AV25ColumnsSelectorAux.fromxml(AV28UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector11[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, GXv_SdtWWPColumnsSelector11) ;
         AV25ColumnsSelectorAux = GXv_SdtWWPColumnsSelector10[0] ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("Condiciones_conceptoWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "Condiciones_conceptoWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("Condiciones_conceptoWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV70GXV6 = 1 ;
      while ( AV70GXV6 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV70GXV6));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCONDICION_SEL") == 0 )
         {
            AV35TFConCondicion_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV36TFConCondicion_Sels.fromJSonString(AV35TFConCondicion_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDICIONPAIS") == 0 )
         {
            AV38TFCondicionPais = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV39TFCondicionPais_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDICIONDESCRIP") == 0 )
         {
            AV41TFCondicionDescrip = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDICIONDESCRIP_SEL") == 0 )
         {
            AV40TFCondicionDescrip_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV42TFCondicionDescrip_Sels.fromJSonString(AV40TFCondicionDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDLIQBASICA_SEL") == 0 )
         {
            AV47TFCondLiqBasica_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDSEGPLA_SEL") == 0 )
         {
            AV50TFCondSegPla_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV51TFCondSegPla_Sels.fromJSonString(AV50TFCondSegPla_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV53MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV70GXV6 = (int)(AV70GXV6+1) ;
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
      this.aP0[0] = condiciones_conceptowwexport.this.AV12Filename;
      this.aP1[0] = condiciones_conceptowwexport.this.AV13ErrorMessage;
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
      GXv_int2 = new int[1] ;
      GXv_boolean4 = new boolean[1] ;
      AV56Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV36TFConCondicion_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV37TFConCondicion_Sel = "" ;
      AV42TFCondicionDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV43TFCondicionDescrip_Sel = "" ;
      AV41TFCondicionDescrip = "" ;
      AV51TFCondSegPla_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      GXv_exceldoc6 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int7 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A953ConCondicion = "" ;
      A1758CondicionDescrip = "" ;
      AV62Condiciones_conceptowwds_1_tfconcondicion_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV65Condiciones_conceptowwds_4_tfcondiciondescrip = "" ;
      AV66Condiciones_conceptowwds_5_tfcondiciondescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV68Condiciones_conceptowwds_7_tfcondsegpla_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      scmdbuf = "" ;
      lV65Condiciones_conceptowwds_4_tfcondiciondescrip = "" ;
      P01KT2_A1786CondSegPla = new byte[1] ;
      P01KT2_A1779CondLiqBasica = new boolean[] {false} ;
      P01KT2_A1758CondicionDescrip = new String[] {""} ;
      P01KT2_A1757CondicionPais = new short[1] ;
      P01KT2_A953ConCondicion = new String[] {""} ;
      AV28UserCustomValue = "" ;
      GXt_char8 = "" ;
      GXv_char9 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector10 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector11 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV35TFConCondicion_SelsJson = "" ;
      AV40TFCondicionDescrip_SelsJson = "" ;
      AV50TFCondSegPla_SelsJson = "" ;
      AV53MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.condiciones_conceptowwexport__default(),
         new Object[] {
             new Object[] {
            P01KT2_A1786CondSegPla, P01KT2_A1779CondLiqBasica, P01KT2_A1758CondicionDescrip, P01KT2_A1757CondicionPais, P01KT2_A953ConCondicion
            }
         }
      );
      AV56Pgmname = "Condiciones_conceptoWWExport" ;
      /* GeneXus formulas. */
      AV56Pgmname = "Condiciones_conceptoWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV47TFCondLiqBasica_Sel ;
   private byte AV52TFCondSegPla_Sel ;
   private byte A1786CondSegPla ;
   private byte AV67Condiciones_conceptowwds_6_tfcondliqbasica_sel ;
   private short AV38TFCondicionPais ;
   private short AV39TFCondicionPais_To ;
   private short GXv_int7[] ;
   private short A1757CondicionPais ;
   private short AV63Condiciones_conceptowwds_2_tfcondicionpais ;
   private short AV64Condiciones_conceptowwds_3_tfcondicionpais_to ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV45CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV57GXV1 ;
   private int AV58GXV2 ;
   private int AV59GXV3 ;
   private int AV60GXV4 ;
   private int AV62Condiciones_conceptowwds_1_tfconcondicion_sels_size ;
   private int AV66Condiciones_conceptowwds_5_tfcondiciondescrip_sels_size ;
   private int AV68Condiciones_conceptowwds_7_tfcondsegpla_sels_size ;
   private int AV69GXV5 ;
   private int AV70GXV6 ;
   private long AV44i ;
   private long AV32VisibleColumnCount ;
   private String AV56Pgmname ;
   private String AV37TFConCondicion_Sel ;
   private String A953ConCondicion ;
   private String scmdbuf ;
   private String GXt_char8 ;
   private String GXv_char9[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean3 ;
   private boolean GXv_boolean4[] ;
   private boolean returnInSub ;
   private boolean A1779CondLiqBasica ;
   private boolean AV19OrderedDsc ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV35TFConCondicion_SelsJson ;
   private String AV40TFCondicionDescrip_SelsJson ;
   private String AV50TFCondSegPla_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV43TFCondicionDescrip_Sel ;
   private String AV41TFCondicionDescrip ;
   private String A1758CondicionDescrip ;
   private String AV65Condiciones_conceptowwds_4_tfcondiciondescrip ;
   private String lV65Condiciones_conceptowwds_4_tfcondiciondescrip ;
   private String AV53MenuOpcCod ;
   private GXSimpleCollection<Byte> AV51TFCondSegPla_Sels ;
   private GXSimpleCollection<Byte> AV68Condiciones_conceptowwds_7_tfcondsegpla_sels ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV36TFConCondicion_Sels ;
   private GXSimpleCollection<String> AV42TFCondicionDescrip_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private byte[] P01KT2_A1786CondSegPla ;
   private boolean[] P01KT2_A1779CondLiqBasica ;
   private String[] P01KT2_A1758CondicionDescrip ;
   private short[] P01KT2_A1757CondicionPais ;
   private String[] P01KT2_A953ConCondicion ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc6[] ;
   private GXSimpleCollection<String> AV62Condiciones_conceptowwds_1_tfconcondicion_sels ;
   private GXSimpleCollection<String> AV66Condiciones_conceptowwds_5_tfcondiciondescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV24ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector10[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector11[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV26ColumnsSelector_Column ;
}

final  class condiciones_conceptowwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01KT2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A953ConCondicion ,
                                          GXSimpleCollection<String> AV62Condiciones_conceptowwds_1_tfconcondicion_sels ,
                                          String A1758CondicionDescrip ,
                                          GXSimpleCollection<String> AV66Condiciones_conceptowwds_5_tfcondiciondescrip_sels ,
                                          byte A1786CondSegPla ,
                                          GXSimpleCollection<Byte> AV68Condiciones_conceptowwds_7_tfcondsegpla_sels ,
                                          int AV62Condiciones_conceptowwds_1_tfconcondicion_sels_size ,
                                          short AV63Condiciones_conceptowwds_2_tfcondicionpais ,
                                          short AV64Condiciones_conceptowwds_3_tfcondicionpais_to ,
                                          int AV66Condiciones_conceptowwds_5_tfcondiciondescrip_sels_size ,
                                          String AV65Condiciones_conceptowwds_4_tfcondiciondescrip ,
                                          byte AV67Condiciones_conceptowwds_6_tfcondliqbasica_sel ,
                                          int AV68Condiciones_conceptowwds_7_tfcondsegpla_sels_size ,
                                          short A1757CondicionPais ,
                                          boolean A1779CondLiqBasica ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int12 = new byte[3];
      Object[] GXv_Object13 = new Object[2];
      scmdbuf = "SELECT CondSegPla, CondLiqBasica, CondicionDescrip, CondicionPais, ConCondicion FROM Condiciones_concepto" ;
      if ( AV62Condiciones_conceptowwds_1_tfconcondicion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV62Condiciones_conceptowwds_1_tfconcondicion_sels, "ConCondicion IN (", ")")+")");
      }
      if ( ! (0==AV63Condiciones_conceptowwds_2_tfcondicionpais) )
      {
         addWhere(sWhereString, "(CondicionPais >= ?)");
      }
      else
      {
         GXv_int12[0] = (byte)(1) ;
      }
      if ( ! (0==AV64Condiciones_conceptowwds_3_tfcondicionpais_to) )
      {
         addWhere(sWhereString, "(CondicionPais <= ?)");
      }
      else
      {
         GXv_int12[1] = (byte)(1) ;
      }
      if ( ( AV66Condiciones_conceptowwds_5_tfcondiciondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV65Condiciones_conceptowwds_4_tfcondiciondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CondicionDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int12[2] = (byte)(1) ;
      }
      if ( AV66Condiciones_conceptowwds_5_tfcondiciondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV66Condiciones_conceptowwds_5_tfcondiciondescrip_sels, "CondicionDescrip IN (", ")")+")");
      }
      if ( AV67Condiciones_conceptowwds_6_tfcondliqbasica_sel == 1 )
      {
         addWhere(sWhereString, "(CondLiqBasica = TRUE)");
      }
      if ( AV67Condiciones_conceptowwds_6_tfcondliqbasica_sel == 2 )
      {
         addWhere(sWhereString, "(CondLiqBasica = FALSE)");
      }
      if ( AV68Condiciones_conceptowwds_7_tfcondsegpla_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV68Condiciones_conceptowwds_7_tfcondsegpla_sels, "CondSegPla IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConCondicion" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConCondicion DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CondicionPais" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CondicionPais DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CondicionDescrip" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CondicionDescrip DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CondLiqBasica" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CondLiqBasica DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CondSegPla" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CondSegPla DESC" ;
      }
      GXv_Object13[0] = scmdbuf ;
      GXv_Object13[1] = GXv_int12 ;
      return GXv_Object13 ;
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
                  return conditional_P01KT2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] , ((Number) dynConstraints[11]).byteValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).shortValue() , ((Boolean) dynConstraints[14]).booleanValue() , ((Number) dynConstraints[15]).shortValue() , ((Boolean) dynConstraints[16]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01KT2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
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
                  stmt.setShort(sIdx, ((Number) parms[3]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[4]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 400);
               }
               return;
      }
   }

}

