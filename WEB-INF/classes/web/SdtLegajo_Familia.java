package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtLegajo_Familia extends GxSilentTrnSdt
{
   public SdtLegajo_Familia( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtLegajo_Familia.class));
   }

   public SdtLegajo_Familia( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle, context, "SdtLegajo_Familia");
      initialize( remoteHandle) ;
   }

   public SdtLegajo_Familia( int remoteHandle ,
                             StructSdtLegajo_Familia struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtLegajo_Familia( )
   {
      super( new ModelContext(SdtLegajo_Familia.class), "SdtLegajo_Familia");
      initialize( ) ;
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"LegOrden", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Familia");
      metadata.set("BT", "LegajoFamilia");
      metadata.set("PK", "[ \"LegOrden\" ]");
      metadata.set("PKAssigned", "[ \"LegOrden\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"EmpCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"EmpCod\",\"GuarCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"EmpCod\",\"LegNumero\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"ParCod\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegOrden") )
            {
               gxTv_SdtLegajo_Familia_Legorden = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamNomApe") )
            {
               gxTv_SdtLegajo_Familia_Famnomape = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ParCod") )
            {
               gxTv_SdtLegajo_Familia_Parcod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamFecNac") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLegajo_Familia_Famfecnac = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLegajo_Familia_Famfecnac = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamDiscap") )
            {
               gxTv_SdtLegajo_Familia_Famdiscap = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamTomaDeducImpGan") )
            {
               gxTv_SdtLegajo_Familia_Famtomadeducimpgan = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamNroDoc") )
            {
               gxTv_SdtLegajo_Familia_Famnrodoc = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamAdherente") )
            {
               gxTv_SdtLegajo_Familia_Famadherente = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "GuarCod") )
            {
               gxTv_SdtLegajo_Familia_Guarcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtLegajo_Familia_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtLegajo_Familia_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtLegajo_Familia_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegOrden_Z") )
            {
               gxTv_SdtLegajo_Familia_Legorden_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamNomApe_Z") )
            {
               gxTv_SdtLegajo_Familia_Famnomape_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ParCod_Z") )
            {
               gxTv_SdtLegajo_Familia_Parcod_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamFecNac_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLegajo_Familia_Famfecnac_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLegajo_Familia_Famfecnac_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamDiscap_Z") )
            {
               gxTv_SdtLegajo_Familia_Famdiscap_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamTomaDeducImpGan_Z") )
            {
               gxTv_SdtLegajo_Familia_Famtomadeducimpgan_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamNroDoc_Z") )
            {
               gxTv_SdtLegajo_Familia_Famnrodoc_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamAdherente_Z") )
            {
               gxTv_SdtLegajo_Familia_Famadherente_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "GuarCod_Z") )
            {
               gxTv_SdtLegajo_Familia_Guarcod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamFecNac_N") )
            {
               gxTv_SdtLegajo_Familia_Famfecnac_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FamDiscap_N") )
            {
               gxTv_SdtLegajo_Familia_Famdiscap_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "GuarCod_N") )
            {
               gxTv_SdtLegajo_Familia_Guarcod_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "Legajo.Familia" ;
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
      oWriter.writeElement("LegOrden", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Familia_Legorden, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("FamNomApe", gxTv_SdtLegajo_Familia_Famnomape);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ParCod", gxTv_SdtLegajo_Familia_Parcod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Familia_Famfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Familia_Famfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Familia_Famfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("FamFecNac", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("FamDiscap", GXutil.booltostr( gxTv_SdtLegajo_Familia_Famdiscap));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("FamTomaDeducImpGan", GXutil.trim( GXutil.strNoRound( gxTv_SdtLegajo_Familia_Famtomadeducimpgan, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("FamNroDoc", gxTv_SdtLegajo_Familia_Famnrodoc);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("FamAdherente", GXutil.booltostr( gxTv_SdtLegajo_Familia_Famadherente));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("GuarCod", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Familia_Guarcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtLegajo_Familia_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Familia_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Familia_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegOrden_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Familia_Legorden_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("FamNomApe_Z", gxTv_SdtLegajo_Familia_Famnomape_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ParCod_Z", gxTv_SdtLegajo_Familia_Parcod_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Familia_Famfecnac_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Familia_Famfecnac_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Familia_Famfecnac_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("FamFecNac_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("FamDiscap_Z", GXutil.booltostr( gxTv_SdtLegajo_Familia_Famdiscap_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("FamTomaDeducImpGan_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLegajo_Familia_Famtomadeducimpgan_Z, 6, 4)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("FamNroDoc_Z", gxTv_SdtLegajo_Familia_Famnrodoc_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("FamAdherente_Z", GXutil.booltostr( gxTv_SdtLegajo_Familia_Famadherente_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("GuarCod_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Familia_Guarcod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("FamFecNac_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Familia_Famfecnac_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("FamDiscap_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Familia_Famdiscap_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("GuarCod_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Familia_Guarcod_N, 1, 0)));
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
      AddObjectProperty("LegOrden", gxTv_SdtLegajo_Familia_Legorden, false, includeNonInitialized);
      AddObjectProperty("FamNomApe", gxTv_SdtLegajo_Familia_Famnomape, false, includeNonInitialized);
      AddObjectProperty("ParCod", gxTv_SdtLegajo_Familia_Parcod, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Familia_Famfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Familia_Famfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Familia_Famfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("FamFecNac", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("FamFecNac_N", gxTv_SdtLegajo_Familia_Famfecnac_N, false, includeNonInitialized);
      AddObjectProperty("FamDiscap", gxTv_SdtLegajo_Familia_Famdiscap, false, includeNonInitialized);
      AddObjectProperty("FamDiscap_N", gxTv_SdtLegajo_Familia_Famdiscap_N, false, includeNonInitialized);
      AddObjectProperty("FamTomaDeducImpGan", gxTv_SdtLegajo_Familia_Famtomadeducimpgan, false, includeNonInitialized);
      AddObjectProperty("FamNroDoc", gxTv_SdtLegajo_Familia_Famnrodoc, false, includeNonInitialized);
      AddObjectProperty("FamAdherente", gxTv_SdtLegajo_Familia_Famadherente, false, includeNonInitialized);
      AddObjectProperty("GuarCod", gxTv_SdtLegajo_Familia_Guarcod, false, includeNonInitialized);
      AddObjectProperty("GuarCod_N", gxTv_SdtLegajo_Familia_Guarcod_N, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtLegajo_Familia_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtLegajo_Familia_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtLegajo_Familia_Initialized, false, includeNonInitialized);
         AddObjectProperty("LegOrden_Z", gxTv_SdtLegajo_Familia_Legorden_Z, false, includeNonInitialized);
         AddObjectProperty("FamNomApe_Z", gxTv_SdtLegajo_Familia_Famnomape_Z, false, includeNonInitialized);
         AddObjectProperty("ParCod_Z", gxTv_SdtLegajo_Familia_Parcod_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Familia_Famfecnac_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Familia_Famfecnac_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Familia_Famfecnac_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("FamFecNac_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("FamDiscap_Z", gxTv_SdtLegajo_Familia_Famdiscap_Z, false, includeNonInitialized);
         AddObjectProperty("FamTomaDeducImpGan_Z", gxTv_SdtLegajo_Familia_Famtomadeducimpgan_Z, false, includeNonInitialized);
         AddObjectProperty("FamNroDoc_Z", gxTv_SdtLegajo_Familia_Famnrodoc_Z, false, includeNonInitialized);
         AddObjectProperty("FamAdherente_Z", gxTv_SdtLegajo_Familia_Famadherente_Z, false, includeNonInitialized);
         AddObjectProperty("GuarCod_Z", gxTv_SdtLegajo_Familia_Guarcod_Z, false, includeNonInitialized);
         AddObjectProperty("FamFecNac_N", gxTv_SdtLegajo_Familia_Famfecnac_N, false, includeNonInitialized);
         AddObjectProperty("FamDiscap_N", gxTv_SdtLegajo_Familia_Famdiscap_N, false, includeNonInitialized);
         AddObjectProperty("GuarCod_N", gxTv_SdtLegajo_Familia_Guarcod_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtLegajo_Familia sdt )
   {
      if ( sdt.IsDirty("LegOrden") )
      {
         gxTv_SdtLegajo_Familia_N = (byte)(0) ;
         gxTv_SdtLegajo_Familia_Legorden = sdt.getgxTv_SdtLegajo_Familia_Legorden() ;
      }
      if ( sdt.IsDirty("FamNomApe") )
      {
         gxTv_SdtLegajo_Familia_N = (byte)(0) ;
         gxTv_SdtLegajo_Familia_Famnomape = sdt.getgxTv_SdtLegajo_Familia_Famnomape() ;
      }
      if ( sdt.IsDirty("ParCod") )
      {
         gxTv_SdtLegajo_Familia_N = (byte)(0) ;
         gxTv_SdtLegajo_Familia_Parcod = sdt.getgxTv_SdtLegajo_Familia_Parcod() ;
      }
      if ( sdt.IsDirty("FamFecNac") )
      {
         gxTv_SdtLegajo_Familia_Famfecnac_N = sdt.getgxTv_SdtLegajo_Familia_Famfecnac_N() ;
         gxTv_SdtLegajo_Familia_N = (byte)(0) ;
         gxTv_SdtLegajo_Familia_Famfecnac = sdt.getgxTv_SdtLegajo_Familia_Famfecnac() ;
      }
      if ( sdt.IsDirty("FamDiscap") )
      {
         gxTv_SdtLegajo_Familia_Famdiscap_N = sdt.getgxTv_SdtLegajo_Familia_Famdiscap_N() ;
         gxTv_SdtLegajo_Familia_N = (byte)(0) ;
         gxTv_SdtLegajo_Familia_Famdiscap = sdt.getgxTv_SdtLegajo_Familia_Famdiscap() ;
      }
      if ( sdt.IsDirty("FamTomaDeducImpGan") )
      {
         gxTv_SdtLegajo_Familia_N = (byte)(0) ;
         gxTv_SdtLegajo_Familia_Famtomadeducimpgan = sdt.getgxTv_SdtLegajo_Familia_Famtomadeducimpgan() ;
      }
      if ( sdt.IsDirty("FamNroDoc") )
      {
         gxTv_SdtLegajo_Familia_N = (byte)(0) ;
         gxTv_SdtLegajo_Familia_Famnrodoc = sdt.getgxTv_SdtLegajo_Familia_Famnrodoc() ;
      }
      if ( sdt.IsDirty("FamAdherente") )
      {
         gxTv_SdtLegajo_Familia_N = (byte)(0) ;
         gxTv_SdtLegajo_Familia_Famadherente = sdt.getgxTv_SdtLegajo_Familia_Famadherente() ;
      }
      if ( sdt.IsDirty("GuarCod") )
      {
         gxTv_SdtLegajo_Familia_Guarcod_N = sdt.getgxTv_SdtLegajo_Familia_Guarcod_N() ;
         gxTv_SdtLegajo_Familia_N = (byte)(0) ;
         gxTv_SdtLegajo_Familia_Guarcod = sdt.getgxTv_SdtLegajo_Familia_Guarcod() ;
      }
   }

   public short getgxTv_SdtLegajo_Familia_Legorden( )
   {
      return gxTv_SdtLegajo_Familia_Legorden ;
   }

   public void setgxTv_SdtLegajo_Familia_Legorden( short value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Modified = (short)(1) ;
      SetDirty("Legorden");
      gxTv_SdtLegajo_Familia_Legorden = value ;
   }

   public String getgxTv_SdtLegajo_Familia_Famnomape( )
   {
      return gxTv_SdtLegajo_Familia_Famnomape ;
   }

   public void setgxTv_SdtLegajo_Familia_Famnomape( String value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Modified = (short)(1) ;
      SetDirty("Famnomape");
      gxTv_SdtLegajo_Familia_Famnomape = value ;
   }

   public String getgxTv_SdtLegajo_Familia_Parcod( )
   {
      return gxTv_SdtLegajo_Familia_Parcod ;
   }

   public void setgxTv_SdtLegajo_Familia_Parcod( String value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Modified = (short)(1) ;
      SetDirty("Parcod");
      gxTv_SdtLegajo_Familia_Parcod = value ;
   }

   public java.util.Date getgxTv_SdtLegajo_Familia_Famfecnac( )
   {
      return gxTv_SdtLegajo_Familia_Famfecnac ;
   }

   public void setgxTv_SdtLegajo_Familia_Famfecnac( java.util.Date value )
   {
      gxTv_SdtLegajo_Familia_Famfecnac_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Modified = (short)(1) ;
      SetDirty("Famfecnac");
      gxTv_SdtLegajo_Familia_Famfecnac = value ;
   }

   public void setgxTv_SdtLegajo_Familia_Famfecnac_SetNull( )
   {
      gxTv_SdtLegajo_Familia_Famfecnac_N = (byte)(1) ;
      gxTv_SdtLegajo_Familia_Famfecnac = GXutil.nullDate() ;
      SetDirty("Famfecnac");
   }

   public boolean getgxTv_SdtLegajo_Familia_Famfecnac_IsNull( )
   {
      return (gxTv_SdtLegajo_Familia_Famfecnac_N==1) ;
   }

   public boolean getgxTv_SdtLegajo_Familia_Famdiscap( )
   {
      return gxTv_SdtLegajo_Familia_Famdiscap ;
   }

   public void setgxTv_SdtLegajo_Familia_Famdiscap( boolean value )
   {
      gxTv_SdtLegajo_Familia_Famdiscap_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Modified = (short)(1) ;
      SetDirty("Famdiscap");
      gxTv_SdtLegajo_Familia_Famdiscap = value ;
   }

   public void setgxTv_SdtLegajo_Familia_Famdiscap_SetNull( )
   {
      gxTv_SdtLegajo_Familia_Famdiscap_N = (byte)(1) ;
      gxTv_SdtLegajo_Familia_Famdiscap = false ;
      SetDirty("Famdiscap");
   }

   public boolean getgxTv_SdtLegajo_Familia_Famdiscap_IsNull( )
   {
      return (gxTv_SdtLegajo_Familia_Famdiscap_N==1) ;
   }

   public java.math.BigDecimal getgxTv_SdtLegajo_Familia_Famtomadeducimpgan( )
   {
      return gxTv_SdtLegajo_Familia_Famtomadeducimpgan ;
   }

   public void setgxTv_SdtLegajo_Familia_Famtomadeducimpgan( java.math.BigDecimal value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Modified = (short)(1) ;
      SetDirty("Famtomadeducimpgan");
      gxTv_SdtLegajo_Familia_Famtomadeducimpgan = value ;
   }

   public String getgxTv_SdtLegajo_Familia_Famnrodoc( )
   {
      return gxTv_SdtLegajo_Familia_Famnrodoc ;
   }

   public void setgxTv_SdtLegajo_Familia_Famnrodoc( String value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Modified = (short)(1) ;
      SetDirty("Famnrodoc");
      gxTv_SdtLegajo_Familia_Famnrodoc = value ;
   }

   public boolean getgxTv_SdtLegajo_Familia_Famadherente( )
   {
      return gxTv_SdtLegajo_Familia_Famadherente ;
   }

   public void setgxTv_SdtLegajo_Familia_Famadherente( boolean value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Modified = (short)(1) ;
      SetDirty("Famadherente");
      gxTv_SdtLegajo_Familia_Famadherente = value ;
   }

   public short getgxTv_SdtLegajo_Familia_Guarcod( )
   {
      return gxTv_SdtLegajo_Familia_Guarcod ;
   }

   public void setgxTv_SdtLegajo_Familia_Guarcod( short value )
   {
      gxTv_SdtLegajo_Familia_Guarcod_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Modified = (short)(1) ;
      SetDirty("Guarcod");
      gxTv_SdtLegajo_Familia_Guarcod = value ;
   }

   public void setgxTv_SdtLegajo_Familia_Guarcod_SetNull( )
   {
      gxTv_SdtLegajo_Familia_Guarcod_N = (byte)(1) ;
      gxTv_SdtLegajo_Familia_Guarcod = (short)(0) ;
      SetDirty("Guarcod");
   }

   public boolean getgxTv_SdtLegajo_Familia_Guarcod_IsNull( )
   {
      return (gxTv_SdtLegajo_Familia_Guarcod_N==1) ;
   }

   public String getgxTv_SdtLegajo_Familia_Mode( )
   {
      return gxTv_SdtLegajo_Familia_Mode ;
   }

   public void setgxTv_SdtLegajo_Familia_Mode( String value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtLegajo_Familia_Mode = value ;
   }

   public void setgxTv_SdtLegajo_Familia_Mode_SetNull( )
   {
      gxTv_SdtLegajo_Familia_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtLegajo_Familia_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLegajo_Familia_Modified( )
   {
      return gxTv_SdtLegajo_Familia_Modified ;
   }

   public void setgxTv_SdtLegajo_Familia_Modified( short value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtLegajo_Familia_Modified = value ;
   }

   public void setgxTv_SdtLegajo_Familia_Modified_SetNull( )
   {
      gxTv_SdtLegajo_Familia_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtLegajo_Familia_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLegajo_Familia_Initialized( )
   {
      return gxTv_SdtLegajo_Familia_Initialized ;
   }

   public void setgxTv_SdtLegajo_Familia_Initialized( short value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtLegajo_Familia_Initialized = value ;
   }

   public void setgxTv_SdtLegajo_Familia_Initialized_SetNull( )
   {
      gxTv_SdtLegajo_Familia_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtLegajo_Familia_Initialized_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLegajo_Familia_Legorden_Z( )
   {
      return gxTv_SdtLegajo_Familia_Legorden_Z ;
   }

   public void setgxTv_SdtLegajo_Familia_Legorden_Z( short value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Modified = (short)(1) ;
      SetDirty("Legorden_Z");
      gxTv_SdtLegajo_Familia_Legorden_Z = value ;
   }

   public void setgxTv_SdtLegajo_Familia_Legorden_Z_SetNull( )
   {
      gxTv_SdtLegajo_Familia_Legorden_Z = (short)(0) ;
      SetDirty("Legorden_Z");
   }

   public boolean getgxTv_SdtLegajo_Familia_Legorden_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Familia_Famnomape_Z( )
   {
      return gxTv_SdtLegajo_Familia_Famnomape_Z ;
   }

   public void setgxTv_SdtLegajo_Familia_Famnomape_Z( String value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Modified = (short)(1) ;
      SetDirty("Famnomape_Z");
      gxTv_SdtLegajo_Familia_Famnomape_Z = value ;
   }

   public void setgxTv_SdtLegajo_Familia_Famnomape_Z_SetNull( )
   {
      gxTv_SdtLegajo_Familia_Famnomape_Z = "" ;
      SetDirty("Famnomape_Z");
   }

   public boolean getgxTv_SdtLegajo_Familia_Famnomape_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Familia_Parcod_Z( )
   {
      return gxTv_SdtLegajo_Familia_Parcod_Z ;
   }

   public void setgxTv_SdtLegajo_Familia_Parcod_Z( String value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Modified = (short)(1) ;
      SetDirty("Parcod_Z");
      gxTv_SdtLegajo_Familia_Parcod_Z = value ;
   }

   public void setgxTv_SdtLegajo_Familia_Parcod_Z_SetNull( )
   {
      gxTv_SdtLegajo_Familia_Parcod_Z = "" ;
      SetDirty("Parcod_Z");
   }

   public boolean getgxTv_SdtLegajo_Familia_Parcod_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtLegajo_Familia_Famfecnac_Z( )
   {
      return gxTv_SdtLegajo_Familia_Famfecnac_Z ;
   }

   public void setgxTv_SdtLegajo_Familia_Famfecnac_Z( java.util.Date value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Modified = (short)(1) ;
      SetDirty("Famfecnac_Z");
      gxTv_SdtLegajo_Familia_Famfecnac_Z = value ;
   }

   public void setgxTv_SdtLegajo_Familia_Famfecnac_Z_SetNull( )
   {
      gxTv_SdtLegajo_Familia_Famfecnac_Z = GXutil.nullDate() ;
      SetDirty("Famfecnac_Z");
   }

   public boolean getgxTv_SdtLegajo_Familia_Famfecnac_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtLegajo_Familia_Famdiscap_Z( )
   {
      return gxTv_SdtLegajo_Familia_Famdiscap_Z ;
   }

   public void setgxTv_SdtLegajo_Familia_Famdiscap_Z( boolean value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Modified = (short)(1) ;
      SetDirty("Famdiscap_Z");
      gxTv_SdtLegajo_Familia_Famdiscap_Z = value ;
   }

   public void setgxTv_SdtLegajo_Familia_Famdiscap_Z_SetNull( )
   {
      gxTv_SdtLegajo_Familia_Famdiscap_Z = false ;
      SetDirty("Famdiscap_Z");
   }

   public boolean getgxTv_SdtLegajo_Familia_Famdiscap_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLegajo_Familia_Famtomadeducimpgan_Z( )
   {
      return gxTv_SdtLegajo_Familia_Famtomadeducimpgan_Z ;
   }

   public void setgxTv_SdtLegajo_Familia_Famtomadeducimpgan_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Modified = (short)(1) ;
      SetDirty("Famtomadeducimpgan_Z");
      gxTv_SdtLegajo_Familia_Famtomadeducimpgan_Z = value ;
   }

   public void setgxTv_SdtLegajo_Familia_Famtomadeducimpgan_Z_SetNull( )
   {
      gxTv_SdtLegajo_Familia_Famtomadeducimpgan_Z = DecimalUtil.ZERO ;
      SetDirty("Famtomadeducimpgan_Z");
   }

   public boolean getgxTv_SdtLegajo_Familia_Famtomadeducimpgan_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Familia_Famnrodoc_Z( )
   {
      return gxTv_SdtLegajo_Familia_Famnrodoc_Z ;
   }

   public void setgxTv_SdtLegajo_Familia_Famnrodoc_Z( String value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Modified = (short)(1) ;
      SetDirty("Famnrodoc_Z");
      gxTv_SdtLegajo_Familia_Famnrodoc_Z = value ;
   }

   public void setgxTv_SdtLegajo_Familia_Famnrodoc_Z_SetNull( )
   {
      gxTv_SdtLegajo_Familia_Famnrodoc_Z = "" ;
      SetDirty("Famnrodoc_Z");
   }

   public boolean getgxTv_SdtLegajo_Familia_Famnrodoc_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtLegajo_Familia_Famadherente_Z( )
   {
      return gxTv_SdtLegajo_Familia_Famadherente_Z ;
   }

   public void setgxTv_SdtLegajo_Familia_Famadherente_Z( boolean value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Modified = (short)(1) ;
      SetDirty("Famadherente_Z");
      gxTv_SdtLegajo_Familia_Famadherente_Z = value ;
   }

   public void setgxTv_SdtLegajo_Familia_Famadherente_Z_SetNull( )
   {
      gxTv_SdtLegajo_Familia_Famadherente_Z = false ;
      SetDirty("Famadherente_Z");
   }

   public boolean getgxTv_SdtLegajo_Familia_Famadherente_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLegajo_Familia_Guarcod_Z( )
   {
      return gxTv_SdtLegajo_Familia_Guarcod_Z ;
   }

   public void setgxTv_SdtLegajo_Familia_Guarcod_Z( short value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Modified = (short)(1) ;
      SetDirty("Guarcod_Z");
      gxTv_SdtLegajo_Familia_Guarcod_Z = value ;
   }

   public void setgxTv_SdtLegajo_Familia_Guarcod_Z_SetNull( )
   {
      gxTv_SdtLegajo_Familia_Guarcod_Z = (short)(0) ;
      SetDirty("Guarcod_Z");
   }

   public boolean getgxTv_SdtLegajo_Familia_Guarcod_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Familia_Famfecnac_N( )
   {
      return gxTv_SdtLegajo_Familia_Famfecnac_N ;
   }

   public void setgxTv_SdtLegajo_Familia_Famfecnac_N( byte value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Modified = (short)(1) ;
      SetDirty("Famfecnac_N");
      gxTv_SdtLegajo_Familia_Famfecnac_N = value ;
   }

   public void setgxTv_SdtLegajo_Familia_Famfecnac_N_SetNull( )
   {
      gxTv_SdtLegajo_Familia_Famfecnac_N = (byte)(0) ;
      SetDirty("Famfecnac_N");
   }

   public boolean getgxTv_SdtLegajo_Familia_Famfecnac_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Familia_Famdiscap_N( )
   {
      return gxTv_SdtLegajo_Familia_Famdiscap_N ;
   }

   public void setgxTv_SdtLegajo_Familia_Famdiscap_N( byte value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Modified = (short)(1) ;
      SetDirty("Famdiscap_N");
      gxTv_SdtLegajo_Familia_Famdiscap_N = value ;
   }

   public void setgxTv_SdtLegajo_Familia_Famdiscap_N_SetNull( )
   {
      gxTv_SdtLegajo_Familia_Famdiscap_N = (byte)(0) ;
      SetDirty("Famdiscap_N");
   }

   public boolean getgxTv_SdtLegajo_Familia_Famdiscap_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Familia_Guarcod_N( )
   {
      return gxTv_SdtLegajo_Familia_Guarcod_N ;
   }

   public void setgxTv_SdtLegajo_Familia_Guarcod_N( byte value )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(0) ;
      gxTv_SdtLegajo_Familia_Modified = (short)(1) ;
      SetDirty("Guarcod_N");
      gxTv_SdtLegajo_Familia_Guarcod_N = value ;
   }

   public void setgxTv_SdtLegajo_Familia_Guarcod_N_SetNull( )
   {
      gxTv_SdtLegajo_Familia_Guarcod_N = (byte)(0) ;
      SetDirty("Guarcod_N");
   }

   public boolean getgxTv_SdtLegajo_Familia_Guarcod_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtLegajo_Familia_N = (byte)(1) ;
      gxTv_SdtLegajo_Familia_Famnomape = "" ;
      gxTv_SdtLegajo_Familia_Parcod = "" ;
      gxTv_SdtLegajo_Familia_Famfecnac = GXutil.nullDate() ;
      gxTv_SdtLegajo_Familia_Famtomadeducimpgan = DecimalUtil.ZERO ;
      gxTv_SdtLegajo_Familia_Famnrodoc = "" ;
      gxTv_SdtLegajo_Familia_Mode = "" ;
      gxTv_SdtLegajo_Familia_Famnomape_Z = "" ;
      gxTv_SdtLegajo_Familia_Parcod_Z = "" ;
      gxTv_SdtLegajo_Familia_Famfecnac_Z = GXutil.nullDate() ;
      gxTv_SdtLegajo_Familia_Famtomadeducimpgan_Z = DecimalUtil.ZERO ;
      gxTv_SdtLegajo_Familia_Famnrodoc_Z = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtLegajo_Familia_N ;
   }

   public web.SdtLegajo_Familia Clone( )
   {
      return (web.SdtLegajo_Familia)(clone()) ;
   }

   public void setStruct( web.StructSdtLegajo_Familia struct )
   {
      setgxTv_SdtLegajo_Familia_Legorden(struct.getLegorden());
      setgxTv_SdtLegajo_Familia_Famnomape(struct.getFamnomape());
      setgxTv_SdtLegajo_Familia_Parcod(struct.getParcod());
      setgxTv_SdtLegajo_Familia_Famfecnac(struct.getFamfecnac());
      setgxTv_SdtLegajo_Familia_Famdiscap(struct.getFamdiscap());
      setgxTv_SdtLegajo_Familia_Famtomadeducimpgan(struct.getFamtomadeducimpgan());
      setgxTv_SdtLegajo_Familia_Famnrodoc(struct.getFamnrodoc());
      setgxTv_SdtLegajo_Familia_Famadherente(struct.getFamadherente());
      setgxTv_SdtLegajo_Familia_Guarcod(struct.getGuarcod());
      setgxTv_SdtLegajo_Familia_Mode(struct.getMode());
      setgxTv_SdtLegajo_Familia_Modified(struct.getModified());
      setgxTv_SdtLegajo_Familia_Initialized(struct.getInitialized());
      setgxTv_SdtLegajo_Familia_Legorden_Z(struct.getLegorden_Z());
      setgxTv_SdtLegajo_Familia_Famnomape_Z(struct.getFamnomape_Z());
      setgxTv_SdtLegajo_Familia_Parcod_Z(struct.getParcod_Z());
      setgxTv_SdtLegajo_Familia_Famfecnac_Z(struct.getFamfecnac_Z());
      setgxTv_SdtLegajo_Familia_Famdiscap_Z(struct.getFamdiscap_Z());
      setgxTv_SdtLegajo_Familia_Famtomadeducimpgan_Z(struct.getFamtomadeducimpgan_Z());
      setgxTv_SdtLegajo_Familia_Famnrodoc_Z(struct.getFamnrodoc_Z());
      setgxTv_SdtLegajo_Familia_Famadherente_Z(struct.getFamadherente_Z());
      setgxTv_SdtLegajo_Familia_Guarcod_Z(struct.getGuarcod_Z());
      setgxTv_SdtLegajo_Familia_Famfecnac_N(struct.getFamfecnac_N());
      setgxTv_SdtLegajo_Familia_Famdiscap_N(struct.getFamdiscap_N());
      setgxTv_SdtLegajo_Familia_Guarcod_N(struct.getGuarcod_N());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtLegajo_Familia getStruct( )
   {
      web.StructSdtLegajo_Familia struct = new web.StructSdtLegajo_Familia ();
      struct.setLegorden(getgxTv_SdtLegajo_Familia_Legorden());
      struct.setFamnomape(getgxTv_SdtLegajo_Familia_Famnomape());
      struct.setParcod(getgxTv_SdtLegajo_Familia_Parcod());
      struct.setFamfecnac(getgxTv_SdtLegajo_Familia_Famfecnac());
      struct.setFamdiscap(getgxTv_SdtLegajo_Familia_Famdiscap());
      struct.setFamtomadeducimpgan(getgxTv_SdtLegajo_Familia_Famtomadeducimpgan());
      struct.setFamnrodoc(getgxTv_SdtLegajo_Familia_Famnrodoc());
      struct.setFamadherente(getgxTv_SdtLegajo_Familia_Famadherente());
      struct.setGuarcod(getgxTv_SdtLegajo_Familia_Guarcod());
      struct.setMode(getgxTv_SdtLegajo_Familia_Mode());
      struct.setModified(getgxTv_SdtLegajo_Familia_Modified());
      struct.setInitialized(getgxTv_SdtLegajo_Familia_Initialized());
      struct.setLegorden_Z(getgxTv_SdtLegajo_Familia_Legorden_Z());
      struct.setFamnomape_Z(getgxTv_SdtLegajo_Familia_Famnomape_Z());
      struct.setParcod_Z(getgxTv_SdtLegajo_Familia_Parcod_Z());
      struct.setFamfecnac_Z(getgxTv_SdtLegajo_Familia_Famfecnac_Z());
      struct.setFamdiscap_Z(getgxTv_SdtLegajo_Familia_Famdiscap_Z());
      struct.setFamtomadeducimpgan_Z(getgxTv_SdtLegajo_Familia_Famtomadeducimpgan_Z());
      struct.setFamnrodoc_Z(getgxTv_SdtLegajo_Familia_Famnrodoc_Z());
      struct.setFamadherente_Z(getgxTv_SdtLegajo_Familia_Famadherente_Z());
      struct.setGuarcod_Z(getgxTv_SdtLegajo_Familia_Guarcod_Z());
      struct.setFamfecnac_N(getgxTv_SdtLegajo_Familia_Famfecnac_N());
      struct.setFamdiscap_N(getgxTv_SdtLegajo_Familia_Famdiscap_N());
      struct.setGuarcod_N(getgxTv_SdtLegajo_Familia_Guarcod_N());
      return struct ;
   }

   private byte gxTv_SdtLegajo_Familia_N ;
   private byte gxTv_SdtLegajo_Familia_Famfecnac_N ;
   private byte gxTv_SdtLegajo_Familia_Famdiscap_N ;
   private byte gxTv_SdtLegajo_Familia_Guarcod_N ;
   private short gxTv_SdtLegajo_Familia_Legorden ;
   private short gxTv_SdtLegajo_Familia_Guarcod ;
   private short gxTv_SdtLegajo_Familia_Modified ;
   private short gxTv_SdtLegajo_Familia_Initialized ;
   private short gxTv_SdtLegajo_Familia_Legorden_Z ;
   private short gxTv_SdtLegajo_Familia_Guarcod_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private java.math.BigDecimal gxTv_SdtLegajo_Familia_Famtomadeducimpgan ;
   private java.math.BigDecimal gxTv_SdtLegajo_Familia_Famtomadeducimpgan_Z ;
   private String gxTv_SdtLegajo_Familia_Parcod ;
   private String gxTv_SdtLegajo_Familia_Famnrodoc ;
   private String gxTv_SdtLegajo_Familia_Mode ;
   private String gxTv_SdtLegajo_Familia_Parcod_Z ;
   private String gxTv_SdtLegajo_Familia_Famnrodoc_Z ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtLegajo_Familia_Famfecnac ;
   private java.util.Date gxTv_SdtLegajo_Familia_Famfecnac_Z ;
   private boolean gxTv_SdtLegajo_Familia_Famdiscap ;
   private boolean gxTv_SdtLegajo_Familia_Famadherente ;
   private boolean gxTv_SdtLegajo_Familia_Famdiscap_Z ;
   private boolean gxTv_SdtLegajo_Familia_Famadherente_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtLegajo_Familia_Famnomape ;
   private String gxTv_SdtLegajo_Familia_Famnomape_Z ;
}

