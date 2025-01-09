package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class tipo_obligacionwwexport extends GXProcedure
{
   public tipo_obligacionwwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( tipo_obligacionwwexport.class ), "" );
   }

   public tipo_obligacionwwexport( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      tipo_obligacionwwexport.this.aP1 = new String[] {""};
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
      tipo_obligacionwwexport.this.aP0 = aP0;
      tipo_obligacionwwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV53CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      tipo_obligacionwwexport.this.GXt_int1 = GXv_int2[0] ;
      AV53CliCod = GXt_int1 ;
      GXt_boolean3 = AV8IsAuthorized ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWtipo_obligacion", GXv_boolean4) ;
      tipo_obligacionwwexport.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV8IsAuthorized = GXt_boolean3 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV63Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "tipo_obligacionWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV37TFTipoOblCodigo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Código", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         tipo_obligacionwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV52i = 1 ;
         AV64GXV1 = 1 ;
         while ( AV64GXV1 <= AV37TFTipoOblCodigo_Sels.size() )
         {
            AV38TFTipoOblCodigo_Sel = (String)AV37TFTipoOblCodigo_Sels.elementAt(-1+AV64GXV1) ;
            if ( AV52i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFTipoOblCodigo_Sel, GXv_char9) ;
            tipo_obligacionwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV52i = (long)(AV52i+1) ;
            AV64GXV1 = (int)(AV64GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV36TFTipoOblCodigo)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Código", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            tipo_obligacionwwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV36TFTipoOblCodigo, GXv_char9) ;
            tipo_obligacionwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( ( AV41TFTipoOblDescrip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         tipo_obligacionwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV52i = 1 ;
         AV65GXV2 = 1 ;
         while ( AV65GXV2 <= AV41TFTipoOblDescrip_Sels.size() )
         {
            AV42TFTipoOblDescrip_Sel = (String)AV41TFTipoOblDescrip_Sels.elementAt(-1+AV65GXV2) ;
            if ( AV52i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFTipoOblDescrip_Sel, GXv_char9) ;
            tipo_obligacionwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV52i = (long)(AV52i+1) ;
            AV65GXV2 = (int)(AV65GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV40TFTipoOblDescrip)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            tipo_obligacionwwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFTipoOblDescrip, GXv_char9) ;
            tipo_obligacionwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( (0==AV43TFTipoOblAnti_Sel) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Es por anticipo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         tipo_obligacionwwexport.this.AV14CellRow = GXv_int7[0] ;
         if ( AV43TFTipoOblAnti_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV43TFTipoOblAnti_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( ( AV45TFTipoOblTotTipo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Total", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         tipo_obligacionwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV52i = 1 ;
         AV66GXV3 = 1 ;
         while ( AV66GXV3 <= AV45TFTipoOblTotTipo_Sels.size() )
         {
            AV46TFTipoOblTotTipo_Sel = ((Number) AV45TFTipoOblTotTipo_Sels.elementAt(-1+AV66GXV3)).byteValue() ;
            if ( AV52i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaintipo_total_embargo.getDescription(httpContext,(byte)AV46TFTipoOblTotTipo_Sel), "") );
            AV52i = (long)(AV52i+1) ;
            AV66GXV3 = (int)(AV66GXV3+1) ;
         }
      }
      if ( ! ( ( AV58TFEmbargaDescrip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Embargabilidad", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         tipo_obligacionwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV52i = 1 ;
         AV67GXV4 = 1 ;
         while ( AV67GXV4 <= AV58TFEmbargaDescrip_Sels.size() )
         {
            AV59TFEmbargaDescrip_Sel = (String)AV58TFEmbargaDescrip_Sels.elementAt(-1+AV67GXV4) ;
            if ( AV52i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV59TFEmbargaDescrip_Sel, GXv_char9) ;
            tipo_obligacionwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV52i = (long)(AV52i+1) ;
            AV67GXV4 = (int)(AV67GXV4+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV57TFEmbargaDescrip)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Embargabilidad", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            tipo_obligacionwwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV57TFEmbargaDescrip, GXv_char9) ;
            tipo_obligacionwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("tipo_obligacionWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("tipo_obligacionWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV68GXV5 = 1 ;
      while ( AV68GXV5 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV68GXV5));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV68GXV5 = (int)(AV68GXV5+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV70Tipo_obligacionwwds_1_tftipooblcodigo = AV36TFTipoOblCodigo ;
      AV71Tipo_obligacionwwds_2_tftipooblcodigo_sels = AV37TFTipoOblCodigo_Sels ;
      AV72Tipo_obligacionwwds_3_tftipoobldescrip = AV40TFTipoOblDescrip ;
      AV73Tipo_obligacionwwds_4_tftipoobldescrip_sels = AV41TFTipoOblDescrip_Sels ;
      AV74Tipo_obligacionwwds_5_tftipooblanti_sel = AV43TFTipoOblAnti_Sel ;
      AV75Tipo_obligacionwwds_6_tftipoobltottipo_sels = AV45TFTipoOblTotTipo_Sels ;
      AV76Tipo_obligacionwwds_7_tfembargadescrip = AV57TFEmbargaDescrip ;
      AV77Tipo_obligacionwwds_8_tfembargadescrip_sels = AV58TFEmbargaDescrip_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1164TipoOblCodigo ,
                                           AV71Tipo_obligacionwwds_2_tftipooblcodigo_sels ,
                                           A1165TipoOblDescrip ,
                                           AV73Tipo_obligacionwwds_4_tftipoobldescrip_sels ,
                                           Byte.valueOf(A1168TipoOblTotTipo) ,
                                           AV75Tipo_obligacionwwds_6_tftipoobltottipo_sels ,
                                           A1162EmbargaDescrip ,
                                           AV77Tipo_obligacionwwds_8_tfembargadescrip_sels ,
                                           Integer.valueOf(AV71Tipo_obligacionwwds_2_tftipooblcodigo_sels.size()) ,
                                           AV70Tipo_obligacionwwds_1_tftipooblcodigo ,
                                           Integer.valueOf(AV73Tipo_obligacionwwds_4_tftipoobldescrip_sels.size()) ,
                                           AV72Tipo_obligacionwwds_3_tftipoobldescrip ,
                                           Byte.valueOf(AV74Tipo_obligacionwwds_5_tftipooblanti_sel) ,
                                           Integer.valueOf(AV75Tipo_obligacionwwds_6_tftipoobltottipo_sels.size()) ,
                                           Integer.valueOf(AV77Tipo_obligacionwwds_8_tfembargadescrip_sels.size()) ,
                                           AV76Tipo_obligacionwwds_7_tfembargadescrip ,
                                           Short.valueOf(AV55PaiCod) ,
                                           Boolean.valueOf(A1167TipoOblAnti) ,
                                           Short.valueOf(A1159TipoOblPaiCod) ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV70Tipo_obligacionwwds_1_tftipooblcodigo = GXutil.padr( GXutil.rtrim( AV70Tipo_obligacionwwds_1_tftipooblcodigo), 20, "%") ;
      lV72Tipo_obligacionwwds_3_tftipoobldescrip = GXutil.concat( GXutil.rtrim( AV72Tipo_obligacionwwds_3_tftipoobldescrip), "%", "") ;
      lV76Tipo_obligacionwwds_7_tfembargadescrip = GXutil.concat( GXutil.rtrim( AV76Tipo_obligacionwwds_7_tfembargadescrip), "%", "") ;
      /* Using cursor P01IP2 */
      pr_default.execute(0, new Object[] {lV70Tipo_obligacionwwds_1_tftipooblcodigo, lV72Tipo_obligacionwwds_3_tftipoobldescrip, lV76Tipo_obligacionwwds_7_tfembargadescrip, Short.valueOf(AV55PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1161EmbargaSec = P01IP2_A1161EmbargaSec[0] ;
         n1161EmbargaSec = P01IP2_n1161EmbargaSec[0] ;
         A1159TipoOblPaiCod = P01IP2_A1159TipoOblPaiCod[0] ;
         A1162EmbargaDescrip = P01IP2_A1162EmbargaDescrip[0] ;
         A1168TipoOblTotTipo = P01IP2_A1168TipoOblTotTipo[0] ;
         A1167TipoOblAnti = P01IP2_A1167TipoOblAnti[0] ;
         A1165TipoOblDescrip = P01IP2_A1165TipoOblDescrip[0] ;
         A1164TipoOblCodigo = P01IP2_A1164TipoOblCodigo[0] ;
         A1163TipoOblSec = P01IP2_A1163TipoOblSec[0] ;
         A1162EmbargaDescrip = P01IP2_A1162EmbargaDescrip[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV32VisibleColumnCount = 0 ;
         AV78GXV6 = 1 ;
         while ( AV78GXV6 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV78GXV6));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "TipoOblCodigo") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1164TipoOblCodigo, GXv_char9) ;
                  tipo_obligacionwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "TipoOblDescrip") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1165TipoOblDescrip, GXv_char9) ;
                  tipo_obligacionwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "TipoOblAnti") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1167TipoOblAnti) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "TipoOblTotTipo") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaintipo_total_embargo.getDescription(httpContext,(byte)A1168TipoOblTotTipo), "") );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmbargaDescrip") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1162EmbargaDescrip, GXv_char9) ;
                  tipo_obligacionwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV78GXV6 = (int)(AV78GXV6+1) ;
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
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "TipoOblCodigo", "", "Código", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "TipoOblDescrip", "", "Descripción", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "TipoOblAnti", "", "Es por anticipo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "TipoOblTotTipo", "", "Total", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "EmbargaDescrip", "", "Embargabilidad", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&VerSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXt_char8 = AV28UserCustomValue ;
      GXv_char9[0] = GXt_char8 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "tipo_obligacionWWColumnsSelector", GXv_char9) ;
      tipo_obligacionwwexport.this.GXt_char8 = GXv_char9[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("tipo_obligacionWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "tipo_obligacionWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("tipo_obligacionWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV79GXV7 = 1 ;
      while ( AV79GXV7 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV79GXV7));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOOBLCODIGO") == 0 )
         {
            AV36TFTipoOblCodigo = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOOBLCODIGO_SEL") == 0 )
         {
            AV35TFTipoOblCodigo_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV37TFTipoOblCodigo_Sels.fromJSonString(AV35TFTipoOblCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOOBLDESCRIP") == 0 )
         {
            AV40TFTipoOblDescrip = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOOBLDESCRIP_SEL") == 0 )
         {
            AV39TFTipoOblDescrip_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV41TFTipoOblDescrip_Sels.fromJSonString(AV39TFTipoOblDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOOBLANTI_SEL") == 0 )
         {
            AV43TFTipoOblAnti_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOOBLTOTTIPO_SEL") == 0 )
         {
            AV44TFTipoOblTotTipo_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV45TFTipoOblTotTipo_Sels.fromJSonString(AV44TFTipoOblTotTipo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMBARGADESCRIP") == 0 )
         {
            AV57TFEmbargaDescrip = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMBARGADESCRIP_SEL") == 0 )
         {
            AV56TFEmbargaDescrip_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV58TFEmbargaDescrip_Sels.fromJSonString(AV56TFEmbargaDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV60MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV79GXV7 = (int)(AV79GXV7+1) ;
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
      this.aP0[0] = tipo_obligacionwwexport.this.AV12Filename;
      this.aP1[0] = tipo_obligacionwwexport.this.AV13ErrorMessage;
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
      AV63Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV37TFTipoOblCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38TFTipoOblCodigo_Sel = "" ;
      AV36TFTipoOblCodigo = "" ;
      AV41TFTipoOblDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42TFTipoOblDescrip_Sel = "" ;
      AV40TFTipoOblDescrip = "" ;
      AV45TFTipoOblTotTipo_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV58TFEmbargaDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV59TFEmbargaDescrip_Sel = "" ;
      AV57TFEmbargaDescrip = "" ;
      GXv_exceldoc6 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int7 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1164TipoOblCodigo = "" ;
      A1165TipoOblDescrip = "" ;
      A1162EmbargaDescrip = "" ;
      AV70Tipo_obligacionwwds_1_tftipooblcodigo = "" ;
      AV71Tipo_obligacionwwds_2_tftipooblcodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV72Tipo_obligacionwwds_3_tftipoobldescrip = "" ;
      AV73Tipo_obligacionwwds_4_tftipoobldescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV75Tipo_obligacionwwds_6_tftipoobltottipo_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV76Tipo_obligacionwwds_7_tfembargadescrip = "" ;
      AV77Tipo_obligacionwwds_8_tfembargadescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV70Tipo_obligacionwwds_1_tftipooblcodigo = "" ;
      lV72Tipo_obligacionwwds_3_tftipoobldescrip = "" ;
      lV76Tipo_obligacionwwds_7_tfembargadescrip = "" ;
      P01IP2_A1161EmbargaSec = new short[1] ;
      P01IP2_n1161EmbargaSec = new boolean[] {false} ;
      P01IP2_A1159TipoOblPaiCod = new short[1] ;
      P01IP2_A1162EmbargaDescrip = new String[] {""} ;
      P01IP2_A1168TipoOblTotTipo = new byte[1] ;
      P01IP2_A1167TipoOblAnti = new boolean[] {false} ;
      P01IP2_A1165TipoOblDescrip = new String[] {""} ;
      P01IP2_A1164TipoOblCodigo = new String[] {""} ;
      P01IP2_A1163TipoOblSec = new short[1] ;
      AV28UserCustomValue = "" ;
      GXt_char8 = "" ;
      GXv_char9 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector10 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector11 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV35TFTipoOblCodigo_SelsJson = "" ;
      AV39TFTipoOblDescrip_SelsJson = "" ;
      AV44TFTipoOblTotTipo_SelsJson = "" ;
      AV56TFEmbargaDescrip_SelsJson = "" ;
      AV60MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.tipo_obligacionwwexport__default(),
         new Object[] {
             new Object[] {
            P01IP2_A1161EmbargaSec, P01IP2_n1161EmbargaSec, P01IP2_A1159TipoOblPaiCod, P01IP2_A1162EmbargaDescrip, P01IP2_A1168TipoOblTotTipo, P01IP2_A1167TipoOblAnti, P01IP2_A1165TipoOblDescrip, P01IP2_A1164TipoOblCodigo, P01IP2_A1163TipoOblSec
            }
         }
      );
      AV63Pgmname = "tipo_obligacionWWExport" ;
      /* GeneXus formulas. */
      AV63Pgmname = "tipo_obligacionWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV43TFTipoOblAnti_Sel ;
   private byte AV46TFTipoOblTotTipo_Sel ;
   private byte A1168TipoOblTotTipo ;
   private byte AV74Tipo_obligacionwwds_5_tftipooblanti_sel ;
   private short GXv_int7[] ;
   private short AV55PaiCod ;
   private short A1159TipoOblPaiCod ;
   private short AV18OrderedBy ;
   private short A1161EmbargaSec ;
   private short A1163TipoOblSec ;
   private short Gx_err ;
   private int AV53CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV64GXV1 ;
   private int AV65GXV2 ;
   private int AV66GXV3 ;
   private int AV67GXV4 ;
   private int AV68GXV5 ;
   private int AV71Tipo_obligacionwwds_2_tftipooblcodigo_sels_size ;
   private int AV73Tipo_obligacionwwds_4_tftipoobldescrip_sels_size ;
   private int AV75Tipo_obligacionwwds_6_tftipoobltottipo_sels_size ;
   private int AV77Tipo_obligacionwwds_8_tfembargadescrip_sels_size ;
   private int AV78GXV6 ;
   private int AV79GXV7 ;
   private long AV52i ;
   private long AV32VisibleColumnCount ;
   private String AV63Pgmname ;
   private String AV38TFTipoOblCodigo_Sel ;
   private String AV36TFTipoOblCodigo ;
   private String A1164TipoOblCodigo ;
   private String AV70Tipo_obligacionwwds_1_tftipooblcodigo ;
   private String scmdbuf ;
   private String lV70Tipo_obligacionwwds_1_tftipooblcodigo ;
   private String GXt_char8 ;
   private String GXv_char9[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean3 ;
   private boolean GXv_boolean4[] ;
   private boolean returnInSub ;
   private boolean A1167TipoOblAnti ;
   private boolean AV19OrderedDsc ;
   private boolean n1161EmbargaSec ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV35TFTipoOblCodigo_SelsJson ;
   private String AV39TFTipoOblDescrip_SelsJson ;
   private String AV44TFTipoOblTotTipo_SelsJson ;
   private String AV56TFEmbargaDescrip_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV42TFTipoOblDescrip_Sel ;
   private String AV40TFTipoOblDescrip ;
   private String AV59TFEmbargaDescrip_Sel ;
   private String AV57TFEmbargaDescrip ;
   private String A1165TipoOblDescrip ;
   private String A1162EmbargaDescrip ;
   private String AV72Tipo_obligacionwwds_3_tftipoobldescrip ;
   private String AV76Tipo_obligacionwwds_7_tfembargadescrip ;
   private String lV72Tipo_obligacionwwds_3_tftipoobldescrip ;
   private String lV76Tipo_obligacionwwds_7_tfembargadescrip ;
   private String AV60MenuOpcCod ;
   private GXSimpleCollection<Byte> AV45TFTipoOblTotTipo_Sels ;
   private GXSimpleCollection<Byte> AV75Tipo_obligacionwwds_6_tftipoobltottipo_sels ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV37TFTipoOblCodigo_Sels ;
   private GXSimpleCollection<String> AV41TFTipoOblDescrip_Sels ;
   private GXSimpleCollection<String> AV58TFEmbargaDescrip_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P01IP2_A1161EmbargaSec ;
   private boolean[] P01IP2_n1161EmbargaSec ;
   private short[] P01IP2_A1159TipoOblPaiCod ;
   private String[] P01IP2_A1162EmbargaDescrip ;
   private byte[] P01IP2_A1168TipoOblTotTipo ;
   private boolean[] P01IP2_A1167TipoOblAnti ;
   private String[] P01IP2_A1165TipoOblDescrip ;
   private String[] P01IP2_A1164TipoOblCodigo ;
   private short[] P01IP2_A1163TipoOblSec ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc6[] ;
   private GXSimpleCollection<String> AV71Tipo_obligacionwwds_2_tftipooblcodigo_sels ;
   private GXSimpleCollection<String> AV73Tipo_obligacionwwds_4_tftipoobldescrip_sels ;
   private GXSimpleCollection<String> AV77Tipo_obligacionwwds_8_tfembargadescrip_sels ;
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

final  class tipo_obligacionwwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01IP2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1164TipoOblCodigo ,
                                          GXSimpleCollection<String> AV71Tipo_obligacionwwds_2_tftipooblcodigo_sels ,
                                          String A1165TipoOblDescrip ,
                                          GXSimpleCollection<String> AV73Tipo_obligacionwwds_4_tftipoobldescrip_sels ,
                                          byte A1168TipoOblTotTipo ,
                                          GXSimpleCollection<Byte> AV75Tipo_obligacionwwds_6_tftipoobltottipo_sels ,
                                          String A1162EmbargaDescrip ,
                                          GXSimpleCollection<String> AV77Tipo_obligacionwwds_8_tfembargadescrip_sels ,
                                          int AV71Tipo_obligacionwwds_2_tftipooblcodigo_sels_size ,
                                          String AV70Tipo_obligacionwwds_1_tftipooblcodigo ,
                                          int AV73Tipo_obligacionwwds_4_tftipoobldescrip_sels_size ,
                                          String AV72Tipo_obligacionwwds_3_tftipoobldescrip ,
                                          byte AV74Tipo_obligacionwwds_5_tftipooblanti_sel ,
                                          int AV75Tipo_obligacionwwds_6_tftipoobltottipo_sels_size ,
                                          int AV77Tipo_obligacionwwds_8_tfembargadescrip_sels_size ,
                                          String AV76Tipo_obligacionwwds_7_tfembargadescrip ,
                                          short AV55PaiCod ,
                                          boolean A1167TipoOblAnti ,
                                          short A1159TipoOblPaiCod ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int12 = new byte[4];
      Object[] GXv_Object13 = new Object[2];
      scmdbuf = "SELECT T1.EmbargaSec, T1.TipoOblPaiCod, T2.EmbargaDescrip, T1.TipoOblTotTipo, T1.TipoOblAnti, T1.TipoOblDescrip, T1.TipoOblCodigo, T1.TipoOblSec FROM (tipo_obligacion" ;
      scmdbuf += " T1 LEFT JOIN embargabilidad T2 ON T2.EmbargaSec = T1.EmbargaSec)" ;
      if ( ( AV71Tipo_obligacionwwds_2_tftipooblcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV70Tipo_obligacionwwds_1_tftipooblcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.TipoOblCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int12[0] = (byte)(1) ;
      }
      if ( AV71Tipo_obligacionwwds_2_tftipooblcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV71Tipo_obligacionwwds_2_tftipooblcodigo_sels, "T1.TipoOblCodigo IN (", ")")+")");
      }
      if ( ( AV73Tipo_obligacionwwds_4_tftipoobldescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV72Tipo_obligacionwwds_3_tftipoobldescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.TipoOblDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int12[1] = (byte)(1) ;
      }
      if ( AV73Tipo_obligacionwwds_4_tftipoobldescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV73Tipo_obligacionwwds_4_tftipoobldescrip_sels, "T1.TipoOblDescrip IN (", ")")+")");
      }
      if ( AV74Tipo_obligacionwwds_5_tftipooblanti_sel == 1 )
      {
         addWhere(sWhereString, "(T1.TipoOblAnti = TRUE)");
      }
      if ( AV74Tipo_obligacionwwds_5_tftipooblanti_sel == 2 )
      {
         addWhere(sWhereString, "(T1.TipoOblAnti = FALSE)");
      }
      if ( AV75Tipo_obligacionwwds_6_tftipoobltottipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV75Tipo_obligacionwwds_6_tftipoobltottipo_sels, "T1.TipoOblTotTipo IN (", ")")+")");
      }
      if ( ( AV77Tipo_obligacionwwds_8_tfembargadescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV76Tipo_obligacionwwds_7_tfembargadescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.EmbargaDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int12[2] = (byte)(1) ;
      }
      if ( AV77Tipo_obligacionwwds_8_tfembargadescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV77Tipo_obligacionwwds_8_tfembargadescrip_sels, "T2.EmbargaDescrip IN (", ")")+")");
      }
      if ( ! (0==AV55PaiCod) )
      {
         addWhere(sWhereString, "(T1.TipoOblPaiCod = ?)");
      }
      else
      {
         GXv_int12[3] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.TipoOblCodigo" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.TipoOblCodigo DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.TipoOblDescrip" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.TipoOblDescrip DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.TipoOblAnti" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.TipoOblAnti DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.TipoOblTotTipo" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.TipoOblTotTipo DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.EmbargaDescrip" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.EmbargaDescrip DESC" ;
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
                  return conditional_P01IP2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).byteValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).shortValue() , ((Boolean) dynConstraints[17]).booleanValue() , ((Number) dynConstraints[18]).shortValue() , ((Number) dynConstraints[19]).shortValue() , ((Boolean) dynConstraints[20]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01IP2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((byte[]) buf[4])[0] = rslt.getByte(4);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(5);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((short[]) buf[8])[0] = rslt.getShort(8);
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
                  stmt.setString(sIdx, (String)parms[4], 20);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 400);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 30);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               return;
      }
   }

}

