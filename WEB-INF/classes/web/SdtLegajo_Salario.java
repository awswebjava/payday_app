package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtLegajo_Salario extends GxSilentTrnSdt
{
   public SdtLegajo_Salario( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtLegajo_Salario.class));
   }

   public SdtLegajo_Salario( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle, context, "SdtLegajo_Salario");
      initialize( remoteHandle) ;
   }

   public SdtLegajo_Salario( int remoteHandle ,
                             StructSdtLegajo_Salario struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtLegajo_Salario( )
   {
      super( new ModelContext(SdtLegajo_Salario.class), "SdtLegajo_Salario");
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
      return (Object[][])(new Object[][]{new Object[]{"LegSuelSec", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Salario");
      metadata.set("BT", "legajo_sueldos");
      metadata.set("PK", "[ \"LegSuelSec\" ]");
      metadata.set("PKAssigned", "[ \"LegSuelSec\" ]");
      metadata.set("Levels", "[ \"Conceptos\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"EmpCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"EmpCod\",\"LegNumero\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSuelSec") )
            {
               gxTv_SdtLegajo_Salario_Legsuelsec = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSuelFecha") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLegajo_Salario_Legsuelfecha = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLegajo_Salario_Legsuelfecha = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSuelImporte") )
            {
               gxTv_SdtLegajo_Salario_Legsuelimporte = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSuelTipo") )
            {
               gxTv_SdtLegajo_Salario_Legsueltipo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSuelCalc") )
            {
               gxTv_SdtLegajo_Salario_Legsuelcalc = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSuelLog") )
            {
               gxTv_SdtLegajo_Salario_Legsuellog = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Conceptos") )
            {
               if ( gxTv_SdtLegajo_Salario_Conceptos == null )
               {
                  gxTv_SdtLegajo_Salario_Conceptos = new GXBCLevelCollection<web.SdtLegajo_Salario_Conceptos>(web.SdtLegajo_Salario_Conceptos.class, "Legajo.Salario.Conceptos", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtLegajo_Salario_Conceptos.readxml(oReader, "Conceptos") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Conceptos") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtLegajo_Salario_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtLegajo_Salario_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtLegajo_Salario_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSuelSec_Z") )
            {
               gxTv_SdtLegajo_Salario_Legsuelsec_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSuelFecha_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLegajo_Salario_Legsuelfecha_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLegajo_Salario_Legsuelfecha_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSuelImporte_Z") )
            {
               gxTv_SdtLegajo_Salario_Legsuelimporte_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSuelTipo_Z") )
            {
               gxTv_SdtLegajo_Salario_Legsueltipo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSuelCalc_Z") )
            {
               gxTv_SdtLegajo_Salario_Legsuelcalc_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSuelTipo_N") )
            {
               gxTv_SdtLegajo_Salario_Legsueltipo_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "Legajo.Salario" ;
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
      oWriter.writeElement("LegSuelSec", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Salario_Legsuelsec, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Salario_Legsuelfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Salario_Legsuelfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Salario_Legsuelfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("LegSuelFecha", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegSuelImporte", GXutil.trim( GXutil.strNoRound( gxTv_SdtLegajo_Salario_Legsuelimporte, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegSuelTipo", gxTv_SdtLegajo_Salario_Legsueltipo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegSuelCalc", GXutil.trim( GXutil.strNoRound( gxTv_SdtLegajo_Salario_Legsuelcalc, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegSuelLog", gxTv_SdtLegajo_Salario_Legsuellog);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( gxTv_SdtLegajo_Salario_Conceptos != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "PayDay") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "PayDay" ;
         }
         else
         {
            sNameSpace1 = "PayDay" ;
         }
         gxTv_SdtLegajo_Salario_Conceptos.writexml(oWriter, "Conceptos", sNameSpace1, sIncludeState);
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtLegajo_Salario_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Salario_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Salario_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegSuelSec_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Salario_Legsuelsec_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Salario_Legsuelfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Salario_Legsuelfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Salario_Legsuelfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LegSuelFecha_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegSuelImporte_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLegajo_Salario_Legsuelimporte_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegSuelTipo_Z", gxTv_SdtLegajo_Salario_Legsueltipo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegSuelCalc_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLegajo_Salario_Legsuelcalc_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegSuelTipo_N", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Salario_Legsueltipo_N, 1, 0)));
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
      AddObjectProperty("LegSuelSec", gxTv_SdtLegajo_Salario_Legsuelsec, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Salario_Legsuelfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Salario_Legsuelfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Salario_Legsuelfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LegSuelFecha", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("LegSuelImporte", gxTv_SdtLegajo_Salario_Legsuelimporte, false, includeNonInitialized);
      AddObjectProperty("LegSuelTipo", gxTv_SdtLegajo_Salario_Legsueltipo, false, includeNonInitialized);
      AddObjectProperty("LegSuelTipo_N", gxTv_SdtLegajo_Salario_Legsueltipo_N, false, includeNonInitialized);
      AddObjectProperty("LegSuelCalc", gxTv_SdtLegajo_Salario_Legsuelcalc, false, includeNonInitialized);
      AddObjectProperty("LegSuelLog", gxTv_SdtLegajo_Salario_Legsuellog, false, includeNonInitialized);
      if ( gxTv_SdtLegajo_Salario_Conceptos != null )
      {
         AddObjectProperty("Conceptos", gxTv_SdtLegajo_Salario_Conceptos, includeState, includeNonInitialized);
      }
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtLegajo_Salario_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtLegajo_Salario_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtLegajo_Salario_Initialized, false, includeNonInitialized);
         AddObjectProperty("LegSuelSec_Z", gxTv_SdtLegajo_Salario_Legsuelsec_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLegajo_Salario_Legsuelfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLegajo_Salario_Legsuelfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLegajo_Salario_Legsuelfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("LegSuelFecha_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("LegSuelImporte_Z", gxTv_SdtLegajo_Salario_Legsuelimporte_Z, false, includeNonInitialized);
         AddObjectProperty("LegSuelTipo_Z", gxTv_SdtLegajo_Salario_Legsueltipo_Z, false, includeNonInitialized);
         AddObjectProperty("LegSuelCalc_Z", gxTv_SdtLegajo_Salario_Legsuelcalc_Z, false, includeNonInitialized);
         AddObjectProperty("LegSuelTipo_N", gxTv_SdtLegajo_Salario_Legsueltipo_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtLegajo_Salario sdt )
   {
      if ( sdt.IsDirty("LegSuelSec") )
      {
         gxTv_SdtLegajo_Salario_N = (byte)(0) ;
         gxTv_SdtLegajo_Salario_Legsuelsec = sdt.getgxTv_SdtLegajo_Salario_Legsuelsec() ;
      }
      if ( sdt.IsDirty("LegSuelFecha") )
      {
         gxTv_SdtLegajo_Salario_N = (byte)(0) ;
         gxTv_SdtLegajo_Salario_Legsuelfecha = sdt.getgxTv_SdtLegajo_Salario_Legsuelfecha() ;
      }
      if ( sdt.IsDirty("LegSuelImporte") )
      {
         gxTv_SdtLegajo_Salario_N = (byte)(0) ;
         gxTv_SdtLegajo_Salario_Legsuelimporte = sdt.getgxTv_SdtLegajo_Salario_Legsuelimporte() ;
      }
      if ( sdt.IsDirty("LegSuelTipo") )
      {
         gxTv_SdtLegajo_Salario_Legsueltipo_N = sdt.getgxTv_SdtLegajo_Salario_Legsueltipo_N() ;
         gxTv_SdtLegajo_Salario_N = (byte)(0) ;
         gxTv_SdtLegajo_Salario_Legsueltipo = sdt.getgxTv_SdtLegajo_Salario_Legsueltipo() ;
      }
      if ( sdt.IsDirty("LegSuelCalc") )
      {
         gxTv_SdtLegajo_Salario_N = (byte)(0) ;
         gxTv_SdtLegajo_Salario_Legsuelcalc = sdt.getgxTv_SdtLegajo_Salario_Legsuelcalc() ;
      }
      if ( sdt.IsDirty("LegSuelLog") )
      {
         gxTv_SdtLegajo_Salario_N = (byte)(0) ;
         gxTv_SdtLegajo_Salario_Legsuellog = sdt.getgxTv_SdtLegajo_Salario_Legsuellog() ;
      }
      if ( gxTv_SdtLegajo_Salario_Conceptos != null )
      {
         GXBCLevelCollection<web.SdtLegajo_Salario_Conceptos> newCollectionConceptos = sdt.getgxTv_SdtLegajo_Salario_Conceptos();
         web.SdtLegajo_Salario_Conceptos currItemConceptos;
         web.SdtLegajo_Salario_Conceptos newItemConceptos;
         short idx = 1;
         while ( idx <= newCollectionConceptos.size() )
         {
            newItemConceptos = (web.SdtLegajo_Salario_Conceptos)((web.SdtLegajo_Salario_Conceptos)newCollectionConceptos.elementAt(-1+idx));
            currItemConceptos = (web.SdtLegajo_Salario_Conceptos)gxTv_SdtLegajo_Salario_Conceptos.getByKey(newItemConceptos.getgxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto());
            if ( GXutil.strcmp(currItemConceptos.getgxTv_SdtLegajo_Salario_Conceptos_Mode(), "UPD") == 0 )
            {
               currItemConceptos.updateDirties(newItemConceptos);
               if ( GXutil.strcmp(newItemConceptos.getgxTv_SdtLegajo_Salario_Conceptos_Mode(), "DLT") == 0 )
               {
                  currItemConceptos.setgxTv_SdtLegajo_Salario_Conceptos_Mode( "DLT" );
               }
               currItemConceptos.setgxTv_SdtLegajo_Salario_Conceptos_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtLegajo_Salario_Conceptos.add(newItemConceptos, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
   }

   public short getgxTv_SdtLegajo_Salario_Legsuelsec( )
   {
      return gxTv_SdtLegajo_Salario_Legsuelsec ;
   }

   public void setgxTv_SdtLegajo_Salario_Legsuelsec( short value )
   {
      gxTv_SdtLegajo_Salario_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Modified = (short)(1) ;
      SetDirty("Legsuelsec");
      gxTv_SdtLegajo_Salario_Legsuelsec = value ;
   }

   public java.util.Date getgxTv_SdtLegajo_Salario_Legsuelfecha( )
   {
      return gxTv_SdtLegajo_Salario_Legsuelfecha ;
   }

   public void setgxTv_SdtLegajo_Salario_Legsuelfecha( java.util.Date value )
   {
      gxTv_SdtLegajo_Salario_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Modified = (short)(1) ;
      SetDirty("Legsuelfecha");
      gxTv_SdtLegajo_Salario_Legsuelfecha = value ;
   }

   public java.math.BigDecimal getgxTv_SdtLegajo_Salario_Legsuelimporte( )
   {
      return gxTv_SdtLegajo_Salario_Legsuelimporte ;
   }

   public void setgxTv_SdtLegajo_Salario_Legsuelimporte( java.math.BigDecimal value )
   {
      gxTv_SdtLegajo_Salario_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Modified = (short)(1) ;
      SetDirty("Legsuelimporte");
      gxTv_SdtLegajo_Salario_Legsuelimporte = value ;
   }

   public String getgxTv_SdtLegajo_Salario_Legsueltipo( )
   {
      return gxTv_SdtLegajo_Salario_Legsueltipo ;
   }

   public void setgxTv_SdtLegajo_Salario_Legsueltipo( String value )
   {
      gxTv_SdtLegajo_Salario_Legsueltipo_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Modified = (short)(1) ;
      SetDirty("Legsueltipo");
      gxTv_SdtLegajo_Salario_Legsueltipo = value ;
   }

   public void setgxTv_SdtLegajo_Salario_Legsueltipo_SetNull( )
   {
      gxTv_SdtLegajo_Salario_Legsueltipo_N = (byte)(1) ;
      gxTv_SdtLegajo_Salario_Legsueltipo = "" ;
      SetDirty("Legsueltipo");
   }

   public boolean getgxTv_SdtLegajo_Salario_Legsueltipo_IsNull( )
   {
      return (gxTv_SdtLegajo_Salario_Legsueltipo_N==1) ;
   }

   public java.math.BigDecimal getgxTv_SdtLegajo_Salario_Legsuelcalc( )
   {
      return gxTv_SdtLegajo_Salario_Legsuelcalc ;
   }

   public void setgxTv_SdtLegajo_Salario_Legsuelcalc( java.math.BigDecimal value )
   {
      gxTv_SdtLegajo_Salario_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Modified = (short)(1) ;
      SetDirty("Legsuelcalc");
      gxTv_SdtLegajo_Salario_Legsuelcalc = value ;
   }

   public String getgxTv_SdtLegajo_Salario_Legsuellog( )
   {
      return gxTv_SdtLegajo_Salario_Legsuellog ;
   }

   public void setgxTv_SdtLegajo_Salario_Legsuellog( String value )
   {
      gxTv_SdtLegajo_Salario_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Modified = (short)(1) ;
      SetDirty("Legsuellog");
      gxTv_SdtLegajo_Salario_Legsuellog = value ;
   }

   public GXBCLevelCollection<web.SdtLegajo_Salario_Conceptos> getgxTv_SdtLegajo_Salario_Conceptos( )
   {
      if ( gxTv_SdtLegajo_Salario_Conceptos == null )
      {
         gxTv_SdtLegajo_Salario_Conceptos = new GXBCLevelCollection<web.SdtLegajo_Salario_Conceptos>(web.SdtLegajo_Salario_Conceptos.class, "Legajo.Salario.Conceptos", "PayDay", remoteHandle);
      }
      gxTv_SdtLegajo_Salario_N = (byte)(0) ;
      return gxTv_SdtLegajo_Salario_Conceptos ;
   }

   public void setgxTv_SdtLegajo_Salario_Conceptos( GXBCLevelCollection<web.SdtLegajo_Salario_Conceptos> value )
   {
      gxTv_SdtLegajo_Salario_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Modified = (short)(1) ;
      SetDirty("Conceptos");
      gxTv_SdtLegajo_Salario_Conceptos = value ;
   }

   public void setgxTv_SdtLegajo_Salario_Conceptos_SetNull( )
   {
      gxTv_SdtLegajo_Salario_Conceptos = null ;
      SetDirty("Conceptos");
   }

   public boolean getgxTv_SdtLegajo_Salario_Conceptos_IsNull( )
   {
      if ( gxTv_SdtLegajo_Salario_Conceptos == null )
      {
         return true ;
      }
      return false ;
   }

   public String getgxTv_SdtLegajo_Salario_Mode( )
   {
      return gxTv_SdtLegajo_Salario_Mode ;
   }

   public void setgxTv_SdtLegajo_Salario_Mode( String value )
   {
      gxTv_SdtLegajo_Salario_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtLegajo_Salario_Mode = value ;
   }

   public void setgxTv_SdtLegajo_Salario_Mode_SetNull( )
   {
      gxTv_SdtLegajo_Salario_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtLegajo_Salario_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLegajo_Salario_Modified( )
   {
      return gxTv_SdtLegajo_Salario_Modified ;
   }

   public void setgxTv_SdtLegajo_Salario_Modified( short value )
   {
      gxTv_SdtLegajo_Salario_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtLegajo_Salario_Modified = value ;
   }

   public void setgxTv_SdtLegajo_Salario_Modified_SetNull( )
   {
      gxTv_SdtLegajo_Salario_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtLegajo_Salario_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLegajo_Salario_Initialized( )
   {
      return gxTv_SdtLegajo_Salario_Initialized ;
   }

   public void setgxTv_SdtLegajo_Salario_Initialized( short value )
   {
      gxTv_SdtLegajo_Salario_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtLegajo_Salario_Initialized = value ;
   }

   public void setgxTv_SdtLegajo_Salario_Initialized_SetNull( )
   {
      gxTv_SdtLegajo_Salario_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtLegajo_Salario_Initialized_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLegajo_Salario_Legsuelsec_Z( )
   {
      return gxTv_SdtLegajo_Salario_Legsuelsec_Z ;
   }

   public void setgxTv_SdtLegajo_Salario_Legsuelsec_Z( short value )
   {
      gxTv_SdtLegajo_Salario_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Modified = (short)(1) ;
      SetDirty("Legsuelsec_Z");
      gxTv_SdtLegajo_Salario_Legsuelsec_Z = value ;
   }

   public void setgxTv_SdtLegajo_Salario_Legsuelsec_Z_SetNull( )
   {
      gxTv_SdtLegajo_Salario_Legsuelsec_Z = (short)(0) ;
      SetDirty("Legsuelsec_Z");
   }

   public boolean getgxTv_SdtLegajo_Salario_Legsuelsec_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtLegajo_Salario_Legsuelfecha_Z( )
   {
      return gxTv_SdtLegajo_Salario_Legsuelfecha_Z ;
   }

   public void setgxTv_SdtLegajo_Salario_Legsuelfecha_Z( java.util.Date value )
   {
      gxTv_SdtLegajo_Salario_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Modified = (short)(1) ;
      SetDirty("Legsuelfecha_Z");
      gxTv_SdtLegajo_Salario_Legsuelfecha_Z = value ;
   }

   public void setgxTv_SdtLegajo_Salario_Legsuelfecha_Z_SetNull( )
   {
      gxTv_SdtLegajo_Salario_Legsuelfecha_Z = GXutil.nullDate() ;
      SetDirty("Legsuelfecha_Z");
   }

   public boolean getgxTv_SdtLegajo_Salario_Legsuelfecha_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLegajo_Salario_Legsuelimporte_Z( )
   {
      return gxTv_SdtLegajo_Salario_Legsuelimporte_Z ;
   }

   public void setgxTv_SdtLegajo_Salario_Legsuelimporte_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLegajo_Salario_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Modified = (short)(1) ;
      SetDirty("Legsuelimporte_Z");
      gxTv_SdtLegajo_Salario_Legsuelimporte_Z = value ;
   }

   public void setgxTv_SdtLegajo_Salario_Legsuelimporte_Z_SetNull( )
   {
      gxTv_SdtLegajo_Salario_Legsuelimporte_Z = DecimalUtil.ZERO ;
      SetDirty("Legsuelimporte_Z");
   }

   public boolean getgxTv_SdtLegajo_Salario_Legsuelimporte_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Salario_Legsueltipo_Z( )
   {
      return gxTv_SdtLegajo_Salario_Legsueltipo_Z ;
   }

   public void setgxTv_SdtLegajo_Salario_Legsueltipo_Z( String value )
   {
      gxTv_SdtLegajo_Salario_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Modified = (short)(1) ;
      SetDirty("Legsueltipo_Z");
      gxTv_SdtLegajo_Salario_Legsueltipo_Z = value ;
   }

   public void setgxTv_SdtLegajo_Salario_Legsueltipo_Z_SetNull( )
   {
      gxTv_SdtLegajo_Salario_Legsueltipo_Z = "" ;
      SetDirty("Legsueltipo_Z");
   }

   public boolean getgxTv_SdtLegajo_Salario_Legsueltipo_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLegajo_Salario_Legsuelcalc_Z( )
   {
      return gxTv_SdtLegajo_Salario_Legsuelcalc_Z ;
   }

   public void setgxTv_SdtLegajo_Salario_Legsuelcalc_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLegajo_Salario_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Modified = (short)(1) ;
      SetDirty("Legsuelcalc_Z");
      gxTv_SdtLegajo_Salario_Legsuelcalc_Z = value ;
   }

   public void setgxTv_SdtLegajo_Salario_Legsuelcalc_Z_SetNull( )
   {
      gxTv_SdtLegajo_Salario_Legsuelcalc_Z = DecimalUtil.ZERO ;
      SetDirty("Legsuelcalc_Z");
   }

   public boolean getgxTv_SdtLegajo_Salario_Legsuelcalc_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLegajo_Salario_Legsueltipo_N( )
   {
      return gxTv_SdtLegajo_Salario_Legsueltipo_N ;
   }

   public void setgxTv_SdtLegajo_Salario_Legsueltipo_N( byte value )
   {
      gxTv_SdtLegajo_Salario_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Modified = (short)(1) ;
      SetDirty("Legsueltipo_N");
      gxTv_SdtLegajo_Salario_Legsueltipo_N = value ;
   }

   public void setgxTv_SdtLegajo_Salario_Legsueltipo_N_SetNull( )
   {
      gxTv_SdtLegajo_Salario_Legsueltipo_N = (byte)(0) ;
      SetDirty("Legsueltipo_N");
   }

   public boolean getgxTv_SdtLegajo_Salario_Legsueltipo_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtLegajo_Salario_N = (byte)(1) ;
      gxTv_SdtLegajo_Salario_Legsuelfecha = GXutil.nullDate() ;
      gxTv_SdtLegajo_Salario_Legsuelimporte = DecimalUtil.ZERO ;
      gxTv_SdtLegajo_Salario_Legsueltipo = "" ;
      gxTv_SdtLegajo_Salario_Legsuelcalc = DecimalUtil.ZERO ;
      gxTv_SdtLegajo_Salario_Legsuellog = "" ;
      gxTv_SdtLegajo_Salario_Mode = "" ;
      gxTv_SdtLegajo_Salario_Legsuelfecha_Z = GXutil.nullDate() ;
      gxTv_SdtLegajo_Salario_Legsuelimporte_Z = DecimalUtil.ZERO ;
      gxTv_SdtLegajo_Salario_Legsueltipo_Z = "" ;
      gxTv_SdtLegajo_Salario_Legsuelcalc_Z = DecimalUtil.ZERO ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtLegajo_Salario_N ;
   }

   public web.SdtLegajo_Salario Clone( )
   {
      return (web.SdtLegajo_Salario)(clone()) ;
   }

   public void setStruct( web.StructSdtLegajo_Salario struct )
   {
      setgxTv_SdtLegajo_Salario_Legsuelsec(struct.getLegsuelsec());
      setgxTv_SdtLegajo_Salario_Legsuelfecha(struct.getLegsuelfecha());
      setgxTv_SdtLegajo_Salario_Legsuelimporte(struct.getLegsuelimporte());
      setgxTv_SdtLegajo_Salario_Legsueltipo(struct.getLegsueltipo());
      setgxTv_SdtLegajo_Salario_Legsuelcalc(struct.getLegsuelcalc());
      setgxTv_SdtLegajo_Salario_Legsuellog(struct.getLegsuellog());
      GXBCLevelCollection<web.SdtLegajo_Salario_Conceptos> gxTv_SdtLegajo_Salario_Conceptos_aux = new GXBCLevelCollection<web.SdtLegajo_Salario_Conceptos>(web.SdtLegajo_Salario_Conceptos.class, "Legajo.Salario.Conceptos", "PayDay", remoteHandle);
      Vector<web.StructSdtLegajo_Salario_Conceptos> gxTv_SdtLegajo_Salario_Conceptos_aux1 = struct.getConceptos();
      if (gxTv_SdtLegajo_Salario_Conceptos_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtLegajo_Salario_Conceptos_aux1.size(); i++)
         {
            gxTv_SdtLegajo_Salario_Conceptos_aux.add(new web.SdtLegajo_Salario_Conceptos(remoteHandle, gxTv_SdtLegajo_Salario_Conceptos_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtLegajo_Salario_Conceptos(gxTv_SdtLegajo_Salario_Conceptos_aux);
      setgxTv_SdtLegajo_Salario_Mode(struct.getMode());
      setgxTv_SdtLegajo_Salario_Modified(struct.getModified());
      setgxTv_SdtLegajo_Salario_Initialized(struct.getInitialized());
      setgxTv_SdtLegajo_Salario_Legsuelsec_Z(struct.getLegsuelsec_Z());
      setgxTv_SdtLegajo_Salario_Legsuelfecha_Z(struct.getLegsuelfecha_Z());
      setgxTv_SdtLegajo_Salario_Legsuelimporte_Z(struct.getLegsuelimporte_Z());
      setgxTv_SdtLegajo_Salario_Legsueltipo_Z(struct.getLegsueltipo_Z());
      setgxTv_SdtLegajo_Salario_Legsuelcalc_Z(struct.getLegsuelcalc_Z());
      setgxTv_SdtLegajo_Salario_Legsueltipo_N(struct.getLegsueltipo_N());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtLegajo_Salario getStruct( )
   {
      web.StructSdtLegajo_Salario struct = new web.StructSdtLegajo_Salario ();
      struct.setLegsuelsec(getgxTv_SdtLegajo_Salario_Legsuelsec());
      struct.setLegsuelfecha(getgxTv_SdtLegajo_Salario_Legsuelfecha());
      struct.setLegsuelimporte(getgxTv_SdtLegajo_Salario_Legsuelimporte());
      struct.setLegsueltipo(getgxTv_SdtLegajo_Salario_Legsueltipo());
      struct.setLegsuelcalc(getgxTv_SdtLegajo_Salario_Legsuelcalc());
      struct.setLegsuellog(getgxTv_SdtLegajo_Salario_Legsuellog());
      struct.setConceptos(getgxTv_SdtLegajo_Salario_Conceptos().getStruct());
      struct.setMode(getgxTv_SdtLegajo_Salario_Mode());
      struct.setModified(getgxTv_SdtLegajo_Salario_Modified());
      struct.setInitialized(getgxTv_SdtLegajo_Salario_Initialized());
      struct.setLegsuelsec_Z(getgxTv_SdtLegajo_Salario_Legsuelsec_Z());
      struct.setLegsuelfecha_Z(getgxTv_SdtLegajo_Salario_Legsuelfecha_Z());
      struct.setLegsuelimporte_Z(getgxTv_SdtLegajo_Salario_Legsuelimporte_Z());
      struct.setLegsueltipo_Z(getgxTv_SdtLegajo_Salario_Legsueltipo_Z());
      struct.setLegsuelcalc_Z(getgxTv_SdtLegajo_Salario_Legsuelcalc_Z());
      struct.setLegsueltipo_N(getgxTv_SdtLegajo_Salario_Legsueltipo_N());
      return struct ;
   }

   private byte gxTv_SdtLegajo_Salario_N ;
   private byte gxTv_SdtLegajo_Salario_Legsueltipo_N ;
   private short gxTv_SdtLegajo_Salario_Legsuelsec ;
   private short gxTv_SdtLegajo_Salario_Modified ;
   private short gxTv_SdtLegajo_Salario_Initialized ;
   private short gxTv_SdtLegajo_Salario_Legsuelsec_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private java.math.BigDecimal gxTv_SdtLegajo_Salario_Legsuelimporte ;
   private java.math.BigDecimal gxTv_SdtLegajo_Salario_Legsuelcalc ;
   private java.math.BigDecimal gxTv_SdtLegajo_Salario_Legsuelimporte_Z ;
   private java.math.BigDecimal gxTv_SdtLegajo_Salario_Legsuelcalc_Z ;
   private String gxTv_SdtLegajo_Salario_Legsueltipo ;
   private String gxTv_SdtLegajo_Salario_Mode ;
   private String gxTv_SdtLegajo_Salario_Legsueltipo_Z ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtLegajo_Salario_Legsuelfecha ;
   private java.util.Date gxTv_SdtLegajo_Salario_Legsuelfecha_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtLegajo_Salario_Legsuellog ;
   private GXBCLevelCollection<web.SdtLegajo_Salario_Conceptos> gxTv_SdtLegajo_Salario_Conceptos_aux ;
   private GXBCLevelCollection<web.SdtLegajo_Salario_Conceptos> gxTv_SdtLegajo_Salario_Conceptos=null ;
}

