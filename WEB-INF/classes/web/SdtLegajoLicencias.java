package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtLegajoLicencias extends GxSilentTrnSdt
{
   public SdtLegajoLicencias( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtLegajoLicencias.class));
   }

   public SdtLegajoLicencias( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle, context, "SdtLegajoLicencias");
      initialize( remoteHandle) ;
   }

   public SdtLegajoLicencias( int remoteHandle ,
                              StructSdtLegajoLicencias struct )
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
      metadata.set("Name", "LegajoLicencias");
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
               gxTv_SdtLegajoLicencias_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod") )
            {
               gxTv_SdtLegajoLicencias_Empcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNumero") )
            {
               gxTv_SdtLegajoLicencias_Legnumero = (int)(getnumericvalue(oReader.getValue())) ;
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
                  gxTv_SdtLegajoLicencias_Leglicenini = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLegajoLicencias_Leglicenini = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
                  gxTv_SdtLegajoLicencias_Leglicenfin = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLegajoLicencias_Leglicenfin = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
               gxTv_SdtLegajoLicencias_Leglicsitcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicSitDescrip") )
            {
               gxTv_SdtLegajoLicencias_Leglicsitdescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicCntDias") )
            {
               gxTv_SdtLegajoLicencias_Legliccntdias = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicDescrip") )
            {
               gxTv_SdtLegajoLicencias_Leglicdescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicConPlus") )
            {
               gxTv_SdtLegajoLicencias_Leglicconplus = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtLegajoLicencias_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtLegajoLicencias_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_Z") )
            {
               gxTv_SdtLegajoLicencias_Clicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod_Z") )
            {
               gxTv_SdtLegajoLicencias_Empcod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNumero_Z") )
            {
               gxTv_SdtLegajoLicencias_Legnumero_Z = (int)(getnumericvalue(oReader.getValue())) ;
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
                  gxTv_SdtLegajoLicencias_Leglicenini_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLegajoLicencias_Leglicenini_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
                  gxTv_SdtLegajoLicencias_Leglicenfin_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLegajoLicencias_Leglicenfin_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
               gxTv_SdtLegajoLicencias_Leglicsitcodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicSitDescrip_Z") )
            {
               gxTv_SdtLegajoLicencias_Leglicsitdescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicCntDias_Z") )
            {
               gxTv_SdtLegajoLicencias_Legliccntdias_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicDescrip_Z") )
            {
               gxTv_SdtLegajoLicencias_Leglicdescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLicConPlus_Z") )
            {
               gxTv_SdtLegajoLicencias_Leglicconplus_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
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
         sName = "LegajoLicencias" ;
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
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_SdtLegajoLicencias_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCod", GXutil.trim( GXutil.str( gxTv_SdtLegajoLicencias_Empcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegNumero", GXutil.trim( GXutil.str( gxTv_SdtLegajoLicencias_Legnumero, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajoLicencias_Leglicenini), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajoLicencias_Leglicenini), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajoLicencias_Leglicenini), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("LegLicenIni", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajoLicencias_Leglicenfin), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajoLicencias_Leglicenfin), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajoLicencias_Leglicenfin), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("LegLicenFin", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegLicSitCodigo", gxTv_SdtLegajoLicencias_Leglicsitcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegLicSitDescrip", gxTv_SdtLegajoLicencias_Leglicsitdescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegLicCntDias", GXutil.trim( GXutil.str( gxTv_SdtLegajoLicencias_Legliccntdias, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegLicDescrip", gxTv_SdtLegajoLicencias_Leglicdescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegLicConPlus", GXutil.booltostr( gxTv_SdtLegajoLicencias_Leglicconplus));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtLegajoLicencias_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtLegajoLicencias_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajoLicencias_Clicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpCod_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajoLicencias_Empcod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegNumero_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajoLicencias_Legnumero_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajoLicencias_Leglicenini_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajoLicencias_Leglicenini_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajoLicencias_Leglicenini_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LegLicenIni_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajoLicencias_Leglicenfin_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajoLicencias_Leglicenfin_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajoLicencias_Leglicenfin_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LegLicenFin_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegLicSitCodigo_Z", gxTv_SdtLegajoLicencias_Leglicsitcodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegLicSitDescrip_Z", gxTv_SdtLegajoLicencias_Leglicsitdescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegLicCntDias_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajoLicencias_Legliccntdias_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegLicDescrip_Z", gxTv_SdtLegajoLicencias_Leglicdescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegLicConPlus_Z", GXutil.booltostr( gxTv_SdtLegajoLicencias_Leglicconplus_Z));
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
      AddObjectProperty("CliCod", gxTv_SdtLegajoLicencias_Clicod, false, includeNonInitialized);
      AddObjectProperty("EmpCod", gxTv_SdtLegajoLicencias_Empcod, false, includeNonInitialized);
      AddObjectProperty("LegNumero", gxTv_SdtLegajoLicencias_Legnumero, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajoLicencias_Leglicenini), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajoLicencias_Leglicenini), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajoLicencias_Leglicenini), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LegLicenIni", sDateCnv, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajoLicencias_Leglicenfin), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajoLicencias_Leglicenfin), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajoLicencias_Leglicenfin), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LegLicenFin", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("LegLicSitCodigo", gxTv_SdtLegajoLicencias_Leglicsitcodigo, false, includeNonInitialized);
      AddObjectProperty("LegLicSitDescrip", gxTv_SdtLegajoLicencias_Leglicsitdescrip, false, includeNonInitialized);
      AddObjectProperty("LegLicCntDias", gxTv_SdtLegajoLicencias_Legliccntdias, false, includeNonInitialized);
      AddObjectProperty("LegLicDescrip", gxTv_SdtLegajoLicencias_Leglicdescrip, false, includeNonInitialized);
      AddObjectProperty("LegLicConPlus", gxTv_SdtLegajoLicencias_Leglicconplus, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtLegajoLicencias_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtLegajoLicencias_Initialized, false, includeNonInitialized);
         AddObjectProperty("CliCod_Z", gxTv_SdtLegajoLicencias_Clicod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpCod_Z", gxTv_SdtLegajoLicencias_Empcod_Z, false, includeNonInitialized);
         AddObjectProperty("LegNumero_Z", gxTv_SdtLegajoLicencias_Legnumero_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajoLicencias_Leglicenini_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajoLicencias_Leglicenini_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajoLicencias_Leglicenini_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("LegLicenIni_Z", sDateCnv, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajoLicencias_Leglicenfin_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajoLicencias_Leglicenfin_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajoLicencias_Leglicenfin_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("LegLicenFin_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("LegLicSitCodigo_Z", gxTv_SdtLegajoLicencias_Leglicsitcodigo_Z, false, includeNonInitialized);
         AddObjectProperty("LegLicSitDescrip_Z", gxTv_SdtLegajoLicencias_Leglicsitdescrip_Z, false, includeNonInitialized);
         AddObjectProperty("LegLicCntDias_Z", gxTv_SdtLegajoLicencias_Legliccntdias_Z, false, includeNonInitialized);
         AddObjectProperty("LegLicDescrip_Z", gxTv_SdtLegajoLicencias_Leglicdescrip_Z, false, includeNonInitialized);
         AddObjectProperty("LegLicConPlus_Z", gxTv_SdtLegajoLicencias_Leglicconplus_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtLegajoLicencias sdt )
   {
      if ( sdt.IsDirty("CliCod") )
      {
         gxTv_SdtLegajoLicencias_N = (byte)(0) ;
         gxTv_SdtLegajoLicencias_Clicod = sdt.getgxTv_SdtLegajoLicencias_Clicod() ;
      }
      if ( sdt.IsDirty("EmpCod") )
      {
         gxTv_SdtLegajoLicencias_N = (byte)(0) ;
         gxTv_SdtLegajoLicencias_Empcod = sdt.getgxTv_SdtLegajoLicencias_Empcod() ;
      }
      if ( sdt.IsDirty("LegNumero") )
      {
         gxTv_SdtLegajoLicencias_N = (byte)(0) ;
         gxTv_SdtLegajoLicencias_Legnumero = sdt.getgxTv_SdtLegajoLicencias_Legnumero() ;
      }
      if ( sdt.IsDirty("LegLicenIni") )
      {
         gxTv_SdtLegajoLicencias_N = (byte)(0) ;
         gxTv_SdtLegajoLicencias_Leglicenini = sdt.getgxTv_SdtLegajoLicencias_Leglicenini() ;
      }
      if ( sdt.IsDirty("LegLicenFin") )
      {
         gxTv_SdtLegajoLicencias_N = (byte)(0) ;
         gxTv_SdtLegajoLicencias_Leglicenfin = sdt.getgxTv_SdtLegajoLicencias_Leglicenfin() ;
      }
      if ( sdt.IsDirty("LegLicSitCodigo") )
      {
         gxTv_SdtLegajoLicencias_N = (byte)(0) ;
         gxTv_SdtLegajoLicencias_Leglicsitcodigo = sdt.getgxTv_SdtLegajoLicencias_Leglicsitcodigo() ;
      }
      if ( sdt.IsDirty("LegLicSitDescrip") )
      {
         gxTv_SdtLegajoLicencias_N = (byte)(0) ;
         gxTv_SdtLegajoLicencias_Leglicsitdescrip = sdt.getgxTv_SdtLegajoLicencias_Leglicsitdescrip() ;
      }
      if ( sdt.IsDirty("LegLicCntDias") )
      {
         gxTv_SdtLegajoLicencias_N = (byte)(0) ;
         gxTv_SdtLegajoLicencias_Legliccntdias = sdt.getgxTv_SdtLegajoLicencias_Legliccntdias() ;
      }
      if ( sdt.IsDirty("LegLicDescrip") )
      {
         gxTv_SdtLegajoLicencias_N = (byte)(0) ;
         gxTv_SdtLegajoLicencias_Leglicdescrip = sdt.getgxTv_SdtLegajoLicencias_Leglicdescrip() ;
      }
      if ( sdt.IsDirty("LegLicConPlus") )
      {
         gxTv_SdtLegajoLicencias_N = (byte)(0) ;
         gxTv_SdtLegajoLicencias_Leglicconplus = sdt.getgxTv_SdtLegajoLicencias_Leglicconplus() ;
      }
   }

   public int getgxTv_SdtLegajoLicencias_Clicod( )
   {
      return gxTv_SdtLegajoLicencias_Clicod ;
   }

   public void setgxTv_SdtLegajoLicencias_Clicod( int value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      if ( gxTv_SdtLegajoLicencias_Clicod != value )
      {
         gxTv_SdtLegajoLicencias_Mode = "INS" ;
         this.setgxTv_SdtLegajoLicencias_Clicod_Z_SetNull( );
         this.setgxTv_SdtLegajoLicencias_Empcod_Z_SetNull( );
         this.setgxTv_SdtLegajoLicencias_Legnumero_Z_SetNull( );
         this.setgxTv_SdtLegajoLicencias_Leglicenini_Z_SetNull( );
         this.setgxTv_SdtLegajoLicencias_Leglicenfin_Z_SetNull( );
         this.setgxTv_SdtLegajoLicencias_Leglicsitcodigo_Z_SetNull( );
         this.setgxTv_SdtLegajoLicencias_Leglicsitdescrip_Z_SetNull( );
         this.setgxTv_SdtLegajoLicencias_Legliccntdias_Z_SetNull( );
         this.setgxTv_SdtLegajoLicencias_Leglicdescrip_Z_SetNull( );
         this.setgxTv_SdtLegajoLicencias_Leglicconplus_Z_SetNull( );
      }
      SetDirty("Clicod");
      gxTv_SdtLegajoLicencias_Clicod = value ;
   }

   public short getgxTv_SdtLegajoLicencias_Empcod( )
   {
      return gxTv_SdtLegajoLicencias_Empcod ;
   }

   public void setgxTv_SdtLegajoLicencias_Empcod( short value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      if ( gxTv_SdtLegajoLicencias_Empcod != value )
      {
         gxTv_SdtLegajoLicencias_Mode = "INS" ;
         this.setgxTv_SdtLegajoLicencias_Clicod_Z_SetNull( );
         this.setgxTv_SdtLegajoLicencias_Empcod_Z_SetNull( );
         this.setgxTv_SdtLegajoLicencias_Legnumero_Z_SetNull( );
         this.setgxTv_SdtLegajoLicencias_Leglicenini_Z_SetNull( );
         this.setgxTv_SdtLegajoLicencias_Leglicenfin_Z_SetNull( );
         this.setgxTv_SdtLegajoLicencias_Leglicsitcodigo_Z_SetNull( );
         this.setgxTv_SdtLegajoLicencias_Leglicsitdescrip_Z_SetNull( );
         this.setgxTv_SdtLegajoLicencias_Legliccntdias_Z_SetNull( );
         this.setgxTv_SdtLegajoLicencias_Leglicdescrip_Z_SetNull( );
         this.setgxTv_SdtLegajoLicencias_Leglicconplus_Z_SetNull( );
      }
      SetDirty("Empcod");
      gxTv_SdtLegajoLicencias_Empcod = value ;
   }

   public int getgxTv_SdtLegajoLicencias_Legnumero( )
   {
      return gxTv_SdtLegajoLicencias_Legnumero ;
   }

   public void setgxTv_SdtLegajoLicencias_Legnumero( int value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      if ( gxTv_SdtLegajoLicencias_Legnumero != value )
      {
         gxTv_SdtLegajoLicencias_Mode = "INS" ;
         this.setgxTv_SdtLegajoLicencias_Clicod_Z_SetNull( );
         this.setgxTv_SdtLegajoLicencias_Empcod_Z_SetNull( );
         this.setgxTv_SdtLegajoLicencias_Legnumero_Z_SetNull( );
         this.setgxTv_SdtLegajoLicencias_Leglicenini_Z_SetNull( );
         this.setgxTv_SdtLegajoLicencias_Leglicenfin_Z_SetNull( );
         this.setgxTv_SdtLegajoLicencias_Leglicsitcodigo_Z_SetNull( );
         this.setgxTv_SdtLegajoLicencias_Leglicsitdescrip_Z_SetNull( );
         this.setgxTv_SdtLegajoLicencias_Legliccntdias_Z_SetNull( );
         this.setgxTv_SdtLegajoLicencias_Leglicdescrip_Z_SetNull( );
         this.setgxTv_SdtLegajoLicencias_Leglicconplus_Z_SetNull( );
      }
      SetDirty("Legnumero");
      gxTv_SdtLegajoLicencias_Legnumero = value ;
   }

   public java.util.Date getgxTv_SdtLegajoLicencias_Leglicenini( )
   {
      return gxTv_SdtLegajoLicencias_Leglicenini ;
   }

   public void setgxTv_SdtLegajoLicencias_Leglicenini( java.util.Date value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      if ( !( GXutil.dateCompare(GXutil.resetTime(gxTv_SdtLegajoLicencias_Leglicenini), GXutil.resetTime(value)) ) )
      {
         gxTv_SdtLegajoLicencias_Mode = "INS" ;
         this.setgxTv_SdtLegajoLicencias_Clicod_Z_SetNull( );
         this.setgxTv_SdtLegajoLicencias_Empcod_Z_SetNull( );
         this.setgxTv_SdtLegajoLicencias_Legnumero_Z_SetNull( );
         this.setgxTv_SdtLegajoLicencias_Leglicenini_Z_SetNull( );
         this.setgxTv_SdtLegajoLicencias_Leglicenfin_Z_SetNull( );
         this.setgxTv_SdtLegajoLicencias_Leglicsitcodigo_Z_SetNull( );
         this.setgxTv_SdtLegajoLicencias_Leglicsitdescrip_Z_SetNull( );
         this.setgxTv_SdtLegajoLicencias_Legliccntdias_Z_SetNull( );
         this.setgxTv_SdtLegajoLicencias_Leglicdescrip_Z_SetNull( );
         this.setgxTv_SdtLegajoLicencias_Leglicconplus_Z_SetNull( );
      }
      SetDirty("Leglicenini");
      gxTv_SdtLegajoLicencias_Leglicenini = value ;
   }

   public java.util.Date getgxTv_SdtLegajoLicencias_Leglicenfin( )
   {
      return gxTv_SdtLegajoLicencias_Leglicenfin ;
   }

   public void setgxTv_SdtLegajoLicencias_Leglicenfin( java.util.Date value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      SetDirty("Leglicenfin");
      gxTv_SdtLegajoLicencias_Leglicenfin = value ;
   }

   public String getgxTv_SdtLegajoLicencias_Leglicsitcodigo( )
   {
      return gxTv_SdtLegajoLicencias_Leglicsitcodigo ;
   }

   public void setgxTv_SdtLegajoLicencias_Leglicsitcodigo( String value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      SetDirty("Leglicsitcodigo");
      gxTv_SdtLegajoLicencias_Leglicsitcodigo = value ;
   }

   public String getgxTv_SdtLegajoLicencias_Leglicsitdescrip( )
   {
      return gxTv_SdtLegajoLicencias_Leglicsitdescrip ;
   }

   public void setgxTv_SdtLegajoLicencias_Leglicsitdescrip( String value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      SetDirty("Leglicsitdescrip");
      gxTv_SdtLegajoLicencias_Leglicsitdescrip = value ;
   }

   public short getgxTv_SdtLegajoLicencias_Legliccntdias( )
   {
      return gxTv_SdtLegajoLicencias_Legliccntdias ;
   }

   public void setgxTv_SdtLegajoLicencias_Legliccntdias( short value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      SetDirty("Legliccntdias");
      gxTv_SdtLegajoLicencias_Legliccntdias = value ;
   }

   public void setgxTv_SdtLegajoLicencias_Legliccntdias_SetNull( )
   {
      gxTv_SdtLegajoLicencias_Legliccntdias = (short)(0) ;
      SetDirty("Legliccntdias");
   }

   public boolean getgxTv_SdtLegajoLicencias_Legliccntdias_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajoLicencias_Leglicdescrip( )
   {
      return gxTv_SdtLegajoLicencias_Leglicdescrip ;
   }

   public void setgxTv_SdtLegajoLicencias_Leglicdescrip( String value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      SetDirty("Leglicdescrip");
      gxTv_SdtLegajoLicencias_Leglicdescrip = value ;
   }

   public boolean getgxTv_SdtLegajoLicencias_Leglicconplus( )
   {
      return gxTv_SdtLegajoLicencias_Leglicconplus ;
   }

   public void setgxTv_SdtLegajoLicencias_Leglicconplus( boolean value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      SetDirty("Leglicconplus");
      gxTv_SdtLegajoLicencias_Leglicconplus = value ;
   }

   public String getgxTv_SdtLegajoLicencias_Mode( )
   {
      return gxTv_SdtLegajoLicencias_Mode ;
   }

   public void setgxTv_SdtLegajoLicencias_Mode( String value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtLegajoLicencias_Mode = value ;
   }

   public void setgxTv_SdtLegajoLicencias_Mode_SetNull( )
   {
      gxTv_SdtLegajoLicencias_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtLegajoLicencias_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLegajoLicencias_Initialized( )
   {
      return gxTv_SdtLegajoLicencias_Initialized ;
   }

   public void setgxTv_SdtLegajoLicencias_Initialized( short value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtLegajoLicencias_Initialized = value ;
   }

   public void setgxTv_SdtLegajoLicencias_Initialized_SetNull( )
   {
      gxTv_SdtLegajoLicencias_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtLegajoLicencias_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtLegajoLicencias_Clicod_Z( )
   {
      return gxTv_SdtLegajoLicencias_Clicod_Z ;
   }

   public void setgxTv_SdtLegajoLicencias_Clicod_Z( int value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      SetDirty("Clicod_Z");
      gxTv_SdtLegajoLicencias_Clicod_Z = value ;
   }

   public void setgxTv_SdtLegajoLicencias_Clicod_Z_SetNull( )
   {
      gxTv_SdtLegajoLicencias_Clicod_Z = 0 ;
      SetDirty("Clicod_Z");
   }

   public boolean getgxTv_SdtLegajoLicencias_Clicod_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLegajoLicencias_Empcod_Z( )
   {
      return gxTv_SdtLegajoLicencias_Empcod_Z ;
   }

   public void setgxTv_SdtLegajoLicencias_Empcod_Z( short value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      SetDirty("Empcod_Z");
      gxTv_SdtLegajoLicencias_Empcod_Z = value ;
   }

   public void setgxTv_SdtLegajoLicencias_Empcod_Z_SetNull( )
   {
      gxTv_SdtLegajoLicencias_Empcod_Z = (short)(0) ;
      SetDirty("Empcod_Z");
   }

   public boolean getgxTv_SdtLegajoLicencias_Empcod_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtLegajoLicencias_Legnumero_Z( )
   {
      return gxTv_SdtLegajoLicencias_Legnumero_Z ;
   }

   public void setgxTv_SdtLegajoLicencias_Legnumero_Z( int value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      SetDirty("Legnumero_Z");
      gxTv_SdtLegajoLicencias_Legnumero_Z = value ;
   }

   public void setgxTv_SdtLegajoLicencias_Legnumero_Z_SetNull( )
   {
      gxTv_SdtLegajoLicencias_Legnumero_Z = 0 ;
      SetDirty("Legnumero_Z");
   }

   public boolean getgxTv_SdtLegajoLicencias_Legnumero_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtLegajoLicencias_Leglicenini_Z( )
   {
      return gxTv_SdtLegajoLicencias_Leglicenini_Z ;
   }

   public void setgxTv_SdtLegajoLicencias_Leglicenini_Z( java.util.Date value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      SetDirty("Leglicenini_Z");
      gxTv_SdtLegajoLicencias_Leglicenini_Z = value ;
   }

   public void setgxTv_SdtLegajoLicencias_Leglicenini_Z_SetNull( )
   {
      gxTv_SdtLegajoLicencias_Leglicenini_Z = GXutil.nullDate() ;
      SetDirty("Leglicenini_Z");
   }

   public boolean getgxTv_SdtLegajoLicencias_Leglicenini_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtLegajoLicencias_Leglicenfin_Z( )
   {
      return gxTv_SdtLegajoLicencias_Leglicenfin_Z ;
   }

   public void setgxTv_SdtLegajoLicencias_Leglicenfin_Z( java.util.Date value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      SetDirty("Leglicenfin_Z");
      gxTv_SdtLegajoLicencias_Leglicenfin_Z = value ;
   }

   public void setgxTv_SdtLegajoLicencias_Leglicenfin_Z_SetNull( )
   {
      gxTv_SdtLegajoLicencias_Leglicenfin_Z = GXutil.nullDate() ;
      SetDirty("Leglicenfin_Z");
   }

   public boolean getgxTv_SdtLegajoLicencias_Leglicenfin_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajoLicencias_Leglicsitcodigo_Z( )
   {
      return gxTv_SdtLegajoLicencias_Leglicsitcodigo_Z ;
   }

   public void setgxTv_SdtLegajoLicencias_Leglicsitcodigo_Z( String value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      SetDirty("Leglicsitcodigo_Z");
      gxTv_SdtLegajoLicencias_Leglicsitcodigo_Z = value ;
   }

   public void setgxTv_SdtLegajoLicencias_Leglicsitcodigo_Z_SetNull( )
   {
      gxTv_SdtLegajoLicencias_Leglicsitcodigo_Z = "" ;
      SetDirty("Leglicsitcodigo_Z");
   }

   public boolean getgxTv_SdtLegajoLicencias_Leglicsitcodigo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajoLicencias_Leglicsitdescrip_Z( )
   {
      return gxTv_SdtLegajoLicencias_Leglicsitdescrip_Z ;
   }

   public void setgxTv_SdtLegajoLicencias_Leglicsitdescrip_Z( String value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      SetDirty("Leglicsitdescrip_Z");
      gxTv_SdtLegajoLicencias_Leglicsitdescrip_Z = value ;
   }

   public void setgxTv_SdtLegajoLicencias_Leglicsitdescrip_Z_SetNull( )
   {
      gxTv_SdtLegajoLicencias_Leglicsitdescrip_Z = "" ;
      SetDirty("Leglicsitdescrip_Z");
   }

   public boolean getgxTv_SdtLegajoLicencias_Leglicsitdescrip_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLegajoLicencias_Legliccntdias_Z( )
   {
      return gxTv_SdtLegajoLicencias_Legliccntdias_Z ;
   }

   public void setgxTv_SdtLegajoLicencias_Legliccntdias_Z( short value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      SetDirty("Legliccntdias_Z");
      gxTv_SdtLegajoLicencias_Legliccntdias_Z = value ;
   }

   public void setgxTv_SdtLegajoLicencias_Legliccntdias_Z_SetNull( )
   {
      gxTv_SdtLegajoLicencias_Legliccntdias_Z = (short)(0) ;
      SetDirty("Legliccntdias_Z");
   }

   public boolean getgxTv_SdtLegajoLicencias_Legliccntdias_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajoLicencias_Leglicdescrip_Z( )
   {
      return gxTv_SdtLegajoLicencias_Leglicdescrip_Z ;
   }

   public void setgxTv_SdtLegajoLicencias_Leglicdescrip_Z( String value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      SetDirty("Leglicdescrip_Z");
      gxTv_SdtLegajoLicencias_Leglicdescrip_Z = value ;
   }

   public void setgxTv_SdtLegajoLicencias_Leglicdescrip_Z_SetNull( )
   {
      gxTv_SdtLegajoLicencias_Leglicdescrip_Z = "" ;
      SetDirty("Leglicdescrip_Z");
   }

   public boolean getgxTv_SdtLegajoLicencias_Leglicdescrip_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtLegajoLicencias_Leglicconplus_Z( )
   {
      return gxTv_SdtLegajoLicencias_Leglicconplus_Z ;
   }

   public void setgxTv_SdtLegajoLicencias_Leglicconplus_Z( boolean value )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(0) ;
      SetDirty("Leglicconplus_Z");
      gxTv_SdtLegajoLicencias_Leglicconplus_Z = value ;
   }

   public void setgxTv_SdtLegajoLicencias_Leglicconplus_Z_SetNull( )
   {
      gxTv_SdtLegajoLicencias_Leglicconplus_Z = false ;
      SetDirty("Leglicconplus_Z");
   }

   public boolean getgxTv_SdtLegajoLicencias_Leglicconplus_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.legajolicencias_bc obj;
      obj = new web.legajolicencias_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtLegajoLicencias_N = (byte)(1) ;
      gxTv_SdtLegajoLicencias_Leglicenini = GXutil.nullDate() ;
      gxTv_SdtLegajoLicencias_Leglicenfin = GXutil.nullDate() ;
      gxTv_SdtLegajoLicencias_Leglicsitcodigo = "" ;
      gxTv_SdtLegajoLicencias_Leglicsitdescrip = "" ;
      gxTv_SdtLegajoLicencias_Leglicdescrip = "" ;
      gxTv_SdtLegajoLicencias_Mode = "" ;
      gxTv_SdtLegajoLicencias_Leglicenini_Z = GXutil.nullDate() ;
      gxTv_SdtLegajoLicencias_Leglicenfin_Z = GXutil.nullDate() ;
      gxTv_SdtLegajoLicencias_Leglicsitcodigo_Z = "" ;
      gxTv_SdtLegajoLicencias_Leglicsitdescrip_Z = "" ;
      gxTv_SdtLegajoLicencias_Leglicdescrip_Z = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtLegajoLicencias_N ;
   }

   public web.SdtLegajoLicencias Clone( )
   {
      web.SdtLegajoLicencias sdt;
      web.legajolicencias_bc obj;
      sdt = (web.SdtLegajoLicencias)(clone()) ;
      obj = (web.legajolicencias_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtLegajoLicencias struct )
   {
      setgxTv_SdtLegajoLicencias_Clicod(struct.getClicod());
      setgxTv_SdtLegajoLicencias_Empcod(struct.getEmpcod());
      setgxTv_SdtLegajoLicencias_Legnumero(struct.getLegnumero());
      setgxTv_SdtLegajoLicencias_Leglicenini(struct.getLeglicenini());
      setgxTv_SdtLegajoLicencias_Leglicenfin(struct.getLeglicenfin());
      setgxTv_SdtLegajoLicencias_Leglicsitcodigo(struct.getLeglicsitcodigo());
      setgxTv_SdtLegajoLicencias_Leglicsitdescrip(struct.getLeglicsitdescrip());
      setgxTv_SdtLegajoLicencias_Legliccntdias(struct.getLegliccntdias());
      setgxTv_SdtLegajoLicencias_Leglicdescrip(struct.getLeglicdescrip());
      setgxTv_SdtLegajoLicencias_Leglicconplus(struct.getLeglicconplus());
      setgxTv_SdtLegajoLicencias_Mode(struct.getMode());
      setgxTv_SdtLegajoLicencias_Initialized(struct.getInitialized());
      setgxTv_SdtLegajoLicencias_Clicod_Z(struct.getClicod_Z());
      setgxTv_SdtLegajoLicencias_Empcod_Z(struct.getEmpcod_Z());
      setgxTv_SdtLegajoLicencias_Legnumero_Z(struct.getLegnumero_Z());
      setgxTv_SdtLegajoLicencias_Leglicenini_Z(struct.getLeglicenini_Z());
      setgxTv_SdtLegajoLicencias_Leglicenfin_Z(struct.getLeglicenfin_Z());
      setgxTv_SdtLegajoLicencias_Leglicsitcodigo_Z(struct.getLeglicsitcodigo_Z());
      setgxTv_SdtLegajoLicencias_Leglicsitdescrip_Z(struct.getLeglicsitdescrip_Z());
      setgxTv_SdtLegajoLicencias_Legliccntdias_Z(struct.getLegliccntdias_Z());
      setgxTv_SdtLegajoLicencias_Leglicdescrip_Z(struct.getLeglicdescrip_Z());
      setgxTv_SdtLegajoLicencias_Leglicconplus_Z(struct.getLeglicconplus_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtLegajoLicencias getStruct( )
   {
      web.StructSdtLegajoLicencias struct = new web.StructSdtLegajoLicencias ();
      struct.setClicod(getgxTv_SdtLegajoLicencias_Clicod());
      struct.setEmpcod(getgxTv_SdtLegajoLicencias_Empcod());
      struct.setLegnumero(getgxTv_SdtLegajoLicencias_Legnumero());
      struct.setLeglicenini(getgxTv_SdtLegajoLicencias_Leglicenini());
      struct.setLeglicenfin(getgxTv_SdtLegajoLicencias_Leglicenfin());
      struct.setLeglicsitcodigo(getgxTv_SdtLegajoLicencias_Leglicsitcodigo());
      struct.setLeglicsitdescrip(getgxTv_SdtLegajoLicencias_Leglicsitdescrip());
      struct.setLegliccntdias(getgxTv_SdtLegajoLicencias_Legliccntdias());
      struct.setLeglicdescrip(getgxTv_SdtLegajoLicencias_Leglicdescrip());
      struct.setLeglicconplus(getgxTv_SdtLegajoLicencias_Leglicconplus());
      struct.setMode(getgxTv_SdtLegajoLicencias_Mode());
      struct.setInitialized(getgxTv_SdtLegajoLicencias_Initialized());
      struct.setClicod_Z(getgxTv_SdtLegajoLicencias_Clicod_Z());
      struct.setEmpcod_Z(getgxTv_SdtLegajoLicencias_Empcod_Z());
      struct.setLegnumero_Z(getgxTv_SdtLegajoLicencias_Legnumero_Z());
      struct.setLeglicenini_Z(getgxTv_SdtLegajoLicencias_Leglicenini_Z());
      struct.setLeglicenfin_Z(getgxTv_SdtLegajoLicencias_Leglicenfin_Z());
      struct.setLeglicsitcodigo_Z(getgxTv_SdtLegajoLicencias_Leglicsitcodigo_Z());
      struct.setLeglicsitdescrip_Z(getgxTv_SdtLegajoLicencias_Leglicsitdescrip_Z());
      struct.setLegliccntdias_Z(getgxTv_SdtLegajoLicencias_Legliccntdias_Z());
      struct.setLeglicdescrip_Z(getgxTv_SdtLegajoLicencias_Leglicdescrip_Z());
      struct.setLeglicconplus_Z(getgxTv_SdtLegajoLicencias_Leglicconplus_Z());
      return struct ;
   }

   private byte gxTv_SdtLegajoLicencias_N ;
   private short gxTv_SdtLegajoLicencias_Empcod ;
   private short gxTv_SdtLegajoLicencias_Legliccntdias ;
   private short gxTv_SdtLegajoLicencias_Initialized ;
   private short gxTv_SdtLegajoLicencias_Empcod_Z ;
   private short gxTv_SdtLegajoLicencias_Legliccntdias_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtLegajoLicencias_Clicod ;
   private int gxTv_SdtLegajoLicencias_Legnumero ;
   private int gxTv_SdtLegajoLicencias_Clicod_Z ;
   private int gxTv_SdtLegajoLicencias_Legnumero_Z ;
   private String gxTv_SdtLegajoLicencias_Leglicsitcodigo ;
   private String gxTv_SdtLegajoLicencias_Mode ;
   private String gxTv_SdtLegajoLicencias_Leglicsitcodigo_Z ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtLegajoLicencias_Leglicenini ;
   private java.util.Date gxTv_SdtLegajoLicencias_Leglicenfin ;
   private java.util.Date gxTv_SdtLegajoLicencias_Leglicenini_Z ;
   private java.util.Date gxTv_SdtLegajoLicencias_Leglicenfin_Z ;
   private boolean gxTv_SdtLegajoLicencias_Leglicconplus ;
   private boolean gxTv_SdtLegajoLicencias_Leglicconplus_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtLegajoLicencias_Leglicsitdescrip ;
   private String gxTv_SdtLegajoLicencias_Leglicdescrip ;
   private String gxTv_SdtLegajoLicencias_Leglicsitdescrip_Z ;
   private String gxTv_SdtLegajoLicencias_Leglicdescrip_Z ;
}

