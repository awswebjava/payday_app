package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtparm_iniPerCCLic extends GxUserType
{
   public Sdtparm_iniPerCCLic( )
   {
      this(  new ModelContext(Sdtparm_iniPerCCLic.class));
   }

   public Sdtparm_iniPerCCLic( ModelContext context )
   {
      super( context, "Sdtparm_iniPerCCLic");
   }

   public Sdtparm_iniPerCCLic( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle, context, "Sdtparm_iniPerCCLic");
   }

   public Sdtparm_iniPerCCLic( StructSdtparm_iniPerCCLic struct )
   {
      this();
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
               gxTv_Sdtparm_iniPerCCLic_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod") )
            {
               gxTv_Sdtparm_iniPerCCLic_Empcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNumero") )
            {
               gxTv_Sdtparm_iniPerCCLic_Legnumero = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "desdeAnio") )
            {
               gxTv_Sdtparm_iniPerCCLic_Desdeanio = (short)(getnumericvalue(oReader.getValue())) ;
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
         sName = "parm_iniPerCCLic" ;
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
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_Sdtparm_iniPerCCLic_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCod", GXutil.trim( GXutil.str( gxTv_Sdtparm_iniPerCCLic_Empcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegNumero", GXutil.trim( GXutil.str( gxTv_Sdtparm_iniPerCCLic_Legnumero, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("desdeAnio", GXutil.trim( GXutil.str( gxTv_Sdtparm_iniPerCCLic_Desdeanio, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
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
      AddObjectProperty("CliCod", gxTv_Sdtparm_iniPerCCLic_Clicod, false, false);
      AddObjectProperty("EmpCod", gxTv_Sdtparm_iniPerCCLic_Empcod, false, false);
      AddObjectProperty("LegNumero", gxTv_Sdtparm_iniPerCCLic_Legnumero, false, false);
      AddObjectProperty("desdeAnio", gxTv_Sdtparm_iniPerCCLic_Desdeanio, false, false);
   }

   public int getgxTv_Sdtparm_iniPerCCLic_Clicod( )
   {
      return gxTv_Sdtparm_iniPerCCLic_Clicod ;
   }

   public void setgxTv_Sdtparm_iniPerCCLic_Clicod( int value )
   {
      gxTv_Sdtparm_iniPerCCLic_N = (byte)(0) ;
      gxTv_Sdtparm_iniPerCCLic_Clicod = value ;
   }

   public short getgxTv_Sdtparm_iniPerCCLic_Empcod( )
   {
      return gxTv_Sdtparm_iniPerCCLic_Empcod ;
   }

   public void setgxTv_Sdtparm_iniPerCCLic_Empcod( short value )
   {
      gxTv_Sdtparm_iniPerCCLic_N = (byte)(0) ;
      gxTv_Sdtparm_iniPerCCLic_Empcod = value ;
   }

   public int getgxTv_Sdtparm_iniPerCCLic_Legnumero( )
   {
      return gxTv_Sdtparm_iniPerCCLic_Legnumero ;
   }

   public void setgxTv_Sdtparm_iniPerCCLic_Legnumero( int value )
   {
      gxTv_Sdtparm_iniPerCCLic_N = (byte)(0) ;
      gxTv_Sdtparm_iniPerCCLic_Legnumero = value ;
   }

   public short getgxTv_Sdtparm_iniPerCCLic_Desdeanio( )
   {
      return gxTv_Sdtparm_iniPerCCLic_Desdeanio ;
   }

   public void setgxTv_Sdtparm_iniPerCCLic_Desdeanio( short value )
   {
      gxTv_Sdtparm_iniPerCCLic_N = (byte)(0) ;
      gxTv_Sdtparm_iniPerCCLic_Desdeanio = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtparm_iniPerCCLic_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtparm_iniPerCCLic_N ;
   }

   public web.Sdtparm_iniPerCCLic Clone( )
   {
      return (web.Sdtparm_iniPerCCLic)(clone()) ;
   }

   public void setStruct( web.StructSdtparm_iniPerCCLic struct )
   {
      setgxTv_Sdtparm_iniPerCCLic_Clicod(struct.getClicod());
      setgxTv_Sdtparm_iniPerCCLic_Empcod(struct.getEmpcod());
      setgxTv_Sdtparm_iniPerCCLic_Legnumero(struct.getLegnumero());
      setgxTv_Sdtparm_iniPerCCLic_Desdeanio(struct.getDesdeanio());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtparm_iniPerCCLic getStruct( )
   {
      web.StructSdtparm_iniPerCCLic struct = new web.StructSdtparm_iniPerCCLic ();
      struct.setClicod(getgxTv_Sdtparm_iniPerCCLic_Clicod());
      struct.setEmpcod(getgxTv_Sdtparm_iniPerCCLic_Empcod());
      struct.setLegnumero(getgxTv_Sdtparm_iniPerCCLic_Legnumero());
      struct.setDesdeanio(getgxTv_Sdtparm_iniPerCCLic_Desdeanio());
      return struct ;
   }

   protected byte gxTv_Sdtparm_iniPerCCLic_N ;
   protected short gxTv_Sdtparm_iniPerCCLic_Empcod ;
   protected short gxTv_Sdtparm_iniPerCCLic_Desdeanio ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_Sdtparm_iniPerCCLic_Clicod ;
   protected int gxTv_Sdtparm_iniPerCCLic_Legnumero ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

