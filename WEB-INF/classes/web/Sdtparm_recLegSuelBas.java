package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtparm_recLegSuelBas extends GxUserType
{
   public Sdtparm_recLegSuelBas( )
   {
      this(  new ModelContext(Sdtparm_recLegSuelBas.class));
   }

   public Sdtparm_recLegSuelBas( ModelContext context )
   {
      super( context, "Sdtparm_recLegSuelBas");
   }

   public Sdtparm_recLegSuelBas( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle, context, "Sdtparm_recLegSuelBas");
   }

   public Sdtparm_recLegSuelBas( StructSdtparm_recLegSuelBas struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliPaiCod") )
            {
               gxTv_Sdtparm_recLegSuelBas_Clipaicod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod") )
            {
               gxTv_Sdtparm_recLegSuelBas_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod") )
            {
               gxTv_Sdtparm_recLegSuelBas_Empcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "parmLegNumero") )
            {
               gxTv_Sdtparm_recLegSuelBas_Parmlegnumero = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "trnPalabra") )
            {
               gxTv_Sdtparm_recLegSuelBas_Trnpalabra = oReader.getValue() ;
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
         sName = "parm_recLegSuelBas" ;
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
      oWriter.writeElement("CliPaiCod", GXutil.trim( GXutil.str( gxTv_Sdtparm_recLegSuelBas_Clipaicod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_Sdtparm_recLegSuelBas_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCod", GXutil.trim( GXutil.str( gxTv_Sdtparm_recLegSuelBas_Empcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("parmLegNumero", GXutil.trim( GXutil.str( gxTv_Sdtparm_recLegSuelBas_Parmlegnumero, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("trnPalabra", gxTv_Sdtparm_recLegSuelBas_Trnpalabra);
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
      AddObjectProperty("CliPaiCod", gxTv_Sdtparm_recLegSuelBas_Clipaicod, false, false);
      AddObjectProperty("CliCod", gxTv_Sdtparm_recLegSuelBas_Clicod, false, false);
      AddObjectProperty("EmpCod", gxTv_Sdtparm_recLegSuelBas_Empcod, false, false);
      AddObjectProperty("parmLegNumero", gxTv_Sdtparm_recLegSuelBas_Parmlegnumero, false, false);
      AddObjectProperty("trnPalabra", gxTv_Sdtparm_recLegSuelBas_Trnpalabra, false, false);
   }

   public short getgxTv_Sdtparm_recLegSuelBas_Clipaicod( )
   {
      return gxTv_Sdtparm_recLegSuelBas_Clipaicod ;
   }

   public void setgxTv_Sdtparm_recLegSuelBas_Clipaicod( short value )
   {
      gxTv_Sdtparm_recLegSuelBas_N = (byte)(0) ;
      gxTv_Sdtparm_recLegSuelBas_Clipaicod = value ;
   }

   public int getgxTv_Sdtparm_recLegSuelBas_Clicod( )
   {
      return gxTv_Sdtparm_recLegSuelBas_Clicod ;
   }

   public void setgxTv_Sdtparm_recLegSuelBas_Clicod( int value )
   {
      gxTv_Sdtparm_recLegSuelBas_N = (byte)(0) ;
      gxTv_Sdtparm_recLegSuelBas_Clicod = value ;
   }

   public short getgxTv_Sdtparm_recLegSuelBas_Empcod( )
   {
      return gxTv_Sdtparm_recLegSuelBas_Empcod ;
   }

   public void setgxTv_Sdtparm_recLegSuelBas_Empcod( short value )
   {
      gxTv_Sdtparm_recLegSuelBas_N = (byte)(0) ;
      gxTv_Sdtparm_recLegSuelBas_Empcod = value ;
   }

   public int getgxTv_Sdtparm_recLegSuelBas_Parmlegnumero( )
   {
      return gxTv_Sdtparm_recLegSuelBas_Parmlegnumero ;
   }

   public void setgxTv_Sdtparm_recLegSuelBas_Parmlegnumero( int value )
   {
      gxTv_Sdtparm_recLegSuelBas_N = (byte)(0) ;
      gxTv_Sdtparm_recLegSuelBas_Parmlegnumero = value ;
   }

   public String getgxTv_Sdtparm_recLegSuelBas_Trnpalabra( )
   {
      return gxTv_Sdtparm_recLegSuelBas_Trnpalabra ;
   }

   public void setgxTv_Sdtparm_recLegSuelBas_Trnpalabra( String value )
   {
      gxTv_Sdtparm_recLegSuelBas_N = (byte)(0) ;
      gxTv_Sdtparm_recLegSuelBas_Trnpalabra = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtparm_recLegSuelBas_N = (byte)(1) ;
      gxTv_Sdtparm_recLegSuelBas_Trnpalabra = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtparm_recLegSuelBas_N ;
   }

   public web.Sdtparm_recLegSuelBas Clone( )
   {
      return (web.Sdtparm_recLegSuelBas)(clone()) ;
   }

   public void setStruct( web.StructSdtparm_recLegSuelBas struct )
   {
      setgxTv_Sdtparm_recLegSuelBas_Clipaicod(struct.getClipaicod());
      setgxTv_Sdtparm_recLegSuelBas_Clicod(struct.getClicod());
      setgxTv_Sdtparm_recLegSuelBas_Empcod(struct.getEmpcod());
      setgxTv_Sdtparm_recLegSuelBas_Parmlegnumero(struct.getParmlegnumero());
      setgxTv_Sdtparm_recLegSuelBas_Trnpalabra(struct.getTrnpalabra());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtparm_recLegSuelBas getStruct( )
   {
      web.StructSdtparm_recLegSuelBas struct = new web.StructSdtparm_recLegSuelBas ();
      struct.setClipaicod(getgxTv_Sdtparm_recLegSuelBas_Clipaicod());
      struct.setClicod(getgxTv_Sdtparm_recLegSuelBas_Clicod());
      struct.setEmpcod(getgxTv_Sdtparm_recLegSuelBas_Empcod());
      struct.setParmlegnumero(getgxTv_Sdtparm_recLegSuelBas_Parmlegnumero());
      struct.setTrnpalabra(getgxTv_Sdtparm_recLegSuelBas_Trnpalabra());
      return struct ;
   }

   protected byte gxTv_Sdtparm_recLegSuelBas_N ;
   protected short gxTv_Sdtparm_recLegSuelBas_Clipaicod ;
   protected short gxTv_Sdtparm_recLegSuelBas_Empcod ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_Sdtparm_recLegSuelBas_Clicod ;
   protected int gxTv_Sdtparm_recLegSuelBas_Parmlegnumero ;
   protected String gxTv_Sdtparm_recLegSuelBas_Trnpalabra ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

