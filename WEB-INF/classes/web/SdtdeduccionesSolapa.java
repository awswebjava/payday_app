package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtdeduccionesSolapa extends GxSilentTrnSdt
{
   public SdtdeduccionesSolapa( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtdeduccionesSolapa.class));
   }

   public SdtdeduccionesSolapa( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle, context, "SdtdeduccionesSolapa");
      initialize( remoteHandle) ;
   }

   public SdtdeduccionesSolapa( int remoteHandle ,
                                StructSdtdeduccionesSolapa struct )
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
                     int AV83LegDedSec )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV3CliCod),Short.valueOf(AV1EmpCod),Integer.valueOf(AV6LegNumero),Integer.valueOf(AV83LegDedSec)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CliCod", int.class}, new Object[]{"EmpCod", short.class}, new Object[]{"LegNumero", int.class}, new Object[]{"LegDedSec", int.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "deduccionesSolapa");
      metadata.set("BT", "legajo_deducciones");
      metadata.set("PK", "[ \"CliCod\",\"EmpCod\",\"LegNumero\",\"LegDedSec\" ]");
      metadata.set("PKAssigned", "[ \"CliCod\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\",\"ConCodigo\" ],\"FKMap\":[ \"LegDedConCodigo-ConCodigo\" ] },{ \"FK\":[ \"CliCod\",\"EmpCod\",\"LegNumero\" ],\"FKMap\":[  ] } ]");
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
               gxTv_SdtdeduccionesSolapa_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod") )
            {
               gxTv_SdtdeduccionesSolapa_Empcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNumero") )
            {
               gxTv_SdtdeduccionesSolapa_Legnumero = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegDedSec") )
            {
               gxTv_SdtdeduccionesSolapa_Legdedsec = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegDedFchDes") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtdeduccionesSolapa_Legdedfchdes = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtdeduccionesSolapa_Legdedfchdes = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegDedFchHas") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtdeduccionesSolapa_Legdedfchhas = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtdeduccionesSolapa_Legdedfchhas = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegDedConCodigo") )
            {
               gxTv_SdtdeduccionesSolapa_Legdedconcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegDedConDescrip") )
            {
               gxTv_SdtdeduccionesSolapa_Legdedcondescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegIdNomApe") )
            {
               gxTv_SdtdeduccionesSolapa_Legidnomape = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegDedImporte") )
            {
               gxTv_SdtdeduccionesSolapa_Legdedimporte = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegDedDescrip") )
            {
               gxTv_SdtdeduccionesSolapa_Legdeddescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegDedConCodYDesc") )
            {
               gxTv_SdtdeduccionesSolapa_Legdedconcodydesc = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtdeduccionesSolapa_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtdeduccionesSolapa_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_Z") )
            {
               gxTv_SdtdeduccionesSolapa_Clicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod_Z") )
            {
               gxTv_SdtdeduccionesSolapa_Empcod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNumero_Z") )
            {
               gxTv_SdtdeduccionesSolapa_Legnumero_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegDedSec_Z") )
            {
               gxTv_SdtdeduccionesSolapa_Legdedsec_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegDedFchDes_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtdeduccionesSolapa_Legdedfchdes_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtdeduccionesSolapa_Legdedfchdes_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegDedFchHas_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtdeduccionesSolapa_Legdedfchhas_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtdeduccionesSolapa_Legdedfchhas_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegDedConCodigo_Z") )
            {
               gxTv_SdtdeduccionesSolapa_Legdedconcodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegDedConDescrip_Z") )
            {
               gxTv_SdtdeduccionesSolapa_Legdedcondescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegIdNomApe_Z") )
            {
               gxTv_SdtdeduccionesSolapa_Legidnomape_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegDedImporte_Z") )
            {
               gxTv_SdtdeduccionesSolapa_Legdedimporte_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegDedDescrip_Z") )
            {
               gxTv_SdtdeduccionesSolapa_Legdeddescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegDedConCodYDesc_Z") )
            {
               gxTv_SdtdeduccionesSolapa_Legdedconcodydesc_Z = oReader.getValue() ;
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
         sName = "deduccionesSolapa" ;
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
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_SdtdeduccionesSolapa_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCod", GXutil.trim( GXutil.str( gxTv_SdtdeduccionesSolapa_Empcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegNumero", GXutil.trim( GXutil.str( gxTv_SdtdeduccionesSolapa_Legnumero, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegDedSec", GXutil.trim( GXutil.str( gxTv_SdtdeduccionesSolapa_Legdedsec, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtdeduccionesSolapa_Legdedfchdes), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtdeduccionesSolapa_Legdedfchdes), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtdeduccionesSolapa_Legdedfchdes), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("LegDedFchDes", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtdeduccionesSolapa_Legdedfchhas), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtdeduccionesSolapa_Legdedfchhas), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtdeduccionesSolapa_Legdedfchhas), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("LegDedFchHas", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegDedConCodigo", gxTv_SdtdeduccionesSolapa_Legdedconcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegDedConDescrip", gxTv_SdtdeduccionesSolapa_Legdedcondescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegIdNomApe", gxTv_SdtdeduccionesSolapa_Legidnomape);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegDedImporte", GXutil.trim( GXutil.strNoRound( gxTv_SdtdeduccionesSolapa_Legdedimporte, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegDedDescrip", gxTv_SdtdeduccionesSolapa_Legdeddescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegDedConCodYDesc", gxTv_SdtdeduccionesSolapa_Legdedconcodydesc);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtdeduccionesSolapa_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtdeduccionesSolapa_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_Z", GXutil.trim( GXutil.str( gxTv_SdtdeduccionesSolapa_Clicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpCod_Z", GXutil.trim( GXutil.str( gxTv_SdtdeduccionesSolapa_Empcod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegNumero_Z", GXutil.trim( GXutil.str( gxTv_SdtdeduccionesSolapa_Legnumero_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegDedSec_Z", GXutil.trim( GXutil.str( gxTv_SdtdeduccionesSolapa_Legdedsec_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtdeduccionesSolapa_Legdedfchdes_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtdeduccionesSolapa_Legdedfchdes_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtdeduccionesSolapa_Legdedfchdes_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LegDedFchDes_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtdeduccionesSolapa_Legdedfchhas_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtdeduccionesSolapa_Legdedfchhas_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtdeduccionesSolapa_Legdedfchhas_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LegDedFchHas_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegDedConCodigo_Z", gxTv_SdtdeduccionesSolapa_Legdedconcodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegDedConDescrip_Z", gxTv_SdtdeduccionesSolapa_Legdedcondescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegIdNomApe_Z", gxTv_SdtdeduccionesSolapa_Legidnomape_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegDedImporte_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtdeduccionesSolapa_Legdedimporte_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegDedDescrip_Z", gxTv_SdtdeduccionesSolapa_Legdeddescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegDedConCodYDesc_Z", gxTv_SdtdeduccionesSolapa_Legdedconcodydesc_Z);
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
      AddObjectProperty("CliCod", gxTv_SdtdeduccionesSolapa_Clicod, false, includeNonInitialized);
      AddObjectProperty("EmpCod", gxTv_SdtdeduccionesSolapa_Empcod, false, includeNonInitialized);
      AddObjectProperty("LegNumero", gxTv_SdtdeduccionesSolapa_Legnumero, false, includeNonInitialized);
      AddObjectProperty("LegDedSec", gxTv_SdtdeduccionesSolapa_Legdedsec, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtdeduccionesSolapa_Legdedfchdes), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtdeduccionesSolapa_Legdedfchdes), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtdeduccionesSolapa_Legdedfchdes), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LegDedFchDes", sDateCnv, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtdeduccionesSolapa_Legdedfchhas), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtdeduccionesSolapa_Legdedfchhas), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtdeduccionesSolapa_Legdedfchhas), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LegDedFchHas", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("LegDedConCodigo", gxTv_SdtdeduccionesSolapa_Legdedconcodigo, false, includeNonInitialized);
      AddObjectProperty("LegDedConDescrip", gxTv_SdtdeduccionesSolapa_Legdedcondescrip, false, includeNonInitialized);
      AddObjectProperty("LegIdNomApe", gxTv_SdtdeduccionesSolapa_Legidnomape, false, includeNonInitialized);
      AddObjectProperty("LegDedImporte", gxTv_SdtdeduccionesSolapa_Legdedimporte, false, includeNonInitialized);
      AddObjectProperty("LegDedDescrip", gxTv_SdtdeduccionesSolapa_Legdeddescrip, false, includeNonInitialized);
      AddObjectProperty("LegDedConCodYDesc", gxTv_SdtdeduccionesSolapa_Legdedconcodydesc, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtdeduccionesSolapa_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtdeduccionesSolapa_Initialized, false, includeNonInitialized);
         AddObjectProperty("CliCod_Z", gxTv_SdtdeduccionesSolapa_Clicod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpCod_Z", gxTv_SdtdeduccionesSolapa_Empcod_Z, false, includeNonInitialized);
         AddObjectProperty("LegNumero_Z", gxTv_SdtdeduccionesSolapa_Legnumero_Z, false, includeNonInitialized);
         AddObjectProperty("LegDedSec_Z", gxTv_SdtdeduccionesSolapa_Legdedsec_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtdeduccionesSolapa_Legdedfchdes_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtdeduccionesSolapa_Legdedfchdes_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtdeduccionesSolapa_Legdedfchdes_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("LegDedFchDes_Z", sDateCnv, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtdeduccionesSolapa_Legdedfchhas_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtdeduccionesSolapa_Legdedfchhas_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtdeduccionesSolapa_Legdedfchhas_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("LegDedFchHas_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("LegDedConCodigo_Z", gxTv_SdtdeduccionesSolapa_Legdedconcodigo_Z, false, includeNonInitialized);
         AddObjectProperty("LegDedConDescrip_Z", gxTv_SdtdeduccionesSolapa_Legdedcondescrip_Z, false, includeNonInitialized);
         AddObjectProperty("LegIdNomApe_Z", gxTv_SdtdeduccionesSolapa_Legidnomape_Z, false, includeNonInitialized);
         AddObjectProperty("LegDedImporte_Z", gxTv_SdtdeduccionesSolapa_Legdedimporte_Z, false, includeNonInitialized);
         AddObjectProperty("LegDedDescrip_Z", gxTv_SdtdeduccionesSolapa_Legdeddescrip_Z, false, includeNonInitialized);
         AddObjectProperty("LegDedConCodYDesc_Z", gxTv_SdtdeduccionesSolapa_Legdedconcodydesc_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtdeduccionesSolapa sdt )
   {
      if ( sdt.IsDirty("CliCod") )
      {
         gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
         gxTv_SdtdeduccionesSolapa_Clicod = sdt.getgxTv_SdtdeduccionesSolapa_Clicod() ;
      }
      if ( sdt.IsDirty("EmpCod") )
      {
         gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
         gxTv_SdtdeduccionesSolapa_Empcod = sdt.getgxTv_SdtdeduccionesSolapa_Empcod() ;
      }
      if ( sdt.IsDirty("LegNumero") )
      {
         gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
         gxTv_SdtdeduccionesSolapa_Legnumero = sdt.getgxTv_SdtdeduccionesSolapa_Legnumero() ;
      }
      if ( sdt.IsDirty("LegDedSec") )
      {
         gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
         gxTv_SdtdeduccionesSolapa_Legdedsec = sdt.getgxTv_SdtdeduccionesSolapa_Legdedsec() ;
      }
      if ( sdt.IsDirty("LegDedFchDes") )
      {
         gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
         gxTv_SdtdeduccionesSolapa_Legdedfchdes = sdt.getgxTv_SdtdeduccionesSolapa_Legdedfchdes() ;
      }
      if ( sdt.IsDirty("LegDedFchHas") )
      {
         gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
         gxTv_SdtdeduccionesSolapa_Legdedfchhas = sdt.getgxTv_SdtdeduccionesSolapa_Legdedfchhas() ;
      }
      if ( sdt.IsDirty("LegDedConCodigo") )
      {
         gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
         gxTv_SdtdeduccionesSolapa_Legdedconcodigo = sdt.getgxTv_SdtdeduccionesSolapa_Legdedconcodigo() ;
      }
      if ( sdt.IsDirty("LegDedConDescrip") )
      {
         gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
         gxTv_SdtdeduccionesSolapa_Legdedcondescrip = sdt.getgxTv_SdtdeduccionesSolapa_Legdedcondescrip() ;
      }
      if ( sdt.IsDirty("LegIdNomApe") )
      {
         gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
         gxTv_SdtdeduccionesSolapa_Legidnomape = sdt.getgxTv_SdtdeduccionesSolapa_Legidnomape() ;
      }
      if ( sdt.IsDirty("LegDedImporte") )
      {
         gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
         gxTv_SdtdeduccionesSolapa_Legdedimporte = sdt.getgxTv_SdtdeduccionesSolapa_Legdedimporte() ;
      }
      if ( sdt.IsDirty("LegDedDescrip") )
      {
         gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
         gxTv_SdtdeduccionesSolapa_Legdeddescrip = sdt.getgxTv_SdtdeduccionesSolapa_Legdeddescrip() ;
      }
      if ( sdt.IsDirty("LegDedConCodYDesc") )
      {
         gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
         gxTv_SdtdeduccionesSolapa_Legdedconcodydesc = sdt.getgxTv_SdtdeduccionesSolapa_Legdedconcodydesc() ;
      }
   }

   public int getgxTv_SdtdeduccionesSolapa_Clicod( )
   {
      return gxTv_SdtdeduccionesSolapa_Clicod ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Clicod( int value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      if ( gxTv_SdtdeduccionesSolapa_Clicod != value )
      {
         gxTv_SdtdeduccionesSolapa_Mode = "INS" ;
         this.setgxTv_SdtdeduccionesSolapa_Clicod_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Empcod_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legnumero_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legdedsec_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legdedfchdes_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legdedfchhas_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legdedconcodigo_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legdedcondescrip_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legidnomape_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legdedimporte_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legdeddescrip_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legdedconcodydesc_Z_SetNull( );
      }
      SetDirty("Clicod");
      gxTv_SdtdeduccionesSolapa_Clicod = value ;
   }

   public short getgxTv_SdtdeduccionesSolapa_Empcod( )
   {
      return gxTv_SdtdeduccionesSolapa_Empcod ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Empcod( short value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      if ( gxTv_SdtdeduccionesSolapa_Empcod != value )
      {
         gxTv_SdtdeduccionesSolapa_Mode = "INS" ;
         this.setgxTv_SdtdeduccionesSolapa_Clicod_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Empcod_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legnumero_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legdedsec_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legdedfchdes_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legdedfchhas_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legdedconcodigo_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legdedcondescrip_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legidnomape_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legdedimporte_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legdeddescrip_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legdedconcodydesc_Z_SetNull( );
      }
      SetDirty("Empcod");
      gxTv_SdtdeduccionesSolapa_Empcod = value ;
   }

   public int getgxTv_SdtdeduccionesSolapa_Legnumero( )
   {
      return gxTv_SdtdeduccionesSolapa_Legnumero ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Legnumero( int value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      if ( gxTv_SdtdeduccionesSolapa_Legnumero != value )
      {
         gxTv_SdtdeduccionesSolapa_Mode = "INS" ;
         this.setgxTv_SdtdeduccionesSolapa_Clicod_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Empcod_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legnumero_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legdedsec_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legdedfchdes_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legdedfchhas_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legdedconcodigo_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legdedcondescrip_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legidnomape_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legdedimporte_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legdeddescrip_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legdedconcodydesc_Z_SetNull( );
      }
      SetDirty("Legnumero");
      gxTv_SdtdeduccionesSolapa_Legnumero = value ;
   }

   public int getgxTv_SdtdeduccionesSolapa_Legdedsec( )
   {
      return gxTv_SdtdeduccionesSolapa_Legdedsec ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Legdedsec( int value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      if ( gxTv_SdtdeduccionesSolapa_Legdedsec != value )
      {
         gxTv_SdtdeduccionesSolapa_Mode = "INS" ;
         this.setgxTv_SdtdeduccionesSolapa_Clicod_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Empcod_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legnumero_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legdedsec_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legdedfchdes_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legdedfchhas_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legdedconcodigo_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legdedcondescrip_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legidnomape_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legdedimporte_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legdeddescrip_Z_SetNull( );
         this.setgxTv_SdtdeduccionesSolapa_Legdedconcodydesc_Z_SetNull( );
      }
      SetDirty("Legdedsec");
      gxTv_SdtdeduccionesSolapa_Legdedsec = value ;
   }

   public java.util.Date getgxTv_SdtdeduccionesSolapa_Legdedfchdes( )
   {
      return gxTv_SdtdeduccionesSolapa_Legdedfchdes ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Legdedfchdes( java.util.Date value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      SetDirty("Legdedfchdes");
      gxTv_SdtdeduccionesSolapa_Legdedfchdes = value ;
   }

   public java.util.Date getgxTv_SdtdeduccionesSolapa_Legdedfchhas( )
   {
      return gxTv_SdtdeduccionesSolapa_Legdedfchhas ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Legdedfchhas( java.util.Date value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      SetDirty("Legdedfchhas");
      gxTv_SdtdeduccionesSolapa_Legdedfchhas = value ;
   }

   public String getgxTv_SdtdeduccionesSolapa_Legdedconcodigo( )
   {
      return gxTv_SdtdeduccionesSolapa_Legdedconcodigo ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Legdedconcodigo( String value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      SetDirty("Legdedconcodigo");
      gxTv_SdtdeduccionesSolapa_Legdedconcodigo = value ;
   }

   public String getgxTv_SdtdeduccionesSolapa_Legdedcondescrip( )
   {
      return gxTv_SdtdeduccionesSolapa_Legdedcondescrip ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Legdedcondescrip( String value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      SetDirty("Legdedcondescrip");
      gxTv_SdtdeduccionesSolapa_Legdedcondescrip = value ;
   }

   public String getgxTv_SdtdeduccionesSolapa_Legidnomape( )
   {
      return gxTv_SdtdeduccionesSolapa_Legidnomape ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Legidnomape( String value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      SetDirty("Legidnomape");
      gxTv_SdtdeduccionesSolapa_Legidnomape = value ;
   }

   public java.math.BigDecimal getgxTv_SdtdeduccionesSolapa_Legdedimporte( )
   {
      return gxTv_SdtdeduccionesSolapa_Legdedimporte ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Legdedimporte( java.math.BigDecimal value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      SetDirty("Legdedimporte");
      gxTv_SdtdeduccionesSolapa_Legdedimporte = value ;
   }

   public String getgxTv_SdtdeduccionesSolapa_Legdeddescrip( )
   {
      return gxTv_SdtdeduccionesSolapa_Legdeddescrip ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Legdeddescrip( String value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      SetDirty("Legdeddescrip");
      gxTv_SdtdeduccionesSolapa_Legdeddescrip = value ;
   }

   public String getgxTv_SdtdeduccionesSolapa_Legdedconcodydesc( )
   {
      return gxTv_SdtdeduccionesSolapa_Legdedconcodydesc ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Legdedconcodydesc( String value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      SetDirty("Legdedconcodydesc");
      gxTv_SdtdeduccionesSolapa_Legdedconcodydesc = value ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Legdedconcodydesc_SetNull( )
   {
      gxTv_SdtdeduccionesSolapa_Legdedconcodydesc = "" ;
      SetDirty("Legdedconcodydesc");
   }

   public boolean getgxTv_SdtdeduccionesSolapa_Legdedconcodydesc_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtdeduccionesSolapa_Mode( )
   {
      return gxTv_SdtdeduccionesSolapa_Mode ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Mode( String value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtdeduccionesSolapa_Mode = value ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Mode_SetNull( )
   {
      gxTv_SdtdeduccionesSolapa_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtdeduccionesSolapa_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtdeduccionesSolapa_Initialized( )
   {
      return gxTv_SdtdeduccionesSolapa_Initialized ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Initialized( short value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtdeduccionesSolapa_Initialized = value ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Initialized_SetNull( )
   {
      gxTv_SdtdeduccionesSolapa_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtdeduccionesSolapa_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtdeduccionesSolapa_Clicod_Z( )
   {
      return gxTv_SdtdeduccionesSolapa_Clicod_Z ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Clicod_Z( int value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      SetDirty("Clicod_Z");
      gxTv_SdtdeduccionesSolapa_Clicod_Z = value ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Clicod_Z_SetNull( )
   {
      gxTv_SdtdeduccionesSolapa_Clicod_Z = 0 ;
      SetDirty("Clicod_Z");
   }

   public boolean getgxTv_SdtdeduccionesSolapa_Clicod_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtdeduccionesSolapa_Empcod_Z( )
   {
      return gxTv_SdtdeduccionesSolapa_Empcod_Z ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Empcod_Z( short value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      SetDirty("Empcod_Z");
      gxTv_SdtdeduccionesSolapa_Empcod_Z = value ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Empcod_Z_SetNull( )
   {
      gxTv_SdtdeduccionesSolapa_Empcod_Z = (short)(0) ;
      SetDirty("Empcod_Z");
   }

   public boolean getgxTv_SdtdeduccionesSolapa_Empcod_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtdeduccionesSolapa_Legnumero_Z( )
   {
      return gxTv_SdtdeduccionesSolapa_Legnumero_Z ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Legnumero_Z( int value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      SetDirty("Legnumero_Z");
      gxTv_SdtdeduccionesSolapa_Legnumero_Z = value ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Legnumero_Z_SetNull( )
   {
      gxTv_SdtdeduccionesSolapa_Legnumero_Z = 0 ;
      SetDirty("Legnumero_Z");
   }

   public boolean getgxTv_SdtdeduccionesSolapa_Legnumero_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtdeduccionesSolapa_Legdedsec_Z( )
   {
      return gxTv_SdtdeduccionesSolapa_Legdedsec_Z ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Legdedsec_Z( int value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      SetDirty("Legdedsec_Z");
      gxTv_SdtdeduccionesSolapa_Legdedsec_Z = value ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Legdedsec_Z_SetNull( )
   {
      gxTv_SdtdeduccionesSolapa_Legdedsec_Z = 0 ;
      SetDirty("Legdedsec_Z");
   }

   public boolean getgxTv_SdtdeduccionesSolapa_Legdedsec_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtdeduccionesSolapa_Legdedfchdes_Z( )
   {
      return gxTv_SdtdeduccionesSolapa_Legdedfchdes_Z ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Legdedfchdes_Z( java.util.Date value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      SetDirty("Legdedfchdes_Z");
      gxTv_SdtdeduccionesSolapa_Legdedfchdes_Z = value ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Legdedfchdes_Z_SetNull( )
   {
      gxTv_SdtdeduccionesSolapa_Legdedfchdes_Z = GXutil.nullDate() ;
      SetDirty("Legdedfchdes_Z");
   }

   public boolean getgxTv_SdtdeduccionesSolapa_Legdedfchdes_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtdeduccionesSolapa_Legdedfchhas_Z( )
   {
      return gxTv_SdtdeduccionesSolapa_Legdedfchhas_Z ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Legdedfchhas_Z( java.util.Date value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      SetDirty("Legdedfchhas_Z");
      gxTv_SdtdeduccionesSolapa_Legdedfchhas_Z = value ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Legdedfchhas_Z_SetNull( )
   {
      gxTv_SdtdeduccionesSolapa_Legdedfchhas_Z = GXutil.nullDate() ;
      SetDirty("Legdedfchhas_Z");
   }

   public boolean getgxTv_SdtdeduccionesSolapa_Legdedfchhas_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtdeduccionesSolapa_Legdedconcodigo_Z( )
   {
      return gxTv_SdtdeduccionesSolapa_Legdedconcodigo_Z ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Legdedconcodigo_Z( String value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      SetDirty("Legdedconcodigo_Z");
      gxTv_SdtdeduccionesSolapa_Legdedconcodigo_Z = value ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Legdedconcodigo_Z_SetNull( )
   {
      gxTv_SdtdeduccionesSolapa_Legdedconcodigo_Z = "" ;
      SetDirty("Legdedconcodigo_Z");
   }

   public boolean getgxTv_SdtdeduccionesSolapa_Legdedconcodigo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtdeduccionesSolapa_Legdedcondescrip_Z( )
   {
      return gxTv_SdtdeduccionesSolapa_Legdedcondescrip_Z ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Legdedcondescrip_Z( String value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      SetDirty("Legdedcondescrip_Z");
      gxTv_SdtdeduccionesSolapa_Legdedcondescrip_Z = value ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Legdedcondescrip_Z_SetNull( )
   {
      gxTv_SdtdeduccionesSolapa_Legdedcondescrip_Z = "" ;
      SetDirty("Legdedcondescrip_Z");
   }

   public boolean getgxTv_SdtdeduccionesSolapa_Legdedcondescrip_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtdeduccionesSolapa_Legidnomape_Z( )
   {
      return gxTv_SdtdeduccionesSolapa_Legidnomape_Z ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Legidnomape_Z( String value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      SetDirty("Legidnomape_Z");
      gxTv_SdtdeduccionesSolapa_Legidnomape_Z = value ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Legidnomape_Z_SetNull( )
   {
      gxTv_SdtdeduccionesSolapa_Legidnomape_Z = "" ;
      SetDirty("Legidnomape_Z");
   }

   public boolean getgxTv_SdtdeduccionesSolapa_Legidnomape_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtdeduccionesSolapa_Legdedimporte_Z( )
   {
      return gxTv_SdtdeduccionesSolapa_Legdedimporte_Z ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Legdedimporte_Z( java.math.BigDecimal value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      SetDirty("Legdedimporte_Z");
      gxTv_SdtdeduccionesSolapa_Legdedimporte_Z = value ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Legdedimporte_Z_SetNull( )
   {
      gxTv_SdtdeduccionesSolapa_Legdedimporte_Z = DecimalUtil.ZERO ;
      SetDirty("Legdedimporte_Z");
   }

   public boolean getgxTv_SdtdeduccionesSolapa_Legdedimporte_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtdeduccionesSolapa_Legdeddescrip_Z( )
   {
      return gxTv_SdtdeduccionesSolapa_Legdeddescrip_Z ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Legdeddescrip_Z( String value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      SetDirty("Legdeddescrip_Z");
      gxTv_SdtdeduccionesSolapa_Legdeddescrip_Z = value ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Legdeddescrip_Z_SetNull( )
   {
      gxTv_SdtdeduccionesSolapa_Legdeddescrip_Z = "" ;
      SetDirty("Legdeddescrip_Z");
   }

   public boolean getgxTv_SdtdeduccionesSolapa_Legdeddescrip_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtdeduccionesSolapa_Legdedconcodydesc_Z( )
   {
      return gxTv_SdtdeduccionesSolapa_Legdedconcodydesc_Z ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Legdedconcodydesc_Z( String value )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(0) ;
      SetDirty("Legdedconcodydesc_Z");
      gxTv_SdtdeduccionesSolapa_Legdedconcodydesc_Z = value ;
   }

   public void setgxTv_SdtdeduccionesSolapa_Legdedconcodydesc_Z_SetNull( )
   {
      gxTv_SdtdeduccionesSolapa_Legdedconcodydesc_Z = "" ;
      SetDirty("Legdedconcodydesc_Z");
   }

   public boolean getgxTv_SdtdeduccionesSolapa_Legdedconcodydesc_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.deduccionessolapa_bc obj;
      obj = new web.deduccionessolapa_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtdeduccionesSolapa_N = (byte)(1) ;
      gxTv_SdtdeduccionesSolapa_Legdedfchdes = GXutil.nullDate() ;
      gxTv_SdtdeduccionesSolapa_Legdedfchhas = GXutil.nullDate() ;
      gxTv_SdtdeduccionesSolapa_Legdedconcodigo = "" ;
      gxTv_SdtdeduccionesSolapa_Legdedcondescrip = "" ;
      gxTv_SdtdeduccionesSolapa_Legidnomape = "" ;
      gxTv_SdtdeduccionesSolapa_Legdedimporte = DecimalUtil.ZERO ;
      gxTv_SdtdeduccionesSolapa_Legdeddescrip = "" ;
      gxTv_SdtdeduccionesSolapa_Legdedconcodydesc = "" ;
      gxTv_SdtdeduccionesSolapa_Mode = "" ;
      gxTv_SdtdeduccionesSolapa_Legdedfchdes_Z = GXutil.nullDate() ;
      gxTv_SdtdeduccionesSolapa_Legdedfchhas_Z = GXutil.nullDate() ;
      gxTv_SdtdeduccionesSolapa_Legdedconcodigo_Z = "" ;
      gxTv_SdtdeduccionesSolapa_Legdedcondescrip_Z = "" ;
      gxTv_SdtdeduccionesSolapa_Legidnomape_Z = "" ;
      gxTv_SdtdeduccionesSolapa_Legdedimporte_Z = DecimalUtil.ZERO ;
      gxTv_SdtdeduccionesSolapa_Legdeddescrip_Z = "" ;
      gxTv_SdtdeduccionesSolapa_Legdedconcodydesc_Z = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtdeduccionesSolapa_N ;
   }

   public web.SdtdeduccionesSolapa Clone( )
   {
      web.SdtdeduccionesSolapa sdt;
      web.deduccionessolapa_bc obj;
      sdt = (web.SdtdeduccionesSolapa)(clone()) ;
      obj = (web.deduccionessolapa_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtdeduccionesSolapa struct )
   {
      setgxTv_SdtdeduccionesSolapa_Clicod(struct.getClicod());
      setgxTv_SdtdeduccionesSolapa_Empcod(struct.getEmpcod());
      setgxTv_SdtdeduccionesSolapa_Legnumero(struct.getLegnumero());
      setgxTv_SdtdeduccionesSolapa_Legdedsec(struct.getLegdedsec());
      setgxTv_SdtdeduccionesSolapa_Legdedfchdes(struct.getLegdedfchdes());
      setgxTv_SdtdeduccionesSolapa_Legdedfchhas(struct.getLegdedfchhas());
      setgxTv_SdtdeduccionesSolapa_Legdedconcodigo(struct.getLegdedconcodigo());
      setgxTv_SdtdeduccionesSolapa_Legdedcondescrip(struct.getLegdedcondescrip());
      setgxTv_SdtdeduccionesSolapa_Legidnomape(struct.getLegidnomape());
      setgxTv_SdtdeduccionesSolapa_Legdedimporte(struct.getLegdedimporte());
      setgxTv_SdtdeduccionesSolapa_Legdeddescrip(struct.getLegdeddescrip());
      setgxTv_SdtdeduccionesSolapa_Legdedconcodydesc(struct.getLegdedconcodydesc());
      setgxTv_SdtdeduccionesSolapa_Mode(struct.getMode());
      setgxTv_SdtdeduccionesSolapa_Initialized(struct.getInitialized());
      setgxTv_SdtdeduccionesSolapa_Clicod_Z(struct.getClicod_Z());
      setgxTv_SdtdeduccionesSolapa_Empcod_Z(struct.getEmpcod_Z());
      setgxTv_SdtdeduccionesSolapa_Legnumero_Z(struct.getLegnumero_Z());
      setgxTv_SdtdeduccionesSolapa_Legdedsec_Z(struct.getLegdedsec_Z());
      setgxTv_SdtdeduccionesSolapa_Legdedfchdes_Z(struct.getLegdedfchdes_Z());
      setgxTv_SdtdeduccionesSolapa_Legdedfchhas_Z(struct.getLegdedfchhas_Z());
      setgxTv_SdtdeduccionesSolapa_Legdedconcodigo_Z(struct.getLegdedconcodigo_Z());
      setgxTv_SdtdeduccionesSolapa_Legdedcondescrip_Z(struct.getLegdedcondescrip_Z());
      setgxTv_SdtdeduccionesSolapa_Legidnomape_Z(struct.getLegidnomape_Z());
      setgxTv_SdtdeduccionesSolapa_Legdedimporte_Z(struct.getLegdedimporte_Z());
      setgxTv_SdtdeduccionesSolapa_Legdeddescrip_Z(struct.getLegdeddescrip_Z());
      setgxTv_SdtdeduccionesSolapa_Legdedconcodydesc_Z(struct.getLegdedconcodydesc_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtdeduccionesSolapa getStruct( )
   {
      web.StructSdtdeduccionesSolapa struct = new web.StructSdtdeduccionesSolapa ();
      struct.setClicod(getgxTv_SdtdeduccionesSolapa_Clicod());
      struct.setEmpcod(getgxTv_SdtdeduccionesSolapa_Empcod());
      struct.setLegnumero(getgxTv_SdtdeduccionesSolapa_Legnumero());
      struct.setLegdedsec(getgxTv_SdtdeduccionesSolapa_Legdedsec());
      struct.setLegdedfchdes(getgxTv_SdtdeduccionesSolapa_Legdedfchdes());
      struct.setLegdedfchhas(getgxTv_SdtdeduccionesSolapa_Legdedfchhas());
      struct.setLegdedconcodigo(getgxTv_SdtdeduccionesSolapa_Legdedconcodigo());
      struct.setLegdedcondescrip(getgxTv_SdtdeduccionesSolapa_Legdedcondescrip());
      struct.setLegidnomape(getgxTv_SdtdeduccionesSolapa_Legidnomape());
      struct.setLegdedimporte(getgxTv_SdtdeduccionesSolapa_Legdedimporte());
      struct.setLegdeddescrip(getgxTv_SdtdeduccionesSolapa_Legdeddescrip());
      struct.setLegdedconcodydesc(getgxTv_SdtdeduccionesSolapa_Legdedconcodydesc());
      struct.setMode(getgxTv_SdtdeduccionesSolapa_Mode());
      struct.setInitialized(getgxTv_SdtdeduccionesSolapa_Initialized());
      struct.setClicod_Z(getgxTv_SdtdeduccionesSolapa_Clicod_Z());
      struct.setEmpcod_Z(getgxTv_SdtdeduccionesSolapa_Empcod_Z());
      struct.setLegnumero_Z(getgxTv_SdtdeduccionesSolapa_Legnumero_Z());
      struct.setLegdedsec_Z(getgxTv_SdtdeduccionesSolapa_Legdedsec_Z());
      struct.setLegdedfchdes_Z(getgxTv_SdtdeduccionesSolapa_Legdedfchdes_Z());
      struct.setLegdedfchhas_Z(getgxTv_SdtdeduccionesSolapa_Legdedfchhas_Z());
      struct.setLegdedconcodigo_Z(getgxTv_SdtdeduccionesSolapa_Legdedconcodigo_Z());
      struct.setLegdedcondescrip_Z(getgxTv_SdtdeduccionesSolapa_Legdedcondescrip_Z());
      struct.setLegidnomape_Z(getgxTv_SdtdeduccionesSolapa_Legidnomape_Z());
      struct.setLegdedimporte_Z(getgxTv_SdtdeduccionesSolapa_Legdedimporte_Z());
      struct.setLegdeddescrip_Z(getgxTv_SdtdeduccionesSolapa_Legdeddescrip_Z());
      struct.setLegdedconcodydesc_Z(getgxTv_SdtdeduccionesSolapa_Legdedconcodydesc_Z());
      return struct ;
   }

   private byte gxTv_SdtdeduccionesSolapa_N ;
   private short gxTv_SdtdeduccionesSolapa_Empcod ;
   private short gxTv_SdtdeduccionesSolapa_Initialized ;
   private short gxTv_SdtdeduccionesSolapa_Empcod_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtdeduccionesSolapa_Clicod ;
   private int gxTv_SdtdeduccionesSolapa_Legnumero ;
   private int gxTv_SdtdeduccionesSolapa_Legdedsec ;
   private int gxTv_SdtdeduccionesSolapa_Clicod_Z ;
   private int gxTv_SdtdeduccionesSolapa_Legnumero_Z ;
   private int gxTv_SdtdeduccionesSolapa_Legdedsec_Z ;
   private java.math.BigDecimal gxTv_SdtdeduccionesSolapa_Legdedimporte ;
   private java.math.BigDecimal gxTv_SdtdeduccionesSolapa_Legdedimporte_Z ;
   private String gxTv_SdtdeduccionesSolapa_Legdedconcodigo ;
   private String gxTv_SdtdeduccionesSolapa_Mode ;
   private String gxTv_SdtdeduccionesSolapa_Legdedconcodigo_Z ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtdeduccionesSolapa_Legdedfchdes ;
   private java.util.Date gxTv_SdtdeduccionesSolapa_Legdedfchhas ;
   private java.util.Date gxTv_SdtdeduccionesSolapa_Legdedfchdes_Z ;
   private java.util.Date gxTv_SdtdeduccionesSolapa_Legdedfchhas_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtdeduccionesSolapa_Legdedcondescrip ;
   private String gxTv_SdtdeduccionesSolapa_Legidnomape ;
   private String gxTv_SdtdeduccionesSolapa_Legdeddescrip ;
   private String gxTv_SdtdeduccionesSolapa_Legdedconcodydesc ;
   private String gxTv_SdtdeduccionesSolapa_Legdedcondescrip_Z ;
   private String gxTv_SdtdeduccionesSolapa_Legidnomape_Z ;
   private String gxTv_SdtdeduccionesSolapa_Legdeddescrip_Z ;
   private String gxTv_SdtdeduccionesSolapa_Legdedconcodydesc_Z ;
}

