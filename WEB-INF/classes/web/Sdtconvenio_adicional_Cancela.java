package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtconvenio_adicional_Cancela extends GxSilentTrnSdt
{
   public Sdtconvenio_adicional_Cancela( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(Sdtconvenio_adicional_Cancela.class));
   }

   public Sdtconvenio_adicional_Cancela( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle, context, "Sdtconvenio_adicional_Cancela");
      initialize( remoteHandle) ;
   }

   public Sdtconvenio_adicional_Cancela( int remoteHandle ,
                                         StructSdtconvenio_adicional_Cancela struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public Sdtconvenio_adicional_Cancela( )
   {
      super( new ModelContext(Sdtconvenio_adicional_Cancela.class), "Sdtconvenio_adicional_Cancela");
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
      return (Object[][])(new Object[][]{new Object[]{"ConveAdiSitCancela", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Cancela");
      metadata.set("BT", "convenio_adicionalCancela");
      metadata.set("PK", "[ \"ConveAdiSitCancela\" ]");
      metadata.set("PKAssigned", "[ \"ConveAdiSitCancela\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"CliPaiConve\",\"CliConvenio\",\"ConveAdicod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliPaiConve\",\"CliConvenio\" ],\"FKMap\":[  ] },{ \"FK\":[ \"SitCodigo\" ],\"FKMap\":[ \"ConveAdiSitCancela-SitCodigo\" ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiSitCancela") )
            {
               gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancela = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiSitCancDes") )
            {
               gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancdes = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiSitCanRelSec") )
            {
               gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcanrelsec = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_Sdtconvenio_adicional_Cancela_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_Sdtconvenio_adicional_Cancela_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_Sdtconvenio_adicional_Cancela_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiSitCancela_Z") )
            {
               gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancela_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiSitCancDes_Z") )
            {
               gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancdes_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiSitCanRelSec_Z") )
            {
               gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcanrelsec_Z = (int)(getnumericvalue(oReader.getValue())) ;
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
         sName = "convenio_adicional.Cancela" ;
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
      oWriter.writeElement("ConveAdiSitCancela", gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancela);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveAdiSitCancDes", gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancdes);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveAdiSitCanRelSec", GXutil.trim( GXutil.str( gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcanrelsec, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_Sdtconvenio_adicional_Cancela_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_Sdtconvenio_adicional_Cancela_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_Sdtconvenio_adicional_Cancela_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveAdiSitCancela_Z", gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancela_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveAdiSitCancDes_Z", gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancdes_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveAdiSitCanRelSec_Z", GXutil.trim( GXutil.str( gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcanrelsec_Z, 6, 0)));
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
      AddObjectProperty("ConveAdiSitCancela", gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancela, false, includeNonInitialized);
      AddObjectProperty("ConveAdiSitCancDes", gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancdes, false, includeNonInitialized);
      AddObjectProperty("ConveAdiSitCanRelSec", gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcanrelsec, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_Sdtconvenio_adicional_Cancela_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_Sdtconvenio_adicional_Cancela_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_Sdtconvenio_adicional_Cancela_Initialized, false, includeNonInitialized);
         AddObjectProperty("ConveAdiSitCancela_Z", gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancela_Z, false, includeNonInitialized);
         AddObjectProperty("ConveAdiSitCancDes_Z", gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancdes_Z, false, includeNonInitialized);
         AddObjectProperty("ConveAdiSitCanRelSec_Z", gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcanrelsec_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.Sdtconvenio_adicional_Cancela sdt )
   {
      if ( sdt.IsDirty("ConveAdiSitCancela") )
      {
         gxTv_Sdtconvenio_adicional_Cancela_N = (byte)(0) ;
         gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancela = sdt.getgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancela() ;
      }
      if ( sdt.IsDirty("ConveAdiSitCancDes") )
      {
         gxTv_Sdtconvenio_adicional_Cancela_N = (byte)(0) ;
         gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancdes = sdt.getgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancdes() ;
      }
      if ( sdt.IsDirty("ConveAdiSitCanRelSec") )
      {
         gxTv_Sdtconvenio_adicional_Cancela_N = (byte)(0) ;
         gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcanrelsec = sdt.getgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcanrelsec() ;
      }
   }

   public String getgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancela( )
   {
      return gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancela ;
   }

   public void setgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancela( String value )
   {
      gxTv_Sdtconvenio_adicional_Cancela_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_Cancela_Modified = (short)(1) ;
      SetDirty("Conveadisitcancela");
      gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancela = value ;
   }

   public String getgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancdes( )
   {
      return gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancdes ;
   }

   public void setgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancdes( String value )
   {
      gxTv_Sdtconvenio_adicional_Cancela_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_Cancela_Modified = (short)(1) ;
      SetDirty("Conveadisitcancdes");
      gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancdes = value ;
   }

   public int getgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcanrelsec( )
   {
      return gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcanrelsec ;
   }

   public void setgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcanrelsec( int value )
   {
      gxTv_Sdtconvenio_adicional_Cancela_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_Cancela_Modified = (short)(1) ;
      SetDirty("Conveadisitcanrelsec");
      gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcanrelsec = value ;
   }

   public String getgxTv_Sdtconvenio_adicional_Cancela_Mode( )
   {
      return gxTv_Sdtconvenio_adicional_Cancela_Mode ;
   }

   public void setgxTv_Sdtconvenio_adicional_Cancela_Mode( String value )
   {
      gxTv_Sdtconvenio_adicional_Cancela_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_Sdtconvenio_adicional_Cancela_Mode = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_Cancela_Mode_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_Cancela_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_Sdtconvenio_adicional_Cancela_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtconvenio_adicional_Cancela_Modified( )
   {
      return gxTv_Sdtconvenio_adicional_Cancela_Modified ;
   }

   public void setgxTv_Sdtconvenio_adicional_Cancela_Modified( short value )
   {
      gxTv_Sdtconvenio_adicional_Cancela_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_Sdtconvenio_adicional_Cancela_Modified = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_Cancela_Modified_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_Cancela_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_Sdtconvenio_adicional_Cancela_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtconvenio_adicional_Cancela_Initialized( )
   {
      return gxTv_Sdtconvenio_adicional_Cancela_Initialized ;
   }

   public void setgxTv_Sdtconvenio_adicional_Cancela_Initialized( short value )
   {
      gxTv_Sdtconvenio_adicional_Cancela_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_Cancela_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_Sdtconvenio_adicional_Cancela_Initialized = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_Cancela_Initialized_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_Cancela_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_Sdtconvenio_adicional_Cancela_Initialized_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancela_Z( )
   {
      return gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancela_Z ;
   }

   public void setgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancela_Z( String value )
   {
      gxTv_Sdtconvenio_adicional_Cancela_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_Cancela_Modified = (short)(1) ;
      SetDirty("Conveadisitcancela_Z");
      gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancela_Z = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancela_Z_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancela_Z = "" ;
      SetDirty("Conveadisitcancela_Z");
   }

   public boolean getgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancela_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancdes_Z( )
   {
      return gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancdes_Z ;
   }

   public void setgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancdes_Z( String value )
   {
      gxTv_Sdtconvenio_adicional_Cancela_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_Cancela_Modified = (short)(1) ;
      SetDirty("Conveadisitcancdes_Z");
      gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancdes_Z = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancdes_Z_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancdes_Z = "" ;
      SetDirty("Conveadisitcancdes_Z");
   }

   public boolean getgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancdes_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcanrelsec_Z( )
   {
      return gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcanrelsec_Z ;
   }

   public void setgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcanrelsec_Z( int value )
   {
      gxTv_Sdtconvenio_adicional_Cancela_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_Cancela_Modified = (short)(1) ;
      SetDirty("Conveadisitcanrelsec_Z");
      gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcanrelsec_Z = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcanrelsec_Z_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcanrelsec_Z = 0 ;
      SetDirty("Conveadisitcanrelsec_Z");
   }

   public boolean getgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcanrelsec_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancela = "" ;
      gxTv_Sdtconvenio_adicional_Cancela_N = (byte)(1) ;
      gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancdes = "" ;
      gxTv_Sdtconvenio_adicional_Cancela_Mode = "" ;
      gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancela_Z = "" ;
      gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancdes_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtconvenio_adicional_Cancela_N ;
   }

   public web.Sdtconvenio_adicional_Cancela Clone( )
   {
      return (web.Sdtconvenio_adicional_Cancela)(clone()) ;
   }

   public void setStruct( web.StructSdtconvenio_adicional_Cancela struct )
   {
      setgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancela(struct.getConveadisitcancela());
      setgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancdes(struct.getConveadisitcancdes());
      setgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcanrelsec(struct.getConveadisitcanrelsec());
      setgxTv_Sdtconvenio_adicional_Cancela_Mode(struct.getMode());
      setgxTv_Sdtconvenio_adicional_Cancela_Modified(struct.getModified());
      setgxTv_Sdtconvenio_adicional_Cancela_Initialized(struct.getInitialized());
      setgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancela_Z(struct.getConveadisitcancela_Z());
      setgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancdes_Z(struct.getConveadisitcancdes_Z());
      setgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcanrelsec_Z(struct.getConveadisitcanrelsec_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtconvenio_adicional_Cancela getStruct( )
   {
      web.StructSdtconvenio_adicional_Cancela struct = new web.StructSdtconvenio_adicional_Cancela ();
      struct.setConveadisitcancela(getgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancela());
      struct.setConveadisitcancdes(getgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancdes());
      struct.setConveadisitcanrelsec(getgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcanrelsec());
      struct.setMode(getgxTv_Sdtconvenio_adicional_Cancela_Mode());
      struct.setModified(getgxTv_Sdtconvenio_adicional_Cancela_Modified());
      struct.setInitialized(getgxTv_Sdtconvenio_adicional_Cancela_Initialized());
      struct.setConveadisitcancela_Z(getgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancela_Z());
      struct.setConveadisitcancdes_Z(getgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancdes_Z());
      struct.setConveadisitcanrelsec_Z(getgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcanrelsec_Z());
      return struct ;
   }

   private byte gxTv_Sdtconvenio_adicional_Cancela_N ;
   private short gxTv_Sdtconvenio_adicional_Cancela_Modified ;
   private short gxTv_Sdtconvenio_adicional_Cancela_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcanrelsec ;
   private int gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcanrelsec_Z ;
   private String gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancela ;
   private String gxTv_Sdtconvenio_adicional_Cancela_Mode ;
   private String gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancela_Z ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancdes ;
   private String gxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancdes_Z ;
}

