package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtNovedadEventos extends GxSilentTrnSdt
{
   public SdtNovedadEventos( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtNovedadEventos.class));
   }

   public SdtNovedadEventos( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle, context, "SdtNovedadEventos");
      initialize( remoteHandle) ;
   }

   public SdtNovedadEventos( int remoteHandle ,
                             StructSdtNovedadEventos struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public void Load( int AV3CliCod ,
                     short AV1EmpCod ,
                     int AV6LegNumero ,
                     java.util.Date AV76LegLicenIni )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV3CliCod),Short.valueOf(AV1EmpCod),Integer.valueOf(AV6LegNumero),AV76LegLicenIni});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CliCod", int.class}, new Object[]{"EmpCod", short.class}, new Object[]{"LegNumero", int.class}, new Object[]{"LegLicenIni", java.util.Date.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "NovedadEventos");
      metadata.set("BT", "LegajoLicencias");
      metadata.set("PK", "[ \"CliCod\",\"EmpCod\",\"LegNumero\",\"LegLicenIni\" ]");
      metadata.set("PKAssigned", "[ \"CliCod\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\",\"EmpCod\",\"LegNumero\" ],\"FKMap\":[  ] },{ \"FK\":[ \"SitCodigo\" ],\"FKMap\":[ \"LegLicSitCodigo-SitCodigo\" ] } ]");
      metadata.set("AllowInsert", "True");
      metadata.set("AllowUpdate", "True");
      metadata.set("AllowDelete", "True");
      return metadata ;
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod") )
            {
               gxTv_SdtNovedadEventos_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod") )
            {
               gxTv_SdtNovedadEventos_Empcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNumero") )
            {
               gxTv_SdtNovedadEventos_Legnumero = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicenIni") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtNovedadEventos_Leglicenini = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtNovedadEventos_Leglicenini = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicenFin") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtNovedadEventos_Leglicenfin = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtNovedadEventos_Leglicenfin = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicSitCodigo") )
            {
               gxTv_SdtNovedadEventos_Leglicsitcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicSitDescrip") )
            {
               gxTv_SdtNovedadEventos_Leglicsitdescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicCntDias") )
            {
               gxTv_SdtNovedadEventos_Legliccntdias = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicDescrip") )
            {
               gxTv_SdtNovedadEventos_Leglicdescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicConPlus") )
            {
               gxTv_SdtNovedadEventos_Leglicconplus = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSitEsLic") )
            {
               gxTv_SdtNovedadEventos_Legsiteslic = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSitEsAu") )
            {
               gxTv_SdtNovedadEventos_Legsitesau = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSitEsAfip") )
            {
               gxTv_SdtNovedadEventos_Legsitesafip = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSitCuenTrab") )
            {
               gxTv_SdtNovedadEventos_Legsitcuentrab = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicEstado") )
            {
               gxTv_SdtNovedadEventos_Leglicestado = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLIcMot") )
            {
               gxTv_SdtNovedadEventos_Leglicmot = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicFile") )
            {
               gxTv_SdtNovedadEventos_Leglicfile=GXutil.blobFromBase64( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicFileNom") )
            {
               gxTv_SdtNovedadEventos_Leglicfilenom = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicFileExt") )
            {
               gxTv_SdtNovedadEventos_Leglicfileext = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicCanPres") )
            {
               gxTv_SdtNovedadEventos_Legliccanpres = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicRemCorr") )
            {
               gxTv_SdtNovedadEventos_Leglicremcorr = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtNovedadEventos_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtNovedadEventos_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_Z") )
            {
               gxTv_SdtNovedadEventos_Clicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod_Z") )
            {
               gxTv_SdtNovedadEventos_Empcod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNumero_Z") )
            {
               gxTv_SdtNovedadEventos_Legnumero_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicenIni_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtNovedadEventos_Leglicenini_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtNovedadEventos_Leglicenini_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicenFin_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtNovedadEventos_Leglicenfin_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtNovedadEventos_Leglicenfin_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicSitCodigo_Z") )
            {
               gxTv_SdtNovedadEventos_Leglicsitcodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicSitDescrip_Z") )
            {
               gxTv_SdtNovedadEventos_Leglicsitdescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicCntDias_Z") )
            {
               gxTv_SdtNovedadEventos_Legliccntdias_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicDescrip_Z") )
            {
               gxTv_SdtNovedadEventos_Leglicdescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicConPlus_Z") )
            {
               gxTv_SdtNovedadEventos_Leglicconplus_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSitEsLic_Z") )
            {
               gxTv_SdtNovedadEventos_Legsiteslic_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSitEsAu_Z") )
            {
               gxTv_SdtNovedadEventos_Legsitesau_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSitEsAfip_Z") )
            {
               gxTv_SdtNovedadEventos_Legsitesafip_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSitCuenTrab_Z") )
            {
               gxTv_SdtNovedadEventos_Legsitcuentrab_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicEstado_Z") )
            {
               gxTv_SdtNovedadEventos_Leglicestado_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicFileNom_Z") )
            {
               gxTv_SdtNovedadEventos_Leglicfilenom_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicFileExt_Z") )
            {
               gxTv_SdtNovedadEventos_Leglicfileext_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicCanPres_Z") )
            {
               gxTv_SdtNovedadEventos_Legliccanpres_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicRemCorr_Z") )
            {
               gxTv_SdtNovedadEventos_Leglicremcorr_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "NovedadEventos" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "PayDay" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_SdtNovedadEventos_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCod", GXutil.trim( GXutil.str( gxTv_SdtNovedadEventos_Empcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegNumero", GXutil.trim( GXutil.str( gxTv_SdtNovedadEventos_Legnumero, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtNovedadEventos_Leglicenini), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtNovedadEventos_Leglicenini), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtNovedadEventos_Leglicenini), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("LegLicenIni", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtNovedadEventos_Leglicenfin), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtNovedadEventos_Leglicenfin), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtNovedadEventos_Leglicenfin), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("LegLicenFin", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegLicSitCodigo", gxTv_SdtNovedadEventos_Leglicsitcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegLicSitDescrip", gxTv_SdtNovedadEventos_Leglicsitdescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegLicCntDias", GXutil.trim( GXutil.str( gxTv_SdtNovedadEventos_Legliccntdias, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegLicDescrip", gxTv_SdtNovedadEventos_Leglicdescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegLicConPlus", GXutil.booltostr( gxTv_SdtNovedadEventos_Leglicconplus));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegSitEsLic", GXutil.trim( GXutil.str( gxTv_SdtNovedadEventos_Legsiteslic, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegSitEsAu", GXutil.trim( GXutil.str( gxTv_SdtNovedadEventos_Legsitesau, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegSitEsAfip", GXutil.trim( GXutil.str( gxTv_SdtNovedadEventos_Legsitesafip, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegSitCuenTrab", GXutil.trim( GXutil.str( gxTv_SdtNovedadEventos_Legsitcuentrab, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegLicEstado", gxTv_SdtNovedadEventos_Leglicestado);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegLIcMot", gxTv_SdtNovedadEventos_Leglicmot);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegLicFile", GXutil.blobToBase64( gxTv_SdtNovedadEventos_Leglicfile));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegLicFileNom", gxTv_SdtNovedadEventos_Leglicfilenom);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegLicFileExt", gxTv_SdtNovedadEventos_Leglicfileext);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegLicCanPres", GXutil.trim( GXutil.str( gxTv_SdtNovedadEventos_Legliccanpres, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegLicRemCorr", GXutil.trim( GXutil.str( gxTv_SdtNovedadEventos_Leglicremcorr, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtNovedadEventos_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtNovedadEventos_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_Z", GXutil.trim( GXutil.str( gxTv_SdtNovedadEventos_Clicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpCod_Z", GXutil.trim( GXutil.str( gxTv_SdtNovedadEventos_Empcod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegNumero_Z", GXutil.trim( GXutil.str( gxTv_SdtNovedadEventos_Legnumero_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtNovedadEventos_Leglicenini_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtNovedadEventos_Leglicenini_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtNovedadEventos_Leglicenini_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LegLicenIni_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtNovedadEventos_Leglicenfin_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtNovedadEventos_Leglicenfin_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtNovedadEventos_Leglicenfin_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LegLicenFin_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegLicSitCodigo_Z", gxTv_SdtNovedadEventos_Leglicsitcodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegLicSitDescrip_Z", gxTv_SdtNovedadEventos_Leglicsitdescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegLicCntDias_Z", GXutil.trim( GXutil.str( gxTv_SdtNovedadEventos_Legliccntdias_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegLicDescrip_Z", gxTv_SdtNovedadEventos_Leglicdescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegLicConPlus_Z", GXutil.booltostr( gxTv_SdtNovedadEventos_Leglicconplus_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegSitEsLic_Z", GXutil.trim( GXutil.str( gxTv_SdtNovedadEventos_Legsiteslic_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegSitEsAu_Z", GXutil.trim( GXutil.str( gxTv_SdtNovedadEventos_Legsitesau_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegSitEsAfip_Z", GXutil.trim( GXutil.str( gxTv_SdtNovedadEventos_Legsitesafip_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegSitCuenTrab_Z", GXutil.trim( GXutil.str( gxTv_SdtNovedadEventos_Legsitcuentrab_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegLicEstado_Z", gxTv_SdtNovedadEventos_Leglicestado_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegLicFileNom_Z", gxTv_SdtNovedadEventos_Leglicfilenom_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegLicFileExt_Z", gxTv_SdtNovedadEventos_Leglicfileext_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegLicCanPres_Z", GXutil.trim( GXutil.str( gxTv_SdtNovedadEventos_Legliccanpres_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegLicRemCorr_Z", GXutil.trim( GXutil.str( gxTv_SdtNovedadEventos_Leglicremcorr_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("CliCod", gxTv_SdtNovedadEventos_Clicod, false, includeNonInitialized);
      AddObjectProperty("EmpCod", gxTv_SdtNovedadEventos_Empcod, false, includeNonInitialized);
      AddObjectProperty("LegNumero", gxTv_SdtNovedadEventos_Legnumero, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtNovedadEventos_Leglicenini), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtNovedadEventos_Leglicenini), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtNovedadEventos_Leglicenini), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LegLicenIni", sDateCnv, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtNovedadEventos_Leglicenfin), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtNovedadEventos_Leglicenfin), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtNovedadEventos_Leglicenfin), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LegLicenFin", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("LegLicSitCodigo", gxTv_SdtNovedadEventos_Leglicsitcodigo, false, includeNonInitialized);
      AddObjectProperty("LegLicSitDescrip", gxTv_SdtNovedadEventos_Leglicsitdescrip, false, includeNonInitialized);
      AddObjectProperty("LegLicCntDias", gxTv_SdtNovedadEventos_Legliccntdias, false, includeNonInitialized);
      AddObjectProperty("LegLicDescrip", gxTv_SdtNovedadEventos_Leglicdescrip, false, includeNonInitialized);
      AddObjectProperty("LegLicConPlus", gxTv_SdtNovedadEventos_Leglicconplus, false, includeNonInitialized);
      AddObjectProperty("LegSitEsLic", gxTv_SdtNovedadEventos_Legsiteslic, false, includeNonInitialized);
      AddObjectProperty("LegSitEsAu", gxTv_SdtNovedadEventos_Legsitesau, false, includeNonInitialized);
      AddObjectProperty("LegSitEsAfip", gxTv_SdtNovedadEventos_Legsitesafip, false, includeNonInitialized);
      AddObjectProperty("LegSitCuenTrab", gxTv_SdtNovedadEventos_Legsitcuentrab, false, includeNonInitialized);
      AddObjectProperty("LegLicEstado", gxTv_SdtNovedadEventos_Leglicestado, false, includeNonInitialized);
      AddObjectProperty("LegLIcMot", gxTv_SdtNovedadEventos_Leglicmot, false, includeNonInitialized);
      AddObjectProperty("LegLicFile", gxTv_SdtNovedadEventos_Leglicfile, false, includeNonInitialized);
      AddObjectProperty("LegLicFileNom", gxTv_SdtNovedadEventos_Leglicfilenom, false, includeNonInitialized);
      AddObjectProperty("LegLicFileExt", gxTv_SdtNovedadEventos_Leglicfileext, false, includeNonInitialized);
      AddObjectProperty("LegLicCanPres", gxTv_SdtNovedadEventos_Legliccanpres, false, includeNonInitialized);
      AddObjectProperty("LegLicRemCorr", gxTv_SdtNovedadEventos_Leglicremcorr, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtNovedadEventos_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtNovedadEventos_Initialized, false, includeNonInitialized);
         AddObjectProperty("CliCod_Z", gxTv_SdtNovedadEventos_Clicod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpCod_Z", gxTv_SdtNovedadEventos_Empcod_Z, false, includeNonInitialized);
         AddObjectProperty("LegNumero_Z", gxTv_SdtNovedadEventos_Legnumero_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtNovedadEventos_Leglicenini_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtNovedadEventos_Leglicenini_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtNovedadEventos_Leglicenini_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("LegLicenIni_Z", sDateCnv, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtNovedadEventos_Leglicenfin_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtNovedadEventos_Leglicenfin_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtNovedadEventos_Leglicenfin_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("LegLicenFin_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("LegLicSitCodigo_Z", gxTv_SdtNovedadEventos_Leglicsitcodigo_Z, false, includeNonInitialized);
         AddObjectProperty("LegLicSitDescrip_Z", gxTv_SdtNovedadEventos_Leglicsitdescrip_Z, false, includeNonInitialized);
         AddObjectProperty("LegLicCntDias_Z", gxTv_SdtNovedadEventos_Legliccntdias_Z, false, includeNonInitialized);
         AddObjectProperty("LegLicDescrip_Z", gxTv_SdtNovedadEventos_Leglicdescrip_Z, false, includeNonInitialized);
         AddObjectProperty("LegLicConPlus_Z", gxTv_SdtNovedadEventos_Leglicconplus_Z, false, includeNonInitialized);
         AddObjectProperty("LegSitEsLic_Z", gxTv_SdtNovedadEventos_Legsiteslic_Z, false, includeNonInitialized);
         AddObjectProperty("LegSitEsAu_Z", gxTv_SdtNovedadEventos_Legsitesau_Z, false, includeNonInitialized);
         AddObjectProperty("LegSitEsAfip_Z", gxTv_SdtNovedadEventos_Legsitesafip_Z, false, includeNonInitialized);
         AddObjectProperty("LegSitCuenTrab_Z", gxTv_SdtNovedadEventos_Legsitcuentrab_Z, false, includeNonInitialized);
         AddObjectProperty("LegLicEstado_Z", gxTv_SdtNovedadEventos_Leglicestado_Z, false, includeNonInitialized);
         AddObjectProperty("LegLicFileNom_Z", gxTv_SdtNovedadEventos_Leglicfilenom_Z, false, includeNonInitialized);
         AddObjectProperty("LegLicFileExt_Z", gxTv_SdtNovedadEventos_Leglicfileext_Z, false, includeNonInitialized);
         AddObjectProperty("LegLicCanPres_Z", gxTv_SdtNovedadEventos_Legliccanpres_Z, false, includeNonInitialized);
         AddObjectProperty("LegLicRemCorr_Z", gxTv_SdtNovedadEventos_Leglicremcorr_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtNovedadEventos sdt )
   {
      if ( sdt.IsDirty("CliCod") )
      {
         gxTv_SdtNovedadEventos_N = (byte)(0) ;
         gxTv_SdtNovedadEventos_Clicod = sdt.getgxTv_SdtNovedadEventos_Clicod() ;
      }
      if ( sdt.IsDirty("EmpCod") )
      {
         gxTv_SdtNovedadEventos_N = (byte)(0) ;
         gxTv_SdtNovedadEventos_Empcod = sdt.getgxTv_SdtNovedadEventos_Empcod() ;
      }
      if ( sdt.IsDirty("LegNumero") )
      {
         gxTv_SdtNovedadEventos_N = (byte)(0) ;
         gxTv_SdtNovedadEventos_Legnumero = sdt.getgxTv_SdtNovedadEventos_Legnumero() ;
      }
      if ( sdt.IsDirty("LegLicenIni") )
      {
         gxTv_SdtNovedadEventos_N = (byte)(0) ;
         gxTv_SdtNovedadEventos_Leglicenini = sdt.getgxTv_SdtNovedadEventos_Leglicenini() ;
      }
      if ( sdt.IsDirty("LegLicenFin") )
      {
         gxTv_SdtNovedadEventos_N = (byte)(0) ;
         gxTv_SdtNovedadEventos_Leglicenfin = sdt.getgxTv_SdtNovedadEventos_Leglicenfin() ;
      }
      if ( sdt.IsDirty("LegLicSitCodigo") )
      {
         gxTv_SdtNovedadEventos_N = (byte)(0) ;
         gxTv_SdtNovedadEventos_Leglicsitcodigo = sdt.getgxTv_SdtNovedadEventos_Leglicsitcodigo() ;
      }
      if ( sdt.IsDirty("LegLicSitDescrip") )
      {
         gxTv_SdtNovedadEventos_N = (byte)(0) ;
         gxTv_SdtNovedadEventos_Leglicsitdescrip = sdt.getgxTv_SdtNovedadEventos_Leglicsitdescrip() ;
      }
      if ( sdt.IsDirty("LegLicCntDias") )
      {
         gxTv_SdtNovedadEventos_N = (byte)(0) ;
         gxTv_SdtNovedadEventos_Legliccntdias = sdt.getgxTv_SdtNovedadEventos_Legliccntdias() ;
      }
      if ( sdt.IsDirty("LegLicDescrip") )
      {
         gxTv_SdtNovedadEventos_N = (byte)(0) ;
         gxTv_SdtNovedadEventos_Leglicdescrip = sdt.getgxTv_SdtNovedadEventos_Leglicdescrip() ;
      }
      if ( sdt.IsDirty("LegLicConPlus") )
      {
         gxTv_SdtNovedadEventos_N = (byte)(0) ;
         gxTv_SdtNovedadEventos_Leglicconplus = sdt.getgxTv_SdtNovedadEventos_Leglicconplus() ;
      }
      if ( sdt.IsDirty("LegSitEsLic") )
      {
         gxTv_SdtNovedadEventos_N = (byte)(0) ;
         gxTv_SdtNovedadEventos_Legsiteslic = sdt.getgxTv_SdtNovedadEventos_Legsiteslic() ;
      }
      if ( sdt.IsDirty("LegSitEsAu") )
      {
         gxTv_SdtNovedadEventos_N = (byte)(0) ;
         gxTv_SdtNovedadEventos_Legsitesau = sdt.getgxTv_SdtNovedadEventos_Legsitesau() ;
      }
      if ( sdt.IsDirty("LegSitEsAfip") )
      {
         gxTv_SdtNovedadEventos_N = (byte)(0) ;
         gxTv_SdtNovedadEventos_Legsitesafip = sdt.getgxTv_SdtNovedadEventos_Legsitesafip() ;
      }
      if ( sdt.IsDirty("LegSitCuenTrab") )
      {
         gxTv_SdtNovedadEventos_N = (byte)(0) ;
         gxTv_SdtNovedadEventos_Legsitcuentrab = sdt.getgxTv_SdtNovedadEventos_Legsitcuentrab() ;
      }
      if ( sdt.IsDirty("LegLicEstado") )
      {
         gxTv_SdtNovedadEventos_N = (byte)(0) ;
         gxTv_SdtNovedadEventos_Leglicestado = sdt.getgxTv_SdtNovedadEventos_Leglicestado() ;
      }
      if ( sdt.IsDirty("LegLIcMot") )
      {
         gxTv_SdtNovedadEventos_N = (byte)(0) ;
         gxTv_SdtNovedadEventos_Leglicmot = sdt.getgxTv_SdtNovedadEventos_Leglicmot() ;
      }
      if ( sdt.IsDirty("LegLicFile") )
      {
         gxTv_SdtNovedadEventos_N = (byte)(0) ;
         gxTv_SdtNovedadEventos_Leglicfile = sdt.getgxTv_SdtNovedadEventos_Leglicfile() ;
      }
      if ( sdt.IsDirty("LegLicFileNom") )
      {
         gxTv_SdtNovedadEventos_N = (byte)(0) ;
         gxTv_SdtNovedadEventos_Leglicfilenom = sdt.getgxTv_SdtNovedadEventos_Leglicfilenom() ;
      }
      if ( sdt.IsDirty("LegLicFileExt") )
      {
         gxTv_SdtNovedadEventos_N = (byte)(0) ;
         gxTv_SdtNovedadEventos_Leglicfileext = sdt.getgxTv_SdtNovedadEventos_Leglicfileext() ;
      }
      if ( sdt.IsDirty("LegLicCanPres") )
      {
         gxTv_SdtNovedadEventos_N = (byte)(0) ;
         gxTv_SdtNovedadEventos_Legliccanpres = sdt.getgxTv_SdtNovedadEventos_Legliccanpres() ;
      }
      if ( sdt.IsDirty("LegLicRemCorr") )
      {
         gxTv_SdtNovedadEventos_N = (byte)(0) ;
         gxTv_SdtNovedadEventos_Leglicremcorr = sdt.getgxTv_SdtNovedadEventos_Leglicremcorr() ;
      }
   }

   public int getgxTv_SdtNovedadEventos_Clicod( )
   {
      return gxTv_SdtNovedadEventos_Clicod ;
   }

   public void setgxTv_SdtNovedadEventos_Clicod( int value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      if ( gxTv_SdtNovedadEventos_Clicod != value )
      {
         gxTv_SdtNovedadEventos_Mode = "INS" ;
         this.setgxTv_SdtNovedadEventos_Clicod_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Empcod_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Legnumero_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicenini_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicenfin_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicsitcodigo_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicsitdescrip_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Legliccntdias_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicdescrip_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicconplus_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Legsiteslic_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Legsitesau_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Legsitesafip_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Legsitcuentrab_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicestado_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicfilenom_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicfileext_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Legliccanpres_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicremcorr_Z_SetNull( );
      }
      SetDirty("Clicod");
      gxTv_SdtNovedadEventos_Clicod = value ;
   }

   public short getgxTv_SdtNovedadEventos_Empcod( )
   {
      return gxTv_SdtNovedadEventos_Empcod ;
   }

   public void setgxTv_SdtNovedadEventos_Empcod( short value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      if ( gxTv_SdtNovedadEventos_Empcod != value )
      {
         gxTv_SdtNovedadEventos_Mode = "INS" ;
         this.setgxTv_SdtNovedadEventos_Clicod_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Empcod_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Legnumero_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicenini_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicenfin_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicsitcodigo_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicsitdescrip_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Legliccntdias_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicdescrip_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicconplus_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Legsiteslic_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Legsitesau_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Legsitesafip_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Legsitcuentrab_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicestado_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicfilenom_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicfileext_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Legliccanpres_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicremcorr_Z_SetNull( );
      }
      SetDirty("Empcod");
      gxTv_SdtNovedadEventos_Empcod = value ;
   }

   public int getgxTv_SdtNovedadEventos_Legnumero( )
   {
      return gxTv_SdtNovedadEventos_Legnumero ;
   }

   public void setgxTv_SdtNovedadEventos_Legnumero( int value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      if ( gxTv_SdtNovedadEventos_Legnumero != value )
      {
         gxTv_SdtNovedadEventos_Mode = "INS" ;
         this.setgxTv_SdtNovedadEventos_Clicod_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Empcod_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Legnumero_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicenini_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicenfin_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicsitcodigo_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicsitdescrip_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Legliccntdias_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicdescrip_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicconplus_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Legsiteslic_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Legsitesau_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Legsitesafip_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Legsitcuentrab_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicestado_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicfilenom_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicfileext_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Legliccanpres_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicremcorr_Z_SetNull( );
      }
      SetDirty("Legnumero");
      gxTv_SdtNovedadEventos_Legnumero = value ;
   }

   public java.util.Date getgxTv_SdtNovedadEventos_Leglicenini( )
   {
      return gxTv_SdtNovedadEventos_Leglicenini ;
   }

   public void setgxTv_SdtNovedadEventos_Leglicenini( java.util.Date value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      if ( !( GXutil.dateCompare(GXutil.resetTime(gxTv_SdtNovedadEventos_Leglicenini), GXutil.resetTime(value)) ) )
      {
         gxTv_SdtNovedadEventos_Mode = "INS" ;
         this.setgxTv_SdtNovedadEventos_Clicod_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Empcod_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Legnumero_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicenini_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicenfin_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicsitcodigo_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicsitdescrip_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Legliccntdias_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicdescrip_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicconplus_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Legsiteslic_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Legsitesau_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Legsitesafip_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Legsitcuentrab_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicestado_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicfilenom_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicfileext_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Legliccanpres_Z_SetNull( );
         this.setgxTv_SdtNovedadEventos_Leglicremcorr_Z_SetNull( );
      }
      SetDirty("Leglicenini");
      gxTv_SdtNovedadEventos_Leglicenini = value ;
   }

   public java.util.Date getgxTv_SdtNovedadEventos_Leglicenfin( )
   {
      return gxTv_SdtNovedadEventos_Leglicenfin ;
   }

   public void setgxTv_SdtNovedadEventos_Leglicenfin( java.util.Date value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Leglicenfin");
      gxTv_SdtNovedadEventos_Leglicenfin = value ;
   }

   public String getgxTv_SdtNovedadEventos_Leglicsitcodigo( )
   {
      return gxTv_SdtNovedadEventos_Leglicsitcodigo ;
   }

   public void setgxTv_SdtNovedadEventos_Leglicsitcodigo( String value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Leglicsitcodigo");
      gxTv_SdtNovedadEventos_Leglicsitcodigo = value ;
   }

   public String getgxTv_SdtNovedadEventos_Leglicsitdescrip( )
   {
      return gxTv_SdtNovedadEventos_Leglicsitdescrip ;
   }

   public void setgxTv_SdtNovedadEventos_Leglicsitdescrip( String value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Leglicsitdescrip");
      gxTv_SdtNovedadEventos_Leglicsitdescrip = value ;
   }

   public short getgxTv_SdtNovedadEventos_Legliccntdias( )
   {
      return gxTv_SdtNovedadEventos_Legliccntdias ;
   }

   public void setgxTv_SdtNovedadEventos_Legliccntdias( short value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Legliccntdias");
      gxTv_SdtNovedadEventos_Legliccntdias = value ;
   }

   public void setgxTv_SdtNovedadEventos_Legliccntdias_SetNull( )
   {
      gxTv_SdtNovedadEventos_Legliccntdias = (short)(0) ;
      SetDirty("Legliccntdias");
   }

   public boolean getgxTv_SdtNovedadEventos_Legliccntdias_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtNovedadEventos_Leglicdescrip( )
   {
      return gxTv_SdtNovedadEventos_Leglicdescrip ;
   }

   public void setgxTv_SdtNovedadEventos_Leglicdescrip( String value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Leglicdescrip");
      gxTv_SdtNovedadEventos_Leglicdescrip = value ;
   }

   public boolean getgxTv_SdtNovedadEventos_Leglicconplus( )
   {
      return gxTv_SdtNovedadEventos_Leglicconplus ;
   }

   public void setgxTv_SdtNovedadEventos_Leglicconplus( boolean value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Leglicconplus");
      gxTv_SdtNovedadEventos_Leglicconplus = value ;
   }

   public byte getgxTv_SdtNovedadEventos_Legsiteslic( )
   {
      return gxTv_SdtNovedadEventos_Legsiteslic ;
   }

   public void setgxTv_SdtNovedadEventos_Legsiteslic( byte value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Legsiteslic");
      gxTv_SdtNovedadEventos_Legsiteslic = value ;
   }

   public byte getgxTv_SdtNovedadEventos_Legsitesau( )
   {
      return gxTv_SdtNovedadEventos_Legsitesau ;
   }

   public void setgxTv_SdtNovedadEventos_Legsitesau( byte value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Legsitesau");
      gxTv_SdtNovedadEventos_Legsitesau = value ;
   }

   public byte getgxTv_SdtNovedadEventos_Legsitesafip( )
   {
      return gxTv_SdtNovedadEventos_Legsitesafip ;
   }

   public void setgxTv_SdtNovedadEventos_Legsitesafip( byte value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Legsitesafip");
      gxTv_SdtNovedadEventos_Legsitesafip = value ;
   }

   public byte getgxTv_SdtNovedadEventos_Legsitcuentrab( )
   {
      return gxTv_SdtNovedadEventos_Legsitcuentrab ;
   }

   public void setgxTv_SdtNovedadEventos_Legsitcuentrab( byte value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Legsitcuentrab");
      gxTv_SdtNovedadEventos_Legsitcuentrab = value ;
   }

   public String getgxTv_SdtNovedadEventos_Leglicestado( )
   {
      return gxTv_SdtNovedadEventos_Leglicestado ;
   }

   public void setgxTv_SdtNovedadEventos_Leglicestado( String value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Leglicestado");
      gxTv_SdtNovedadEventos_Leglicestado = value ;
   }

   public String getgxTv_SdtNovedadEventos_Leglicmot( )
   {
      return gxTv_SdtNovedadEventos_Leglicmot ;
   }

   public void setgxTv_SdtNovedadEventos_Leglicmot( String value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Leglicmot");
      gxTv_SdtNovedadEventos_Leglicmot = value ;
   }

   @GxUpload
   public String getgxTv_SdtNovedadEventos_Leglicfile( )
   {
      return gxTv_SdtNovedadEventos_Leglicfile ;
   }

   public void setgxTv_SdtNovedadEventos_Leglicfile( String value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Leglicfile");
      gxTv_SdtNovedadEventos_Leglicfile = value ;
   }

   public void setgxTv_SdtNovedadEventos_Leglicfile_SetBlob( String blob ,
                                                             String fileName ,
                                                             String fileType )
   {
      gxTv_SdtNovedadEventos_Leglicfile = blob ;
      gxTv_SdtNovedadEventos_Leglicfilenom = fileName ;
      gxTv_SdtNovedadEventos_Leglicfileext = fileType ;
   }

   public String getgxTv_SdtNovedadEventos_Leglicfilenom( )
   {
      return gxTv_SdtNovedadEventos_Leglicfilenom ;
   }

   public void setgxTv_SdtNovedadEventos_Leglicfilenom( String value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Leglicfilenom");
      gxTv_SdtNovedadEventos_Leglicfilenom = value ;
   }

   public String getgxTv_SdtNovedadEventos_Leglicfileext( )
   {
      return gxTv_SdtNovedadEventos_Leglicfileext ;
   }

   public void setgxTv_SdtNovedadEventos_Leglicfileext( String value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Leglicfileext");
      gxTv_SdtNovedadEventos_Leglicfileext = value ;
   }

   public byte getgxTv_SdtNovedadEventos_Legliccanpres( )
   {
      return gxTv_SdtNovedadEventos_Legliccanpres ;
   }

   public void setgxTv_SdtNovedadEventos_Legliccanpres( byte value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Legliccanpres");
      gxTv_SdtNovedadEventos_Legliccanpres = value ;
   }

   public byte getgxTv_SdtNovedadEventos_Leglicremcorr( )
   {
      return gxTv_SdtNovedadEventos_Leglicremcorr ;
   }

   public void setgxTv_SdtNovedadEventos_Leglicremcorr( byte value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Leglicremcorr");
      gxTv_SdtNovedadEventos_Leglicremcorr = value ;
   }

   public String getgxTv_SdtNovedadEventos_Mode( )
   {
      return gxTv_SdtNovedadEventos_Mode ;
   }

   public void setgxTv_SdtNovedadEventos_Mode( String value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtNovedadEventos_Mode = value ;
   }

   public void setgxTv_SdtNovedadEventos_Mode_SetNull( )
   {
      gxTv_SdtNovedadEventos_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtNovedadEventos_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtNovedadEventos_Initialized( )
   {
      return gxTv_SdtNovedadEventos_Initialized ;
   }

   public void setgxTv_SdtNovedadEventos_Initialized( short value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtNovedadEventos_Initialized = value ;
   }

   public void setgxTv_SdtNovedadEventos_Initialized_SetNull( )
   {
      gxTv_SdtNovedadEventos_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtNovedadEventos_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtNovedadEventos_Clicod_Z( )
   {
      return gxTv_SdtNovedadEventos_Clicod_Z ;
   }

   public void setgxTv_SdtNovedadEventos_Clicod_Z( int value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Clicod_Z");
      gxTv_SdtNovedadEventos_Clicod_Z = value ;
   }

   public void setgxTv_SdtNovedadEventos_Clicod_Z_SetNull( )
   {
      gxTv_SdtNovedadEventos_Clicod_Z = 0 ;
      SetDirty("Clicod_Z");
   }

   public boolean getgxTv_SdtNovedadEventos_Clicod_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtNovedadEventos_Empcod_Z( )
   {
      return gxTv_SdtNovedadEventos_Empcod_Z ;
   }

   public void setgxTv_SdtNovedadEventos_Empcod_Z( short value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Empcod_Z");
      gxTv_SdtNovedadEventos_Empcod_Z = value ;
   }

   public void setgxTv_SdtNovedadEventos_Empcod_Z_SetNull( )
   {
      gxTv_SdtNovedadEventos_Empcod_Z = (short)(0) ;
      SetDirty("Empcod_Z");
   }

   public boolean getgxTv_SdtNovedadEventos_Empcod_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtNovedadEventos_Legnumero_Z( )
   {
      return gxTv_SdtNovedadEventos_Legnumero_Z ;
   }

   public void setgxTv_SdtNovedadEventos_Legnumero_Z( int value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Legnumero_Z");
      gxTv_SdtNovedadEventos_Legnumero_Z = value ;
   }

   public void setgxTv_SdtNovedadEventos_Legnumero_Z_SetNull( )
   {
      gxTv_SdtNovedadEventos_Legnumero_Z = 0 ;
      SetDirty("Legnumero_Z");
   }

   public boolean getgxTv_SdtNovedadEventos_Legnumero_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtNovedadEventos_Leglicenini_Z( )
   {
      return gxTv_SdtNovedadEventos_Leglicenini_Z ;
   }

   public void setgxTv_SdtNovedadEventos_Leglicenini_Z( java.util.Date value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Leglicenini_Z");
      gxTv_SdtNovedadEventos_Leglicenini_Z = value ;
   }

   public void setgxTv_SdtNovedadEventos_Leglicenini_Z_SetNull( )
   {
      gxTv_SdtNovedadEventos_Leglicenini_Z = GXutil.nullDate() ;
      SetDirty("Leglicenini_Z");
   }

   public boolean getgxTv_SdtNovedadEventos_Leglicenini_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtNovedadEventos_Leglicenfin_Z( )
   {
      return gxTv_SdtNovedadEventos_Leglicenfin_Z ;
   }

   public void setgxTv_SdtNovedadEventos_Leglicenfin_Z( java.util.Date value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Leglicenfin_Z");
      gxTv_SdtNovedadEventos_Leglicenfin_Z = value ;
   }

   public void setgxTv_SdtNovedadEventos_Leglicenfin_Z_SetNull( )
   {
      gxTv_SdtNovedadEventos_Leglicenfin_Z = GXutil.nullDate() ;
      SetDirty("Leglicenfin_Z");
   }

   public boolean getgxTv_SdtNovedadEventos_Leglicenfin_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtNovedadEventos_Leglicsitcodigo_Z( )
   {
      return gxTv_SdtNovedadEventos_Leglicsitcodigo_Z ;
   }

   public void setgxTv_SdtNovedadEventos_Leglicsitcodigo_Z( String value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Leglicsitcodigo_Z");
      gxTv_SdtNovedadEventos_Leglicsitcodigo_Z = value ;
   }

   public void setgxTv_SdtNovedadEventos_Leglicsitcodigo_Z_SetNull( )
   {
      gxTv_SdtNovedadEventos_Leglicsitcodigo_Z = "" ;
      SetDirty("Leglicsitcodigo_Z");
   }

   public boolean getgxTv_SdtNovedadEventos_Leglicsitcodigo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtNovedadEventos_Leglicsitdescrip_Z( )
   {
      return gxTv_SdtNovedadEventos_Leglicsitdescrip_Z ;
   }

   public void setgxTv_SdtNovedadEventos_Leglicsitdescrip_Z( String value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Leglicsitdescrip_Z");
      gxTv_SdtNovedadEventos_Leglicsitdescrip_Z = value ;
   }

   public void setgxTv_SdtNovedadEventos_Leglicsitdescrip_Z_SetNull( )
   {
      gxTv_SdtNovedadEventos_Leglicsitdescrip_Z = "" ;
      SetDirty("Leglicsitdescrip_Z");
   }

   public boolean getgxTv_SdtNovedadEventos_Leglicsitdescrip_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtNovedadEventos_Legliccntdias_Z( )
   {
      return gxTv_SdtNovedadEventos_Legliccntdias_Z ;
   }

   public void setgxTv_SdtNovedadEventos_Legliccntdias_Z( short value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Legliccntdias_Z");
      gxTv_SdtNovedadEventos_Legliccntdias_Z = value ;
   }

   public void setgxTv_SdtNovedadEventos_Legliccntdias_Z_SetNull( )
   {
      gxTv_SdtNovedadEventos_Legliccntdias_Z = (short)(0) ;
      SetDirty("Legliccntdias_Z");
   }

   public boolean getgxTv_SdtNovedadEventos_Legliccntdias_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtNovedadEventos_Leglicdescrip_Z( )
   {
      return gxTv_SdtNovedadEventos_Leglicdescrip_Z ;
   }

   public void setgxTv_SdtNovedadEventos_Leglicdescrip_Z( String value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Leglicdescrip_Z");
      gxTv_SdtNovedadEventos_Leglicdescrip_Z = value ;
   }

   public void setgxTv_SdtNovedadEventos_Leglicdescrip_Z_SetNull( )
   {
      gxTv_SdtNovedadEventos_Leglicdescrip_Z = "" ;
      SetDirty("Leglicdescrip_Z");
   }

   public boolean getgxTv_SdtNovedadEventos_Leglicdescrip_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtNovedadEventos_Leglicconplus_Z( )
   {
      return gxTv_SdtNovedadEventos_Leglicconplus_Z ;
   }

   public void setgxTv_SdtNovedadEventos_Leglicconplus_Z( boolean value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Leglicconplus_Z");
      gxTv_SdtNovedadEventos_Leglicconplus_Z = value ;
   }

   public void setgxTv_SdtNovedadEventos_Leglicconplus_Z_SetNull( )
   {
      gxTv_SdtNovedadEventos_Leglicconplus_Z = false ;
      SetDirty("Leglicconplus_Z");
   }

   public boolean getgxTv_SdtNovedadEventos_Leglicconplus_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtNovedadEventos_Legsiteslic_Z( )
   {
      return gxTv_SdtNovedadEventos_Legsiteslic_Z ;
   }

   public void setgxTv_SdtNovedadEventos_Legsiteslic_Z( byte value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Legsiteslic_Z");
      gxTv_SdtNovedadEventos_Legsiteslic_Z = value ;
   }

   public void setgxTv_SdtNovedadEventos_Legsiteslic_Z_SetNull( )
   {
      gxTv_SdtNovedadEventos_Legsiteslic_Z = (byte)(0) ;
      SetDirty("Legsiteslic_Z");
   }

   public boolean getgxTv_SdtNovedadEventos_Legsiteslic_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtNovedadEventos_Legsitesau_Z( )
   {
      return gxTv_SdtNovedadEventos_Legsitesau_Z ;
   }

   public void setgxTv_SdtNovedadEventos_Legsitesau_Z( byte value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Legsitesau_Z");
      gxTv_SdtNovedadEventos_Legsitesau_Z = value ;
   }

   public void setgxTv_SdtNovedadEventos_Legsitesau_Z_SetNull( )
   {
      gxTv_SdtNovedadEventos_Legsitesau_Z = (byte)(0) ;
      SetDirty("Legsitesau_Z");
   }

   public boolean getgxTv_SdtNovedadEventos_Legsitesau_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtNovedadEventos_Legsitesafip_Z( )
   {
      return gxTv_SdtNovedadEventos_Legsitesafip_Z ;
   }

   public void setgxTv_SdtNovedadEventos_Legsitesafip_Z( byte value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Legsitesafip_Z");
      gxTv_SdtNovedadEventos_Legsitesafip_Z = value ;
   }

   public void setgxTv_SdtNovedadEventos_Legsitesafip_Z_SetNull( )
   {
      gxTv_SdtNovedadEventos_Legsitesafip_Z = (byte)(0) ;
      SetDirty("Legsitesafip_Z");
   }

   public boolean getgxTv_SdtNovedadEventos_Legsitesafip_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtNovedadEventos_Legsitcuentrab_Z( )
   {
      return gxTv_SdtNovedadEventos_Legsitcuentrab_Z ;
   }

   public void setgxTv_SdtNovedadEventos_Legsitcuentrab_Z( byte value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Legsitcuentrab_Z");
      gxTv_SdtNovedadEventos_Legsitcuentrab_Z = value ;
   }

   public void setgxTv_SdtNovedadEventos_Legsitcuentrab_Z_SetNull( )
   {
      gxTv_SdtNovedadEventos_Legsitcuentrab_Z = (byte)(0) ;
      SetDirty("Legsitcuentrab_Z");
   }

   public boolean getgxTv_SdtNovedadEventos_Legsitcuentrab_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtNovedadEventos_Leglicestado_Z( )
   {
      return gxTv_SdtNovedadEventos_Leglicestado_Z ;
   }

   public void setgxTv_SdtNovedadEventos_Leglicestado_Z( String value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Leglicestado_Z");
      gxTv_SdtNovedadEventos_Leglicestado_Z = value ;
   }

   public void setgxTv_SdtNovedadEventos_Leglicestado_Z_SetNull( )
   {
      gxTv_SdtNovedadEventos_Leglicestado_Z = "" ;
      SetDirty("Leglicestado_Z");
   }

   public boolean getgxTv_SdtNovedadEventos_Leglicestado_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtNovedadEventos_Leglicfilenom_Z( )
   {
      return gxTv_SdtNovedadEventos_Leglicfilenom_Z ;
   }

   public void setgxTv_SdtNovedadEventos_Leglicfilenom_Z( String value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Leglicfilenom_Z");
      gxTv_SdtNovedadEventos_Leglicfilenom_Z = value ;
   }

   public void setgxTv_SdtNovedadEventos_Leglicfilenom_Z_SetNull( )
   {
      gxTv_SdtNovedadEventos_Leglicfilenom_Z = "" ;
      SetDirty("Leglicfilenom_Z");
   }

   public boolean getgxTv_SdtNovedadEventos_Leglicfilenom_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtNovedadEventos_Leglicfileext_Z( )
   {
      return gxTv_SdtNovedadEventos_Leglicfileext_Z ;
   }

   public void setgxTv_SdtNovedadEventos_Leglicfileext_Z( String value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Leglicfileext_Z");
      gxTv_SdtNovedadEventos_Leglicfileext_Z = value ;
   }

   public void setgxTv_SdtNovedadEventos_Leglicfileext_Z_SetNull( )
   {
      gxTv_SdtNovedadEventos_Leglicfileext_Z = "" ;
      SetDirty("Leglicfileext_Z");
   }

   public boolean getgxTv_SdtNovedadEventos_Leglicfileext_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtNovedadEventos_Legliccanpres_Z( )
   {
      return gxTv_SdtNovedadEventos_Legliccanpres_Z ;
   }

   public void setgxTv_SdtNovedadEventos_Legliccanpres_Z( byte value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Legliccanpres_Z");
      gxTv_SdtNovedadEventos_Legliccanpres_Z = value ;
   }

   public void setgxTv_SdtNovedadEventos_Legliccanpres_Z_SetNull( )
   {
      gxTv_SdtNovedadEventos_Legliccanpres_Z = (byte)(0) ;
      SetDirty("Legliccanpres_Z");
   }

   public boolean getgxTv_SdtNovedadEventos_Legliccanpres_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtNovedadEventos_Leglicremcorr_Z( )
   {
      return gxTv_SdtNovedadEventos_Leglicremcorr_Z ;
   }

   public void setgxTv_SdtNovedadEventos_Leglicremcorr_Z( byte value )
   {
      gxTv_SdtNovedadEventos_N = (byte)(0) ;
      SetDirty("Leglicremcorr_Z");
      gxTv_SdtNovedadEventos_Leglicremcorr_Z = value ;
   }

   public void setgxTv_SdtNovedadEventos_Leglicremcorr_Z_SetNull( )
   {
      gxTv_SdtNovedadEventos_Leglicremcorr_Z = (byte)(0) ;
      SetDirty("Leglicremcorr_Z");
   }

   public boolean getgxTv_SdtNovedadEventos_Leglicremcorr_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.novedadeventos_bc obj;
      obj = new web.novedadeventos_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtNovedadEventos_N = (byte)(1) ;
      gxTv_SdtNovedadEventos_Leglicenini = GXutil.nullDate() ;
      gxTv_SdtNovedadEventos_Leglicenfin = GXutil.nullDate() ;
      gxTv_SdtNovedadEventos_Leglicsitcodigo = "" ;
      gxTv_SdtNovedadEventos_Leglicsitdescrip = "" ;
      gxTv_SdtNovedadEventos_Leglicdescrip = "" ;
      gxTv_SdtNovedadEventos_Leglicestado = "" ;
      gxTv_SdtNovedadEventos_Leglicmot = "" ;
      gxTv_SdtNovedadEventos_Leglicfile = "" ;
      gxTv_SdtNovedadEventos_Leglicfilenom = "" ;
      gxTv_SdtNovedadEventos_Leglicfileext = "" ;
      gxTv_SdtNovedadEventos_Mode = "" ;
      gxTv_SdtNovedadEventos_Leglicenini_Z = GXutil.nullDate() ;
      gxTv_SdtNovedadEventos_Leglicenfin_Z = GXutil.nullDate() ;
      gxTv_SdtNovedadEventos_Leglicsitcodigo_Z = "" ;
      gxTv_SdtNovedadEventos_Leglicsitdescrip_Z = "" ;
      gxTv_SdtNovedadEventos_Leglicdescrip_Z = "" ;
      gxTv_SdtNovedadEventos_Leglicestado_Z = "" ;
      gxTv_SdtNovedadEventos_Leglicfilenom_Z = "" ;
      gxTv_SdtNovedadEventos_Leglicfileext_Z = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtNovedadEventos_N ;
   }

   public web.SdtNovedadEventos Clone( )
   {
      web.SdtNovedadEventos sdt;
      web.novedadeventos_bc obj;
      sdt = (web.SdtNovedadEventos)(clone()) ;
      obj = (web.novedadeventos_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtNovedadEventos struct )
   {
      setgxTv_SdtNovedadEventos_Clicod(struct.getClicod());
      setgxTv_SdtNovedadEventos_Empcod(struct.getEmpcod());
      setgxTv_SdtNovedadEventos_Legnumero(struct.getLegnumero());
      setgxTv_SdtNovedadEventos_Leglicenini(struct.getLeglicenini());
      setgxTv_SdtNovedadEventos_Leglicenfin(struct.getLeglicenfin());
      setgxTv_SdtNovedadEventos_Leglicsitcodigo(struct.getLeglicsitcodigo());
      setgxTv_SdtNovedadEventos_Leglicsitdescrip(struct.getLeglicsitdescrip());
      setgxTv_SdtNovedadEventos_Legliccntdias(struct.getLegliccntdias());
      setgxTv_SdtNovedadEventos_Leglicdescrip(struct.getLeglicdescrip());
      setgxTv_SdtNovedadEventos_Leglicconplus(struct.getLeglicconplus());
      setgxTv_SdtNovedadEventos_Legsiteslic(struct.getLegsiteslic());
      setgxTv_SdtNovedadEventos_Legsitesau(struct.getLegsitesau());
      setgxTv_SdtNovedadEventos_Legsitesafip(struct.getLegsitesafip());
      setgxTv_SdtNovedadEventos_Legsitcuentrab(struct.getLegsitcuentrab());
      setgxTv_SdtNovedadEventos_Leglicestado(struct.getLeglicestado());
      setgxTv_SdtNovedadEventos_Leglicmot(struct.getLeglicmot());
      setgxTv_SdtNovedadEventos_Leglicfile(struct.getLeglicfile());
      setgxTv_SdtNovedadEventos_Leglicfilenom(struct.getLeglicfilenom());
      setgxTv_SdtNovedadEventos_Leglicfileext(struct.getLeglicfileext());
      setgxTv_SdtNovedadEventos_Legliccanpres(struct.getLegliccanpres());
      setgxTv_SdtNovedadEventos_Leglicremcorr(struct.getLeglicremcorr());
      setgxTv_SdtNovedadEventos_Mode(struct.getMode());
      setgxTv_SdtNovedadEventos_Initialized(struct.getInitialized());
      setgxTv_SdtNovedadEventos_Clicod_Z(struct.getClicod_Z());
      setgxTv_SdtNovedadEventos_Empcod_Z(struct.getEmpcod_Z());
      setgxTv_SdtNovedadEventos_Legnumero_Z(struct.getLegnumero_Z());
      setgxTv_SdtNovedadEventos_Leglicenini_Z(struct.getLeglicenini_Z());
      setgxTv_SdtNovedadEventos_Leglicenfin_Z(struct.getLeglicenfin_Z());
      setgxTv_SdtNovedadEventos_Leglicsitcodigo_Z(struct.getLeglicsitcodigo_Z());
      setgxTv_SdtNovedadEventos_Leglicsitdescrip_Z(struct.getLeglicsitdescrip_Z());
      setgxTv_SdtNovedadEventos_Legliccntdias_Z(struct.getLegliccntdias_Z());
      setgxTv_SdtNovedadEventos_Leglicdescrip_Z(struct.getLeglicdescrip_Z());
      setgxTv_SdtNovedadEventos_Leglicconplus_Z(struct.getLeglicconplus_Z());
      setgxTv_SdtNovedadEventos_Legsiteslic_Z(struct.getLegsiteslic_Z());
      setgxTv_SdtNovedadEventos_Legsitesau_Z(struct.getLegsitesau_Z());
      setgxTv_SdtNovedadEventos_Legsitesafip_Z(struct.getLegsitesafip_Z());
      setgxTv_SdtNovedadEventos_Legsitcuentrab_Z(struct.getLegsitcuentrab_Z());
      setgxTv_SdtNovedadEventos_Leglicestado_Z(struct.getLeglicestado_Z());
      setgxTv_SdtNovedadEventos_Leglicfilenom_Z(struct.getLeglicfilenom_Z());
      setgxTv_SdtNovedadEventos_Leglicfileext_Z(struct.getLeglicfileext_Z());
      setgxTv_SdtNovedadEventos_Legliccanpres_Z(struct.getLegliccanpres_Z());
      setgxTv_SdtNovedadEventos_Leglicremcorr_Z(struct.getLeglicremcorr_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtNovedadEventos getStruct( )
   {
      web.StructSdtNovedadEventos struct = new web.StructSdtNovedadEventos ();
      struct.setClicod(getgxTv_SdtNovedadEventos_Clicod());
      struct.setEmpcod(getgxTv_SdtNovedadEventos_Empcod());
      struct.setLegnumero(getgxTv_SdtNovedadEventos_Legnumero());
      struct.setLeglicenini(getgxTv_SdtNovedadEventos_Leglicenini());
      struct.setLeglicenfin(getgxTv_SdtNovedadEventos_Leglicenfin());
      struct.setLeglicsitcodigo(getgxTv_SdtNovedadEventos_Leglicsitcodigo());
      struct.setLeglicsitdescrip(getgxTv_SdtNovedadEventos_Leglicsitdescrip());
      struct.setLegliccntdias(getgxTv_SdtNovedadEventos_Legliccntdias());
      struct.setLeglicdescrip(getgxTv_SdtNovedadEventos_Leglicdescrip());
      struct.setLeglicconplus(getgxTv_SdtNovedadEventos_Leglicconplus());
      struct.setLegsiteslic(getgxTv_SdtNovedadEventos_Legsiteslic());
      struct.setLegsitesau(getgxTv_SdtNovedadEventos_Legsitesau());
      struct.setLegsitesafip(getgxTv_SdtNovedadEventos_Legsitesafip());
      struct.setLegsitcuentrab(getgxTv_SdtNovedadEventos_Legsitcuentrab());
      struct.setLeglicestado(getgxTv_SdtNovedadEventos_Leglicestado());
      struct.setLeglicmot(getgxTv_SdtNovedadEventos_Leglicmot());
      struct.setLeglicfile(getgxTv_SdtNovedadEventos_Leglicfile());
      struct.setLeglicfilenom(getgxTv_SdtNovedadEventos_Leglicfilenom());
      struct.setLeglicfileext(getgxTv_SdtNovedadEventos_Leglicfileext());
      struct.setLegliccanpres(getgxTv_SdtNovedadEventos_Legliccanpres());
      struct.setLeglicremcorr(getgxTv_SdtNovedadEventos_Leglicremcorr());
      struct.setMode(getgxTv_SdtNovedadEventos_Mode());
      struct.setInitialized(getgxTv_SdtNovedadEventos_Initialized());
      struct.setClicod_Z(getgxTv_SdtNovedadEventos_Clicod_Z());
      struct.setEmpcod_Z(getgxTv_SdtNovedadEventos_Empcod_Z());
      struct.setLegnumero_Z(getgxTv_SdtNovedadEventos_Legnumero_Z());
      struct.setLeglicenini_Z(getgxTv_SdtNovedadEventos_Leglicenini_Z());
      struct.setLeglicenfin_Z(getgxTv_SdtNovedadEventos_Leglicenfin_Z());
      struct.setLeglicsitcodigo_Z(getgxTv_SdtNovedadEventos_Leglicsitcodigo_Z());
      struct.setLeglicsitdescrip_Z(getgxTv_SdtNovedadEventos_Leglicsitdescrip_Z());
      struct.setLegliccntdias_Z(getgxTv_SdtNovedadEventos_Legliccntdias_Z());
      struct.setLeglicdescrip_Z(getgxTv_SdtNovedadEventos_Leglicdescrip_Z());
      struct.setLeglicconplus_Z(getgxTv_SdtNovedadEventos_Leglicconplus_Z());
      struct.setLegsiteslic_Z(getgxTv_SdtNovedadEventos_Legsiteslic_Z());
      struct.setLegsitesau_Z(getgxTv_SdtNovedadEventos_Legsitesau_Z());
      struct.setLegsitesafip_Z(getgxTv_SdtNovedadEventos_Legsitesafip_Z());
      struct.setLegsitcuentrab_Z(getgxTv_SdtNovedadEventos_Legsitcuentrab_Z());
      struct.setLeglicestado_Z(getgxTv_SdtNovedadEventos_Leglicestado_Z());
      struct.setLeglicfilenom_Z(getgxTv_SdtNovedadEventos_Leglicfilenom_Z());
      struct.setLeglicfileext_Z(getgxTv_SdtNovedadEventos_Leglicfileext_Z());
      struct.setLegliccanpres_Z(getgxTv_SdtNovedadEventos_Legliccanpres_Z());
      struct.setLeglicremcorr_Z(getgxTv_SdtNovedadEventos_Leglicremcorr_Z());
      return struct ;
   }

   private byte gxTv_SdtNovedadEventos_N ;
   private byte gxTv_SdtNovedadEventos_Legsiteslic ;
   private byte gxTv_SdtNovedadEventos_Legsitesau ;
   private byte gxTv_SdtNovedadEventos_Legsitesafip ;
   private byte gxTv_SdtNovedadEventos_Legsitcuentrab ;
   private byte gxTv_SdtNovedadEventos_Legliccanpres ;
   private byte gxTv_SdtNovedadEventos_Leglicremcorr ;
   private byte gxTv_SdtNovedadEventos_Legsiteslic_Z ;
   private byte gxTv_SdtNovedadEventos_Legsitesau_Z ;
   private byte gxTv_SdtNovedadEventos_Legsitesafip_Z ;
   private byte gxTv_SdtNovedadEventos_Legsitcuentrab_Z ;
   private byte gxTv_SdtNovedadEventos_Legliccanpres_Z ;
   private byte gxTv_SdtNovedadEventos_Leglicremcorr_Z ;
   private short gxTv_SdtNovedadEventos_Empcod ;
   private short gxTv_SdtNovedadEventos_Legliccntdias ;
   private short gxTv_SdtNovedadEventos_Initialized ;
   private short gxTv_SdtNovedadEventos_Empcod_Z ;
   private short gxTv_SdtNovedadEventos_Legliccntdias_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtNovedadEventos_Clicod ;
   private int gxTv_SdtNovedadEventos_Legnumero ;
   private int gxTv_SdtNovedadEventos_Clicod_Z ;
   private int gxTv_SdtNovedadEventos_Legnumero_Z ;
   private String gxTv_SdtNovedadEventos_Leglicsitcodigo ;
   private String gxTv_SdtNovedadEventos_Leglicestado ;
   private String gxTv_SdtNovedadEventos_Leglicfileext ;
   private String gxTv_SdtNovedadEventos_Mode ;
   private String gxTv_SdtNovedadEventos_Leglicsitcodigo_Z ;
   private String gxTv_SdtNovedadEventos_Leglicestado_Z ;
   private String gxTv_SdtNovedadEventos_Leglicfileext_Z ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtNovedadEventos_Leglicenini ;
   private java.util.Date gxTv_SdtNovedadEventos_Leglicenfin ;
   private java.util.Date gxTv_SdtNovedadEventos_Leglicenini_Z ;
   private java.util.Date gxTv_SdtNovedadEventos_Leglicenfin_Z ;
   private boolean gxTv_SdtNovedadEventos_Leglicconplus ;
   private boolean gxTv_SdtNovedadEventos_Leglicconplus_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtNovedadEventos_Leglicmot ;
   private String gxTv_SdtNovedadEventos_Leglicfile ;
   private String gxTv_SdtNovedadEventos_Leglicsitdescrip ;
   private String gxTv_SdtNovedadEventos_Leglicdescrip ;
   private String gxTv_SdtNovedadEventos_Leglicfilenom ;
   private String gxTv_SdtNovedadEventos_Leglicsitdescrip_Z ;
   private String gxTv_SdtNovedadEventos_Leglicdescrip_Z ;
   private String gxTv_SdtNovedadEventos_Leglicfilenom_Z ;
}

