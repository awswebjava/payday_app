package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtLegajo_Salario_Conceptos extends GxSilentTrnSdt
{
   public SdtLegajo_Salario_Conceptos( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtLegajo_Salario_Conceptos.class));
   }

   public SdtLegajo_Salario_Conceptos( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle, context, "SdtLegajo_Salario_Conceptos");
      initialize( remoteHandle) ;
   }

   public SdtLegajo_Salario_Conceptos( int remoteHandle ,
                                       StructSdtLegajo_Salario_Conceptos struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtLegajo_Salario_Conceptos( )
   {
      super( new ModelContext(SdtLegajo_Salario_Conceptos.class), "SdtLegajo_Salario_Conceptos");
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
      return (Object[][])(new Object[][]{new Object[]{"LegSuelConcepto", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Conceptos");
      metadata.set("BT", "Legajo_sueldosConceptos");
      metadata.set("PK", "[ \"LegSuelConcepto\" ]");
      metadata.set("PKAssigned", "[ \"LegSuelConcepto\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"ConCodigo\" ],\"FKMap\":[ \"LegSuelConcepto-ConCodigo\" ] },{ \"FK\":[ \"CliCod\",\"EmpCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"EmpCod\",\"LegNumero\",\"LegSuelSec\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSuelConcepto") )
            {
               gxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtLegajo_Salario_Conceptos_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtLegajo_Salario_Conceptos_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtLegajo_Salario_Conceptos_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSuelConcepto_Z") )
            {
               gxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto_Z = oReader.getValue() ;
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
         sName = "Legajo.Salario.Conceptos" ;
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
      oWriter.writeElement("LegSuelConcepto", gxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtLegajo_Salario_Conceptos_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Salario_Conceptos_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtLegajo_Salario_Conceptos_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegSuelConcepto_Z", gxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto_Z);
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
      AddObjectProperty("LegSuelConcepto", gxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtLegajo_Salario_Conceptos_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtLegajo_Salario_Conceptos_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtLegajo_Salario_Conceptos_Initialized, false, includeNonInitialized);
         AddObjectProperty("LegSuelConcepto_Z", gxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtLegajo_Salario_Conceptos sdt )
   {
      if ( sdt.IsDirty("LegSuelConcepto") )
      {
         gxTv_SdtLegajo_Salario_Conceptos_N = (byte)(0) ;
         gxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto = sdt.getgxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto() ;
      }
   }

   public String getgxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto( )
   {
      return gxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto ;
   }

   public void setgxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto( String value )
   {
      gxTv_SdtLegajo_Salario_Conceptos_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Conceptos_Modified = (short)(1) ;
      SetDirty("Legsuelconcepto");
      gxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto = value ;
   }

   public String getgxTv_SdtLegajo_Salario_Conceptos_Mode( )
   {
      return gxTv_SdtLegajo_Salario_Conceptos_Mode ;
   }

   public void setgxTv_SdtLegajo_Salario_Conceptos_Mode( String value )
   {
      gxTv_SdtLegajo_Salario_Conceptos_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtLegajo_Salario_Conceptos_Mode = value ;
   }

   public void setgxTv_SdtLegajo_Salario_Conceptos_Mode_SetNull( )
   {
      gxTv_SdtLegajo_Salario_Conceptos_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtLegajo_Salario_Conceptos_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLegajo_Salario_Conceptos_Modified( )
   {
      return gxTv_SdtLegajo_Salario_Conceptos_Modified ;
   }

   public void setgxTv_SdtLegajo_Salario_Conceptos_Modified( short value )
   {
      gxTv_SdtLegajo_Salario_Conceptos_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtLegajo_Salario_Conceptos_Modified = value ;
   }

   public void setgxTv_SdtLegajo_Salario_Conceptos_Modified_SetNull( )
   {
      gxTv_SdtLegajo_Salario_Conceptos_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtLegajo_Salario_Conceptos_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLegajo_Salario_Conceptos_Initialized( )
   {
      return gxTv_SdtLegajo_Salario_Conceptos_Initialized ;
   }

   public void setgxTv_SdtLegajo_Salario_Conceptos_Initialized( short value )
   {
      gxTv_SdtLegajo_Salario_Conceptos_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Conceptos_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtLegajo_Salario_Conceptos_Initialized = value ;
   }

   public void setgxTv_SdtLegajo_Salario_Conceptos_Initialized_SetNull( )
   {
      gxTv_SdtLegajo_Salario_Conceptos_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtLegajo_Salario_Conceptos_Initialized_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto_Z( )
   {
      return gxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto_Z ;
   }

   public void setgxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto_Z( String value )
   {
      gxTv_SdtLegajo_Salario_Conceptos_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Conceptos_Modified = (short)(1) ;
      SetDirty("Legsuelconcepto_Z");
      gxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto_Z = value ;
   }

   public void setgxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto_Z_SetNull( )
   {
      gxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto_Z = "" ;
      SetDirty("Legsuelconcepto_Z");
   }

   public boolean getgxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto = "" ;
      gxTv_SdtLegajo_Salario_Conceptos_N = (byte)(1) ;
      gxTv_SdtLegajo_Salario_Conceptos_Mode = "" ;
      gxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtLegajo_Salario_Conceptos_N ;
   }

   public web.SdtLegajo_Salario_Conceptos Clone( )
   {
      return (web.SdtLegajo_Salario_Conceptos)(clone()) ;
   }

   public void setStruct( web.StructSdtLegajo_Salario_Conceptos struct )
   {
      setgxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto(struct.getLegsuelconcepto());
      setgxTv_SdtLegajo_Salario_Conceptos_Mode(struct.getMode());
      setgxTv_SdtLegajo_Salario_Conceptos_Modified(struct.getModified());
      setgxTv_SdtLegajo_Salario_Conceptos_Initialized(struct.getInitialized());
      setgxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto_Z(struct.getLegsuelconcepto_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtLegajo_Salario_Conceptos getStruct( )
   {
      web.StructSdtLegajo_Salario_Conceptos struct = new web.StructSdtLegajo_Salario_Conceptos ();
      struct.setLegsuelconcepto(getgxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto());
      struct.setMode(getgxTv_SdtLegajo_Salario_Conceptos_Mode());
      struct.setModified(getgxTv_SdtLegajo_Salario_Conceptos_Modified());
      struct.setInitialized(getgxTv_SdtLegajo_Salario_Conceptos_Initialized());
      struct.setLegsuelconcepto_Z(getgxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto_Z());
      return struct ;
   }

   private byte gxTv_SdtLegajo_Salario_Conceptos_N ;
   private short gxTv_SdtLegajo_Salario_Conceptos_Modified ;
   private short gxTv_SdtLegajo_Salario_Conceptos_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto ;
   private String gxTv_SdtLegajo_Salario_Conceptos_Mode ;
   private String gxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto_Z ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
}

