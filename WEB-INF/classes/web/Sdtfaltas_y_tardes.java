package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtfaltas_y_tardes extends GxSilentTrnSdt
{
   public Sdtfaltas_y_tardes( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(Sdtfaltas_y_tardes.class));
   }

   public Sdtfaltas_y_tardes( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle, context, "Sdtfaltas_y_tardes");
      initialize( remoteHandle) ;
   }

   public Sdtfaltas_y_tardes( int remoteHandle ,
                              StructSdtfaltas_y_tardes struct )
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
      metadata.set("Name", "faltas_y_tardes");
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
               gxTv_Sdtfaltas_y_tardes_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod") )
            {
               gxTv_Sdtfaltas_y_tardes_Empcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNumero") )
            {
               gxTv_Sdtfaltas_y_tardes_Legnumero = (int)(getnumericvalue(oReader.getValue())) ;
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
                  gxTv_Sdtfaltas_y_tardes_Leglicenini = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_Sdtfaltas_y_tardes_Leglicenini = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
                  gxTv_Sdtfaltas_y_tardes_Leglicenfin = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_Sdtfaltas_y_tardes_Leglicenfin = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
               gxTv_Sdtfaltas_y_tardes_Leglicsitcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicSitDescrip") )
            {
               gxTv_Sdtfaltas_y_tardes_Leglicsitdescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicCntDias") )
            {
               gxTv_Sdtfaltas_y_tardes_Legliccntdias = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicDescrip") )
            {
               gxTv_Sdtfaltas_y_tardes_Leglicdescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicConPlus") )
            {
               gxTv_Sdtfaltas_y_tardes_Leglicconplus = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSitEsLic") )
            {
               gxTv_Sdtfaltas_y_tardes_Legsiteslic = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSitEsAu") )
            {
               gxTv_Sdtfaltas_y_tardes_Legsitesau = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSitEsAfip") )
            {
               gxTv_Sdtfaltas_y_tardes_Legsitesafip = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSitCuenTrab") )
            {
               gxTv_Sdtfaltas_y_tardes_Legsitcuentrab = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicCanPres") )
            {
               gxTv_Sdtfaltas_y_tardes_Legliccanpres = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicRemCorr") )
            {
               gxTv_Sdtfaltas_y_tardes_Leglicremcorr = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicEstado") )
            {
               gxTv_Sdtfaltas_y_tardes_Leglicestado = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_Sdtfaltas_y_tardes_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_Sdtfaltas_y_tardes_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_Z") )
            {
               gxTv_Sdtfaltas_y_tardes_Clicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod_Z") )
            {
               gxTv_Sdtfaltas_y_tardes_Empcod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNumero_Z") )
            {
               gxTv_Sdtfaltas_y_tardes_Legnumero_Z = (int)(getnumericvalue(oReader.getValue())) ;
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
                  gxTv_Sdtfaltas_y_tardes_Leglicenini_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_Sdtfaltas_y_tardes_Leglicenini_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
                  gxTv_Sdtfaltas_y_tardes_Leglicenfin_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_Sdtfaltas_y_tardes_Leglicenfin_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
               gxTv_Sdtfaltas_y_tardes_Leglicsitcodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicSitDescrip_Z") )
            {
               gxTv_Sdtfaltas_y_tardes_Leglicsitdescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicCntDias_Z") )
            {
               gxTv_Sdtfaltas_y_tardes_Legliccntdias_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicDescrip_Z") )
            {
               gxTv_Sdtfaltas_y_tardes_Leglicdescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicConPlus_Z") )
            {
               gxTv_Sdtfaltas_y_tardes_Leglicconplus_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSitEsLic_Z") )
            {
               gxTv_Sdtfaltas_y_tardes_Legsiteslic_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSitEsAu_Z") )
            {
               gxTv_Sdtfaltas_y_tardes_Legsitesau_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSitEsAfip_Z") )
            {
               gxTv_Sdtfaltas_y_tardes_Legsitesafip_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSitCuenTrab_Z") )
            {
               gxTv_Sdtfaltas_y_tardes_Legsitcuentrab_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicCanPres_Z") )
            {
               gxTv_Sdtfaltas_y_tardes_Legliccanpres_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicRemCorr_Z") )
            {
               gxTv_Sdtfaltas_y_tardes_Leglicremcorr_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicEstado_Z") )
            {
               gxTv_Sdtfaltas_y_tardes_Leglicestado_Z = oReader.getValue() ;
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
         sName = "faltas_y_tardes" ;
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
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_Sdtfaltas_y_tardes_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCod", GXutil.trim( GXutil.str( gxTv_Sdtfaltas_y_tardes_Empcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegNumero", GXutil.trim( GXutil.str( gxTv_Sdtfaltas_y_tardes_Legnumero, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtfaltas_y_tardes_Leglicenini), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtfaltas_y_tardes_Leglicenini), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtfaltas_y_tardes_Leglicenini), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("LegLicenIni", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtfaltas_y_tardes_Leglicenfin), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtfaltas_y_tardes_Leglicenfin), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtfaltas_y_tardes_Leglicenfin), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("LegLicenFin", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegLicSitCodigo", gxTv_Sdtfaltas_y_tardes_Leglicsitcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegLicSitDescrip", gxTv_Sdtfaltas_y_tardes_Leglicsitdescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegLicCntDias", GXutil.trim( GXutil.str( gxTv_Sdtfaltas_y_tardes_Legliccntdias, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegLicDescrip", gxTv_Sdtfaltas_y_tardes_Leglicdescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegLicConPlus", GXutil.booltostr( gxTv_Sdtfaltas_y_tardes_Leglicconplus));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegSitEsLic", GXutil.trim( GXutil.str( gxTv_Sdtfaltas_y_tardes_Legsiteslic, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegSitEsAu", GXutil.trim( GXutil.str( gxTv_Sdtfaltas_y_tardes_Legsitesau, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegSitEsAfip", GXutil.trim( GXutil.str( gxTv_Sdtfaltas_y_tardes_Legsitesafip, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegSitCuenTrab", GXutil.trim( GXutil.str( gxTv_Sdtfaltas_y_tardes_Legsitcuentrab, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegLicCanPres", GXutil.trim( GXutil.str( gxTv_Sdtfaltas_y_tardes_Legliccanpres, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegLicRemCorr", GXutil.trim( GXutil.str( gxTv_Sdtfaltas_y_tardes_Leglicremcorr, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegLicEstado", gxTv_Sdtfaltas_y_tardes_Leglicestado);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_Sdtfaltas_y_tardes_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_Sdtfaltas_y_tardes_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_Z", GXutil.trim( GXutil.str( gxTv_Sdtfaltas_y_tardes_Clicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpCod_Z", GXutil.trim( GXutil.str( gxTv_Sdtfaltas_y_tardes_Empcod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegNumero_Z", GXutil.trim( GXutil.str( gxTv_Sdtfaltas_y_tardes_Legnumero_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtfaltas_y_tardes_Leglicenini_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtfaltas_y_tardes_Leglicenini_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtfaltas_y_tardes_Leglicenini_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LegLicenIni_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtfaltas_y_tardes_Leglicenfin_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtfaltas_y_tardes_Leglicenfin_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtfaltas_y_tardes_Leglicenfin_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LegLicenFin_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegLicSitCodigo_Z", gxTv_Sdtfaltas_y_tardes_Leglicsitcodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegLicSitDescrip_Z", gxTv_Sdtfaltas_y_tardes_Leglicsitdescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegLicCntDias_Z", GXutil.trim( GXutil.str( gxTv_Sdtfaltas_y_tardes_Legliccntdias_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegLicDescrip_Z", gxTv_Sdtfaltas_y_tardes_Leglicdescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegLicConPlus_Z", GXutil.booltostr( gxTv_Sdtfaltas_y_tardes_Leglicconplus_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegSitEsLic_Z", GXutil.trim( GXutil.str( gxTv_Sdtfaltas_y_tardes_Legsiteslic_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegSitEsAu_Z", GXutil.trim( GXutil.str( gxTv_Sdtfaltas_y_tardes_Legsitesau_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegSitEsAfip_Z", GXutil.trim( GXutil.str( gxTv_Sdtfaltas_y_tardes_Legsitesafip_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegSitCuenTrab_Z", GXutil.trim( GXutil.str( gxTv_Sdtfaltas_y_tardes_Legsitcuentrab_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegLicCanPres_Z", GXutil.trim( GXutil.str( gxTv_Sdtfaltas_y_tardes_Legliccanpres_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegLicRemCorr_Z", GXutil.trim( GXutil.str( gxTv_Sdtfaltas_y_tardes_Leglicremcorr_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegLicEstado_Z", gxTv_Sdtfaltas_y_tardes_Leglicestado_Z);
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
      AddObjectProperty("CliCod", gxTv_Sdtfaltas_y_tardes_Clicod, false, includeNonInitialized);
      AddObjectProperty("EmpCod", gxTv_Sdtfaltas_y_tardes_Empcod, false, includeNonInitialized);
      AddObjectProperty("LegNumero", gxTv_Sdtfaltas_y_tardes_Legnumero, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtfaltas_y_tardes_Leglicenini), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtfaltas_y_tardes_Leglicenini), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtfaltas_y_tardes_Leglicenini), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LegLicenIni", sDateCnv, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtfaltas_y_tardes_Leglicenfin), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtfaltas_y_tardes_Leglicenfin), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtfaltas_y_tardes_Leglicenfin), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LegLicenFin", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("LegLicSitCodigo", gxTv_Sdtfaltas_y_tardes_Leglicsitcodigo, false, includeNonInitialized);
      AddObjectProperty("LegLicSitDescrip", gxTv_Sdtfaltas_y_tardes_Leglicsitdescrip, false, includeNonInitialized);
      AddObjectProperty("LegLicCntDias", gxTv_Sdtfaltas_y_tardes_Legliccntdias, false, includeNonInitialized);
      AddObjectProperty("LegLicDescrip", gxTv_Sdtfaltas_y_tardes_Leglicdescrip, false, includeNonInitialized);
      AddObjectProperty("LegLicConPlus", gxTv_Sdtfaltas_y_tardes_Leglicconplus, false, includeNonInitialized);
      AddObjectProperty("LegSitEsLic", gxTv_Sdtfaltas_y_tardes_Legsiteslic, false, includeNonInitialized);
      AddObjectProperty("LegSitEsAu", gxTv_Sdtfaltas_y_tardes_Legsitesau, false, includeNonInitialized);
      AddObjectProperty("LegSitEsAfip", gxTv_Sdtfaltas_y_tardes_Legsitesafip, false, includeNonInitialized);
      AddObjectProperty("LegSitCuenTrab", gxTv_Sdtfaltas_y_tardes_Legsitcuentrab, false, includeNonInitialized);
      AddObjectProperty("LegLicCanPres", gxTv_Sdtfaltas_y_tardes_Legliccanpres, false, includeNonInitialized);
      AddObjectProperty("LegLicRemCorr", gxTv_Sdtfaltas_y_tardes_Leglicremcorr, false, includeNonInitialized);
      AddObjectProperty("LegLicEstado", gxTv_Sdtfaltas_y_tardes_Leglicestado, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_Sdtfaltas_y_tardes_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_Sdtfaltas_y_tardes_Initialized, false, includeNonInitialized);
         AddObjectProperty("CliCod_Z", gxTv_Sdtfaltas_y_tardes_Clicod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpCod_Z", gxTv_Sdtfaltas_y_tardes_Empcod_Z, false, includeNonInitialized);
         AddObjectProperty("LegNumero_Z", gxTv_Sdtfaltas_y_tardes_Legnumero_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtfaltas_y_tardes_Leglicenini_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtfaltas_y_tardes_Leglicenini_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtfaltas_y_tardes_Leglicenini_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("LegLicenIni_Z", sDateCnv, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtfaltas_y_tardes_Leglicenfin_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtfaltas_y_tardes_Leglicenfin_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtfaltas_y_tardes_Leglicenfin_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("LegLicenFin_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("LegLicSitCodigo_Z", gxTv_Sdtfaltas_y_tardes_Leglicsitcodigo_Z, false, includeNonInitialized);
         AddObjectProperty("LegLicSitDescrip_Z", gxTv_Sdtfaltas_y_tardes_Leglicsitdescrip_Z, false, includeNonInitialized);
         AddObjectProperty("LegLicCntDias_Z", gxTv_Sdtfaltas_y_tardes_Legliccntdias_Z, false, includeNonInitialized);
         AddObjectProperty("LegLicDescrip_Z", gxTv_Sdtfaltas_y_tardes_Leglicdescrip_Z, false, includeNonInitialized);
         AddObjectProperty("LegLicConPlus_Z", gxTv_Sdtfaltas_y_tardes_Leglicconplus_Z, false, includeNonInitialized);
         AddObjectProperty("LegSitEsLic_Z", gxTv_Sdtfaltas_y_tardes_Legsiteslic_Z, false, includeNonInitialized);
         AddObjectProperty("LegSitEsAu_Z", gxTv_Sdtfaltas_y_tardes_Legsitesau_Z, false, includeNonInitialized);
         AddObjectProperty("LegSitEsAfip_Z", gxTv_Sdtfaltas_y_tardes_Legsitesafip_Z, false, includeNonInitialized);
         AddObjectProperty("LegSitCuenTrab_Z", gxTv_Sdtfaltas_y_tardes_Legsitcuentrab_Z, false, includeNonInitialized);
         AddObjectProperty("LegLicCanPres_Z", gxTv_Sdtfaltas_y_tardes_Legliccanpres_Z, false, includeNonInitialized);
         AddObjectProperty("LegLicRemCorr_Z", gxTv_Sdtfaltas_y_tardes_Leglicremcorr_Z, false, includeNonInitialized);
         AddObjectProperty("LegLicEstado_Z", gxTv_Sdtfaltas_y_tardes_Leglicestado_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.Sdtfaltas_y_tardes sdt )
   {
      if ( sdt.IsDirty("CliCod") )
      {
         gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
         gxTv_Sdtfaltas_y_tardes_Clicod = sdt.getgxTv_Sdtfaltas_y_tardes_Clicod() ;
      }
      if ( sdt.IsDirty("EmpCod") )
      {
         gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
         gxTv_Sdtfaltas_y_tardes_Empcod = sdt.getgxTv_Sdtfaltas_y_tardes_Empcod() ;
      }
      if ( sdt.IsDirty("LegNumero") )
      {
         gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
         gxTv_Sdtfaltas_y_tardes_Legnumero = sdt.getgxTv_Sdtfaltas_y_tardes_Legnumero() ;
      }
      if ( sdt.IsDirty("LegLicenIni") )
      {
         gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
         gxTv_Sdtfaltas_y_tardes_Leglicenini = sdt.getgxTv_Sdtfaltas_y_tardes_Leglicenini() ;
      }
      if ( sdt.IsDirty("LegLicenFin") )
      {
         gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
         gxTv_Sdtfaltas_y_tardes_Leglicenfin = sdt.getgxTv_Sdtfaltas_y_tardes_Leglicenfin() ;
      }
      if ( sdt.IsDirty("LegLicSitCodigo") )
      {
         gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
         gxTv_Sdtfaltas_y_tardes_Leglicsitcodigo = sdt.getgxTv_Sdtfaltas_y_tardes_Leglicsitcodigo() ;
      }
      if ( sdt.IsDirty("LegLicSitDescrip") )
      {
         gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
         gxTv_Sdtfaltas_y_tardes_Leglicsitdescrip = sdt.getgxTv_Sdtfaltas_y_tardes_Leglicsitdescrip() ;
      }
      if ( sdt.IsDirty("LegLicCntDias") )
      {
         gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
         gxTv_Sdtfaltas_y_tardes_Legliccntdias = sdt.getgxTv_Sdtfaltas_y_tardes_Legliccntdias() ;
      }
      if ( sdt.IsDirty("LegLicDescrip") )
      {
         gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
         gxTv_Sdtfaltas_y_tardes_Leglicdescrip = sdt.getgxTv_Sdtfaltas_y_tardes_Leglicdescrip() ;
      }
      if ( sdt.IsDirty("LegLicConPlus") )
      {
         gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
         gxTv_Sdtfaltas_y_tardes_Leglicconplus = sdt.getgxTv_Sdtfaltas_y_tardes_Leglicconplus() ;
      }
      if ( sdt.IsDirty("LegSitEsLic") )
      {
         gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
         gxTv_Sdtfaltas_y_tardes_Legsiteslic = sdt.getgxTv_Sdtfaltas_y_tardes_Legsiteslic() ;
      }
      if ( sdt.IsDirty("LegSitEsAu") )
      {
         gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
         gxTv_Sdtfaltas_y_tardes_Legsitesau = sdt.getgxTv_Sdtfaltas_y_tardes_Legsitesau() ;
      }
      if ( sdt.IsDirty("LegSitEsAfip") )
      {
         gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
         gxTv_Sdtfaltas_y_tardes_Legsitesafip = sdt.getgxTv_Sdtfaltas_y_tardes_Legsitesafip() ;
      }
      if ( sdt.IsDirty("LegSitCuenTrab") )
      {
         gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
         gxTv_Sdtfaltas_y_tardes_Legsitcuentrab = sdt.getgxTv_Sdtfaltas_y_tardes_Legsitcuentrab() ;
      }
      if ( sdt.IsDirty("LegLicCanPres") )
      {
         gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
         gxTv_Sdtfaltas_y_tardes_Legliccanpres = sdt.getgxTv_Sdtfaltas_y_tardes_Legliccanpres() ;
      }
      if ( sdt.IsDirty("LegLicRemCorr") )
      {
         gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
         gxTv_Sdtfaltas_y_tardes_Leglicremcorr = sdt.getgxTv_Sdtfaltas_y_tardes_Leglicremcorr() ;
      }
      if ( sdt.IsDirty("LegLicEstado") )
      {
         gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
         gxTv_Sdtfaltas_y_tardes_Leglicestado = sdt.getgxTv_Sdtfaltas_y_tardes_Leglicestado() ;
      }
   }

   public int getgxTv_Sdtfaltas_y_tardes_Clicod( )
   {
      return gxTv_Sdtfaltas_y_tardes_Clicod ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Clicod( int value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      if ( gxTv_Sdtfaltas_y_tardes_Clicod != value )
      {
         gxTv_Sdtfaltas_y_tardes_Mode = "INS" ;
         this.setgxTv_Sdtfaltas_y_tardes_Clicod_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Empcod_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Legnumero_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Leglicenini_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Leglicenfin_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Leglicsitcodigo_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Leglicsitdescrip_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Legliccntdias_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Leglicdescrip_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Leglicconplus_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Legsiteslic_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Legsitesau_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Legsitesafip_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Legsitcuentrab_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Legliccanpres_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Leglicremcorr_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Leglicestado_Z_SetNull( );
      }
      SetDirty("Clicod");
      gxTv_Sdtfaltas_y_tardes_Clicod = value ;
   }

   public short getgxTv_Sdtfaltas_y_tardes_Empcod( )
   {
      return gxTv_Sdtfaltas_y_tardes_Empcod ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Empcod( short value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      if ( gxTv_Sdtfaltas_y_tardes_Empcod != value )
      {
         gxTv_Sdtfaltas_y_tardes_Mode = "INS" ;
         this.setgxTv_Sdtfaltas_y_tardes_Clicod_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Empcod_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Legnumero_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Leglicenini_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Leglicenfin_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Leglicsitcodigo_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Leglicsitdescrip_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Legliccntdias_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Leglicdescrip_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Leglicconplus_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Legsiteslic_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Legsitesau_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Legsitesafip_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Legsitcuentrab_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Legliccanpres_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Leglicremcorr_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Leglicestado_Z_SetNull( );
      }
      SetDirty("Empcod");
      gxTv_Sdtfaltas_y_tardes_Empcod = value ;
   }

   public int getgxTv_Sdtfaltas_y_tardes_Legnumero( )
   {
      return gxTv_Sdtfaltas_y_tardes_Legnumero ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Legnumero( int value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      if ( gxTv_Sdtfaltas_y_tardes_Legnumero != value )
      {
         gxTv_Sdtfaltas_y_tardes_Mode = "INS" ;
         this.setgxTv_Sdtfaltas_y_tardes_Clicod_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Empcod_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Legnumero_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Leglicenini_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Leglicenfin_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Leglicsitcodigo_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Leglicsitdescrip_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Legliccntdias_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Leglicdescrip_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Leglicconplus_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Legsiteslic_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Legsitesau_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Legsitesafip_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Legsitcuentrab_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Legliccanpres_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Leglicremcorr_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Leglicestado_Z_SetNull( );
      }
      SetDirty("Legnumero");
      gxTv_Sdtfaltas_y_tardes_Legnumero = value ;
   }

   public java.util.Date getgxTv_Sdtfaltas_y_tardes_Leglicenini( )
   {
      return gxTv_Sdtfaltas_y_tardes_Leglicenini ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Leglicenini( java.util.Date value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      if ( !( GXutil.dateCompare(GXutil.resetTime(gxTv_Sdtfaltas_y_tardes_Leglicenini), GXutil.resetTime(value)) ) )
      {
         gxTv_Sdtfaltas_y_tardes_Mode = "INS" ;
         this.setgxTv_Sdtfaltas_y_tardes_Clicod_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Empcod_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Legnumero_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Leglicenini_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Leglicenfin_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Leglicsitcodigo_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Leglicsitdescrip_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Legliccntdias_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Leglicdescrip_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Leglicconplus_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Legsiteslic_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Legsitesau_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Legsitesafip_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Legsitcuentrab_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Legliccanpres_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Leglicremcorr_Z_SetNull( );
         this.setgxTv_Sdtfaltas_y_tardes_Leglicestado_Z_SetNull( );
      }
      SetDirty("Leglicenini");
      gxTv_Sdtfaltas_y_tardes_Leglicenini = value ;
   }

   public java.util.Date getgxTv_Sdtfaltas_y_tardes_Leglicenfin( )
   {
      return gxTv_Sdtfaltas_y_tardes_Leglicenfin ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Leglicenfin( java.util.Date value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      SetDirty("Leglicenfin");
      gxTv_Sdtfaltas_y_tardes_Leglicenfin = value ;
   }

   public String getgxTv_Sdtfaltas_y_tardes_Leglicsitcodigo( )
   {
      return gxTv_Sdtfaltas_y_tardes_Leglicsitcodigo ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Leglicsitcodigo( String value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      SetDirty("Leglicsitcodigo");
      gxTv_Sdtfaltas_y_tardes_Leglicsitcodigo = value ;
   }

   public String getgxTv_Sdtfaltas_y_tardes_Leglicsitdescrip( )
   {
      return gxTv_Sdtfaltas_y_tardes_Leglicsitdescrip ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Leglicsitdescrip( String value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      SetDirty("Leglicsitdescrip");
      gxTv_Sdtfaltas_y_tardes_Leglicsitdescrip = value ;
   }

   public short getgxTv_Sdtfaltas_y_tardes_Legliccntdias( )
   {
      return gxTv_Sdtfaltas_y_tardes_Legliccntdias ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Legliccntdias( short value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      SetDirty("Legliccntdias");
      gxTv_Sdtfaltas_y_tardes_Legliccntdias = value ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Legliccntdias_SetNull( )
   {
      gxTv_Sdtfaltas_y_tardes_Legliccntdias = (short)(0) ;
      SetDirty("Legliccntdias");
   }

   public boolean getgxTv_Sdtfaltas_y_tardes_Legliccntdias_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtfaltas_y_tardes_Leglicdescrip( )
   {
      return gxTv_Sdtfaltas_y_tardes_Leglicdescrip ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Leglicdescrip( String value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      SetDirty("Leglicdescrip");
      gxTv_Sdtfaltas_y_tardes_Leglicdescrip = value ;
   }

   public boolean getgxTv_Sdtfaltas_y_tardes_Leglicconplus( )
   {
      return gxTv_Sdtfaltas_y_tardes_Leglicconplus ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Leglicconplus( boolean value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      SetDirty("Leglicconplus");
      gxTv_Sdtfaltas_y_tardes_Leglicconplus = value ;
   }

   public byte getgxTv_Sdtfaltas_y_tardes_Legsiteslic( )
   {
      return gxTv_Sdtfaltas_y_tardes_Legsiteslic ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Legsiteslic( byte value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      SetDirty("Legsiteslic");
      gxTv_Sdtfaltas_y_tardes_Legsiteslic = value ;
   }

   public byte getgxTv_Sdtfaltas_y_tardes_Legsitesau( )
   {
      return gxTv_Sdtfaltas_y_tardes_Legsitesau ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Legsitesau( byte value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      SetDirty("Legsitesau");
      gxTv_Sdtfaltas_y_tardes_Legsitesau = value ;
   }

   public byte getgxTv_Sdtfaltas_y_tardes_Legsitesafip( )
   {
      return gxTv_Sdtfaltas_y_tardes_Legsitesafip ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Legsitesafip( byte value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      SetDirty("Legsitesafip");
      gxTv_Sdtfaltas_y_tardes_Legsitesafip = value ;
   }

   public byte getgxTv_Sdtfaltas_y_tardes_Legsitcuentrab( )
   {
      return gxTv_Sdtfaltas_y_tardes_Legsitcuentrab ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Legsitcuentrab( byte value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      SetDirty("Legsitcuentrab");
      gxTv_Sdtfaltas_y_tardes_Legsitcuentrab = value ;
   }

   public byte getgxTv_Sdtfaltas_y_tardes_Legliccanpres( )
   {
      return gxTv_Sdtfaltas_y_tardes_Legliccanpres ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Legliccanpres( byte value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      SetDirty("Legliccanpres");
      gxTv_Sdtfaltas_y_tardes_Legliccanpres = value ;
   }

   public byte getgxTv_Sdtfaltas_y_tardes_Leglicremcorr( )
   {
      return gxTv_Sdtfaltas_y_tardes_Leglicremcorr ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Leglicremcorr( byte value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      SetDirty("Leglicremcorr");
      gxTv_Sdtfaltas_y_tardes_Leglicremcorr = value ;
   }

   public String getgxTv_Sdtfaltas_y_tardes_Leglicestado( )
   {
      return gxTv_Sdtfaltas_y_tardes_Leglicestado ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Leglicestado( String value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      SetDirty("Leglicestado");
      gxTv_Sdtfaltas_y_tardes_Leglicestado = value ;
   }

   public String getgxTv_Sdtfaltas_y_tardes_Mode( )
   {
      return gxTv_Sdtfaltas_y_tardes_Mode ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Mode( String value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_Sdtfaltas_y_tardes_Mode = value ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Mode_SetNull( )
   {
      gxTv_Sdtfaltas_y_tardes_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_Sdtfaltas_y_tardes_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtfaltas_y_tardes_Initialized( )
   {
      return gxTv_Sdtfaltas_y_tardes_Initialized ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Initialized( short value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_Sdtfaltas_y_tardes_Initialized = value ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Initialized_SetNull( )
   {
      gxTv_Sdtfaltas_y_tardes_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_Sdtfaltas_y_tardes_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_Sdtfaltas_y_tardes_Clicod_Z( )
   {
      return gxTv_Sdtfaltas_y_tardes_Clicod_Z ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Clicod_Z( int value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      SetDirty("Clicod_Z");
      gxTv_Sdtfaltas_y_tardes_Clicod_Z = value ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Clicod_Z_SetNull( )
   {
      gxTv_Sdtfaltas_y_tardes_Clicod_Z = 0 ;
      SetDirty("Clicod_Z");
   }

   public boolean getgxTv_Sdtfaltas_y_tardes_Clicod_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtfaltas_y_tardes_Empcod_Z( )
   {
      return gxTv_Sdtfaltas_y_tardes_Empcod_Z ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Empcod_Z( short value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      SetDirty("Empcod_Z");
      gxTv_Sdtfaltas_y_tardes_Empcod_Z = value ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Empcod_Z_SetNull( )
   {
      gxTv_Sdtfaltas_y_tardes_Empcod_Z = (short)(0) ;
      SetDirty("Empcod_Z");
   }

   public boolean getgxTv_Sdtfaltas_y_tardes_Empcod_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_Sdtfaltas_y_tardes_Legnumero_Z( )
   {
      return gxTv_Sdtfaltas_y_tardes_Legnumero_Z ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Legnumero_Z( int value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      SetDirty("Legnumero_Z");
      gxTv_Sdtfaltas_y_tardes_Legnumero_Z = value ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Legnumero_Z_SetNull( )
   {
      gxTv_Sdtfaltas_y_tardes_Legnumero_Z = 0 ;
      SetDirty("Legnumero_Z");
   }

   public boolean getgxTv_Sdtfaltas_y_tardes_Legnumero_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_Sdtfaltas_y_tardes_Leglicenini_Z( )
   {
      return gxTv_Sdtfaltas_y_tardes_Leglicenini_Z ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Leglicenini_Z( java.util.Date value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      SetDirty("Leglicenini_Z");
      gxTv_Sdtfaltas_y_tardes_Leglicenini_Z = value ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Leglicenini_Z_SetNull( )
   {
      gxTv_Sdtfaltas_y_tardes_Leglicenini_Z = GXutil.nullDate() ;
      SetDirty("Leglicenini_Z");
   }

   public boolean getgxTv_Sdtfaltas_y_tardes_Leglicenini_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_Sdtfaltas_y_tardes_Leglicenfin_Z( )
   {
      return gxTv_Sdtfaltas_y_tardes_Leglicenfin_Z ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Leglicenfin_Z( java.util.Date value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      SetDirty("Leglicenfin_Z");
      gxTv_Sdtfaltas_y_tardes_Leglicenfin_Z = value ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Leglicenfin_Z_SetNull( )
   {
      gxTv_Sdtfaltas_y_tardes_Leglicenfin_Z = GXutil.nullDate() ;
      SetDirty("Leglicenfin_Z");
   }

   public boolean getgxTv_Sdtfaltas_y_tardes_Leglicenfin_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtfaltas_y_tardes_Leglicsitcodigo_Z( )
   {
      return gxTv_Sdtfaltas_y_tardes_Leglicsitcodigo_Z ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Leglicsitcodigo_Z( String value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      SetDirty("Leglicsitcodigo_Z");
      gxTv_Sdtfaltas_y_tardes_Leglicsitcodigo_Z = value ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Leglicsitcodigo_Z_SetNull( )
   {
      gxTv_Sdtfaltas_y_tardes_Leglicsitcodigo_Z = "" ;
      SetDirty("Leglicsitcodigo_Z");
   }

   public boolean getgxTv_Sdtfaltas_y_tardes_Leglicsitcodigo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtfaltas_y_tardes_Leglicsitdescrip_Z( )
   {
      return gxTv_Sdtfaltas_y_tardes_Leglicsitdescrip_Z ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Leglicsitdescrip_Z( String value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      SetDirty("Leglicsitdescrip_Z");
      gxTv_Sdtfaltas_y_tardes_Leglicsitdescrip_Z = value ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Leglicsitdescrip_Z_SetNull( )
   {
      gxTv_Sdtfaltas_y_tardes_Leglicsitdescrip_Z = "" ;
      SetDirty("Leglicsitdescrip_Z");
   }

   public boolean getgxTv_Sdtfaltas_y_tardes_Leglicsitdescrip_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtfaltas_y_tardes_Legliccntdias_Z( )
   {
      return gxTv_Sdtfaltas_y_tardes_Legliccntdias_Z ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Legliccntdias_Z( short value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      SetDirty("Legliccntdias_Z");
      gxTv_Sdtfaltas_y_tardes_Legliccntdias_Z = value ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Legliccntdias_Z_SetNull( )
   {
      gxTv_Sdtfaltas_y_tardes_Legliccntdias_Z = (short)(0) ;
      SetDirty("Legliccntdias_Z");
   }

   public boolean getgxTv_Sdtfaltas_y_tardes_Legliccntdias_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtfaltas_y_tardes_Leglicdescrip_Z( )
   {
      return gxTv_Sdtfaltas_y_tardes_Leglicdescrip_Z ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Leglicdescrip_Z( String value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      SetDirty("Leglicdescrip_Z");
      gxTv_Sdtfaltas_y_tardes_Leglicdescrip_Z = value ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Leglicdescrip_Z_SetNull( )
   {
      gxTv_Sdtfaltas_y_tardes_Leglicdescrip_Z = "" ;
      SetDirty("Leglicdescrip_Z");
   }

   public boolean getgxTv_Sdtfaltas_y_tardes_Leglicdescrip_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_Sdtfaltas_y_tardes_Leglicconplus_Z( )
   {
      return gxTv_Sdtfaltas_y_tardes_Leglicconplus_Z ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Leglicconplus_Z( boolean value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      SetDirty("Leglicconplus_Z");
      gxTv_Sdtfaltas_y_tardes_Leglicconplus_Z = value ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Leglicconplus_Z_SetNull( )
   {
      gxTv_Sdtfaltas_y_tardes_Leglicconplus_Z = false ;
      SetDirty("Leglicconplus_Z");
   }

   public boolean getgxTv_Sdtfaltas_y_tardes_Leglicconplus_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_Sdtfaltas_y_tardes_Legsiteslic_Z( )
   {
      return gxTv_Sdtfaltas_y_tardes_Legsiteslic_Z ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Legsiteslic_Z( byte value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      SetDirty("Legsiteslic_Z");
      gxTv_Sdtfaltas_y_tardes_Legsiteslic_Z = value ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Legsiteslic_Z_SetNull( )
   {
      gxTv_Sdtfaltas_y_tardes_Legsiteslic_Z = (byte)(0) ;
      SetDirty("Legsiteslic_Z");
   }

   public boolean getgxTv_Sdtfaltas_y_tardes_Legsiteslic_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_Sdtfaltas_y_tardes_Legsitesau_Z( )
   {
      return gxTv_Sdtfaltas_y_tardes_Legsitesau_Z ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Legsitesau_Z( byte value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      SetDirty("Legsitesau_Z");
      gxTv_Sdtfaltas_y_tardes_Legsitesau_Z = value ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Legsitesau_Z_SetNull( )
   {
      gxTv_Sdtfaltas_y_tardes_Legsitesau_Z = (byte)(0) ;
      SetDirty("Legsitesau_Z");
   }

   public boolean getgxTv_Sdtfaltas_y_tardes_Legsitesau_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_Sdtfaltas_y_tardes_Legsitesafip_Z( )
   {
      return gxTv_Sdtfaltas_y_tardes_Legsitesafip_Z ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Legsitesafip_Z( byte value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      SetDirty("Legsitesafip_Z");
      gxTv_Sdtfaltas_y_tardes_Legsitesafip_Z = value ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Legsitesafip_Z_SetNull( )
   {
      gxTv_Sdtfaltas_y_tardes_Legsitesafip_Z = (byte)(0) ;
      SetDirty("Legsitesafip_Z");
   }

   public boolean getgxTv_Sdtfaltas_y_tardes_Legsitesafip_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_Sdtfaltas_y_tardes_Legsitcuentrab_Z( )
   {
      return gxTv_Sdtfaltas_y_tardes_Legsitcuentrab_Z ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Legsitcuentrab_Z( byte value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      SetDirty("Legsitcuentrab_Z");
      gxTv_Sdtfaltas_y_tardes_Legsitcuentrab_Z = value ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Legsitcuentrab_Z_SetNull( )
   {
      gxTv_Sdtfaltas_y_tardes_Legsitcuentrab_Z = (byte)(0) ;
      SetDirty("Legsitcuentrab_Z");
   }

   public boolean getgxTv_Sdtfaltas_y_tardes_Legsitcuentrab_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_Sdtfaltas_y_tardes_Legliccanpres_Z( )
   {
      return gxTv_Sdtfaltas_y_tardes_Legliccanpres_Z ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Legliccanpres_Z( byte value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      SetDirty("Legliccanpres_Z");
      gxTv_Sdtfaltas_y_tardes_Legliccanpres_Z = value ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Legliccanpres_Z_SetNull( )
   {
      gxTv_Sdtfaltas_y_tardes_Legliccanpres_Z = (byte)(0) ;
      SetDirty("Legliccanpres_Z");
   }

   public boolean getgxTv_Sdtfaltas_y_tardes_Legliccanpres_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_Sdtfaltas_y_tardes_Leglicremcorr_Z( )
   {
      return gxTv_Sdtfaltas_y_tardes_Leglicremcorr_Z ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Leglicremcorr_Z( byte value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      SetDirty("Leglicremcorr_Z");
      gxTv_Sdtfaltas_y_tardes_Leglicremcorr_Z = value ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Leglicremcorr_Z_SetNull( )
   {
      gxTv_Sdtfaltas_y_tardes_Leglicremcorr_Z = (byte)(0) ;
      SetDirty("Leglicremcorr_Z");
   }

   public boolean getgxTv_Sdtfaltas_y_tardes_Leglicremcorr_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtfaltas_y_tardes_Leglicestado_Z( )
   {
      return gxTv_Sdtfaltas_y_tardes_Leglicestado_Z ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Leglicestado_Z( String value )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(0) ;
      SetDirty("Leglicestado_Z");
      gxTv_Sdtfaltas_y_tardes_Leglicestado_Z = value ;
   }

   public void setgxTv_Sdtfaltas_y_tardes_Leglicestado_Z_SetNull( )
   {
      gxTv_Sdtfaltas_y_tardes_Leglicestado_Z = "" ;
      SetDirty("Leglicestado_Z");
   }

   public boolean getgxTv_Sdtfaltas_y_tardes_Leglicestado_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.faltas_y_tardes_bc obj;
      obj = new web.faltas_y_tardes_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_Sdtfaltas_y_tardes_N = (byte)(1) ;
      gxTv_Sdtfaltas_y_tardes_Leglicenini = GXutil.nullDate() ;
      gxTv_Sdtfaltas_y_tardes_Leglicenfin = GXutil.nullDate() ;
      gxTv_Sdtfaltas_y_tardes_Leglicsitcodigo = "" ;
      gxTv_Sdtfaltas_y_tardes_Leglicsitdescrip = "" ;
      gxTv_Sdtfaltas_y_tardes_Leglicdescrip = "" ;
      gxTv_Sdtfaltas_y_tardes_Leglicestado = "" ;
      gxTv_Sdtfaltas_y_tardes_Mode = "" ;
      gxTv_Sdtfaltas_y_tardes_Leglicenini_Z = GXutil.nullDate() ;
      gxTv_Sdtfaltas_y_tardes_Leglicenfin_Z = GXutil.nullDate() ;
      gxTv_Sdtfaltas_y_tardes_Leglicsitcodigo_Z = "" ;
      gxTv_Sdtfaltas_y_tardes_Leglicsitdescrip_Z = "" ;
      gxTv_Sdtfaltas_y_tardes_Leglicdescrip_Z = "" ;
      gxTv_Sdtfaltas_y_tardes_Leglicestado_Z = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtfaltas_y_tardes_N ;
   }

   public web.Sdtfaltas_y_tardes Clone( )
   {
      web.Sdtfaltas_y_tardes sdt;
      web.faltas_y_tardes_bc obj;
      sdt = (web.Sdtfaltas_y_tardes)(clone()) ;
      obj = (web.faltas_y_tardes_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtfaltas_y_tardes struct )
   {
      setgxTv_Sdtfaltas_y_tardes_Clicod(struct.getClicod());
      setgxTv_Sdtfaltas_y_tardes_Empcod(struct.getEmpcod());
      setgxTv_Sdtfaltas_y_tardes_Legnumero(struct.getLegnumero());
      setgxTv_Sdtfaltas_y_tardes_Leglicenini(struct.getLeglicenini());
      setgxTv_Sdtfaltas_y_tardes_Leglicenfin(struct.getLeglicenfin());
      setgxTv_Sdtfaltas_y_tardes_Leglicsitcodigo(struct.getLeglicsitcodigo());
      setgxTv_Sdtfaltas_y_tardes_Leglicsitdescrip(struct.getLeglicsitdescrip());
      setgxTv_Sdtfaltas_y_tardes_Legliccntdias(struct.getLegliccntdias());
      setgxTv_Sdtfaltas_y_tardes_Leglicdescrip(struct.getLeglicdescrip());
      setgxTv_Sdtfaltas_y_tardes_Leglicconplus(struct.getLeglicconplus());
      setgxTv_Sdtfaltas_y_tardes_Legsiteslic(struct.getLegsiteslic());
      setgxTv_Sdtfaltas_y_tardes_Legsitesau(struct.getLegsitesau());
      setgxTv_Sdtfaltas_y_tardes_Legsitesafip(struct.getLegsitesafip());
      setgxTv_Sdtfaltas_y_tardes_Legsitcuentrab(struct.getLegsitcuentrab());
      setgxTv_Sdtfaltas_y_tardes_Legliccanpres(struct.getLegliccanpres());
      setgxTv_Sdtfaltas_y_tardes_Leglicremcorr(struct.getLeglicremcorr());
      setgxTv_Sdtfaltas_y_tardes_Leglicestado(struct.getLeglicestado());
      setgxTv_Sdtfaltas_y_tardes_Mode(struct.getMode());
      setgxTv_Sdtfaltas_y_tardes_Initialized(struct.getInitialized());
      setgxTv_Sdtfaltas_y_tardes_Clicod_Z(struct.getClicod_Z());
      setgxTv_Sdtfaltas_y_tardes_Empcod_Z(struct.getEmpcod_Z());
      setgxTv_Sdtfaltas_y_tardes_Legnumero_Z(struct.getLegnumero_Z());
      setgxTv_Sdtfaltas_y_tardes_Leglicenini_Z(struct.getLeglicenini_Z());
      setgxTv_Sdtfaltas_y_tardes_Leglicenfin_Z(struct.getLeglicenfin_Z());
      setgxTv_Sdtfaltas_y_tardes_Leglicsitcodigo_Z(struct.getLeglicsitcodigo_Z());
      setgxTv_Sdtfaltas_y_tardes_Leglicsitdescrip_Z(struct.getLeglicsitdescrip_Z());
      setgxTv_Sdtfaltas_y_tardes_Legliccntdias_Z(struct.getLegliccntdias_Z());
      setgxTv_Sdtfaltas_y_tardes_Leglicdescrip_Z(struct.getLeglicdescrip_Z());
      setgxTv_Sdtfaltas_y_tardes_Leglicconplus_Z(struct.getLeglicconplus_Z());
      setgxTv_Sdtfaltas_y_tardes_Legsiteslic_Z(struct.getLegsiteslic_Z());
      setgxTv_Sdtfaltas_y_tardes_Legsitesau_Z(struct.getLegsitesau_Z());
      setgxTv_Sdtfaltas_y_tardes_Legsitesafip_Z(struct.getLegsitesafip_Z());
      setgxTv_Sdtfaltas_y_tardes_Legsitcuentrab_Z(struct.getLegsitcuentrab_Z());
      setgxTv_Sdtfaltas_y_tardes_Legliccanpres_Z(struct.getLegliccanpres_Z());
      setgxTv_Sdtfaltas_y_tardes_Leglicremcorr_Z(struct.getLeglicremcorr_Z());
      setgxTv_Sdtfaltas_y_tardes_Leglicestado_Z(struct.getLeglicestado_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtfaltas_y_tardes getStruct( )
   {
      web.StructSdtfaltas_y_tardes struct = new web.StructSdtfaltas_y_tardes ();
      struct.setClicod(getgxTv_Sdtfaltas_y_tardes_Clicod());
      struct.setEmpcod(getgxTv_Sdtfaltas_y_tardes_Empcod());
      struct.setLegnumero(getgxTv_Sdtfaltas_y_tardes_Legnumero());
      struct.setLeglicenini(getgxTv_Sdtfaltas_y_tardes_Leglicenini());
      struct.setLeglicenfin(getgxTv_Sdtfaltas_y_tardes_Leglicenfin());
      struct.setLeglicsitcodigo(getgxTv_Sdtfaltas_y_tardes_Leglicsitcodigo());
      struct.setLeglicsitdescrip(getgxTv_Sdtfaltas_y_tardes_Leglicsitdescrip());
      struct.setLegliccntdias(getgxTv_Sdtfaltas_y_tardes_Legliccntdias());
      struct.setLeglicdescrip(getgxTv_Sdtfaltas_y_tardes_Leglicdescrip());
      struct.setLeglicconplus(getgxTv_Sdtfaltas_y_tardes_Leglicconplus());
      struct.setLegsiteslic(getgxTv_Sdtfaltas_y_tardes_Legsiteslic());
      struct.setLegsitesau(getgxTv_Sdtfaltas_y_tardes_Legsitesau());
      struct.setLegsitesafip(getgxTv_Sdtfaltas_y_tardes_Legsitesafip());
      struct.setLegsitcuentrab(getgxTv_Sdtfaltas_y_tardes_Legsitcuentrab());
      struct.setLegliccanpres(getgxTv_Sdtfaltas_y_tardes_Legliccanpres());
      struct.setLeglicremcorr(getgxTv_Sdtfaltas_y_tardes_Leglicremcorr());
      struct.setLeglicestado(getgxTv_Sdtfaltas_y_tardes_Leglicestado());
      struct.setMode(getgxTv_Sdtfaltas_y_tardes_Mode());
      struct.setInitialized(getgxTv_Sdtfaltas_y_tardes_Initialized());
      struct.setClicod_Z(getgxTv_Sdtfaltas_y_tardes_Clicod_Z());
      struct.setEmpcod_Z(getgxTv_Sdtfaltas_y_tardes_Empcod_Z());
      struct.setLegnumero_Z(getgxTv_Sdtfaltas_y_tardes_Legnumero_Z());
      struct.setLeglicenini_Z(getgxTv_Sdtfaltas_y_tardes_Leglicenini_Z());
      struct.setLeglicenfin_Z(getgxTv_Sdtfaltas_y_tardes_Leglicenfin_Z());
      struct.setLeglicsitcodigo_Z(getgxTv_Sdtfaltas_y_tardes_Leglicsitcodigo_Z());
      struct.setLeglicsitdescrip_Z(getgxTv_Sdtfaltas_y_tardes_Leglicsitdescrip_Z());
      struct.setLegliccntdias_Z(getgxTv_Sdtfaltas_y_tardes_Legliccntdias_Z());
      struct.setLeglicdescrip_Z(getgxTv_Sdtfaltas_y_tardes_Leglicdescrip_Z());
      struct.setLeglicconplus_Z(getgxTv_Sdtfaltas_y_tardes_Leglicconplus_Z());
      struct.setLegsiteslic_Z(getgxTv_Sdtfaltas_y_tardes_Legsiteslic_Z());
      struct.setLegsitesau_Z(getgxTv_Sdtfaltas_y_tardes_Legsitesau_Z());
      struct.setLegsitesafip_Z(getgxTv_Sdtfaltas_y_tardes_Legsitesafip_Z());
      struct.setLegsitcuentrab_Z(getgxTv_Sdtfaltas_y_tardes_Legsitcuentrab_Z());
      struct.setLegliccanpres_Z(getgxTv_Sdtfaltas_y_tardes_Legliccanpres_Z());
      struct.setLeglicremcorr_Z(getgxTv_Sdtfaltas_y_tardes_Leglicremcorr_Z());
      struct.setLeglicestado_Z(getgxTv_Sdtfaltas_y_tardes_Leglicestado_Z());
      return struct ;
   }

   private byte gxTv_Sdtfaltas_y_tardes_N ;
   private byte gxTv_Sdtfaltas_y_tardes_Legsiteslic ;
   private byte gxTv_Sdtfaltas_y_tardes_Legsitesau ;
   private byte gxTv_Sdtfaltas_y_tardes_Legsitesafip ;
   private byte gxTv_Sdtfaltas_y_tardes_Legsitcuentrab ;
   private byte gxTv_Sdtfaltas_y_tardes_Legliccanpres ;
   private byte gxTv_Sdtfaltas_y_tardes_Leglicremcorr ;
   private byte gxTv_Sdtfaltas_y_tardes_Legsiteslic_Z ;
   private byte gxTv_Sdtfaltas_y_tardes_Legsitesau_Z ;
   private byte gxTv_Sdtfaltas_y_tardes_Legsitesafip_Z ;
   private byte gxTv_Sdtfaltas_y_tardes_Legsitcuentrab_Z ;
   private byte gxTv_Sdtfaltas_y_tardes_Legliccanpres_Z ;
   private byte gxTv_Sdtfaltas_y_tardes_Leglicremcorr_Z ;
   private short gxTv_Sdtfaltas_y_tardes_Empcod ;
   private short gxTv_Sdtfaltas_y_tardes_Legliccntdias ;
   private short gxTv_Sdtfaltas_y_tardes_Initialized ;
   private short gxTv_Sdtfaltas_y_tardes_Empcod_Z ;
   private short gxTv_Sdtfaltas_y_tardes_Legliccntdias_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_Sdtfaltas_y_tardes_Clicod ;
   private int gxTv_Sdtfaltas_y_tardes_Legnumero ;
   private int gxTv_Sdtfaltas_y_tardes_Clicod_Z ;
   private int gxTv_Sdtfaltas_y_tardes_Legnumero_Z ;
   private String gxTv_Sdtfaltas_y_tardes_Leglicsitcodigo ;
   private String gxTv_Sdtfaltas_y_tardes_Leglicestado ;
   private String gxTv_Sdtfaltas_y_tardes_Mode ;
   private String gxTv_Sdtfaltas_y_tardes_Leglicsitcodigo_Z ;
   private String gxTv_Sdtfaltas_y_tardes_Leglicestado_Z ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_Sdtfaltas_y_tardes_Leglicenini ;
   private java.util.Date gxTv_Sdtfaltas_y_tardes_Leglicenfin ;
   private java.util.Date gxTv_Sdtfaltas_y_tardes_Leglicenini_Z ;
   private java.util.Date gxTv_Sdtfaltas_y_tardes_Leglicenfin_Z ;
   private boolean gxTv_Sdtfaltas_y_tardes_Leglicconplus ;
   private boolean gxTv_Sdtfaltas_y_tardes_Leglicconplus_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_Sdtfaltas_y_tardes_Leglicsitdescrip ;
   private String gxTv_Sdtfaltas_y_tardes_Leglicdescrip ;
   private String gxTv_Sdtfaltas_y_tardes_Leglicsitdescrip_Z ;
   private String gxTv_Sdtfaltas_y_tardes_Leglicdescrip_Z ;
}

